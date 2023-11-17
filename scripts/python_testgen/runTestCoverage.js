const { create } = require('domain');
const fs = require('fs');
const path = require('path');
const util = require('util');
const exec = util.promisify(require('child_process').exec);

// ---------------------------------- Initialization ----------------------------------

// Adjustable Parameters
const timeOutSeconds = 5;

// Paths
const coverageFilePath = 'reports/python_testgen/resources/coverageFiles/.coverage';
const rawOutputPath = 'reports/python_testgen/resources/tg_pyRawCoverageReport.json';
const outputPath = 'reports/python_testgen/tg_pyCoverageReport.json';
const convertedOutputPath = 'reports/python_testgen/tg_pyConvertedCoverageReport.json';

// Commands
const pyCoverageRunCmd = `timeout ${timeOutSeconds} coverage run -p -m --branch --data-file=${coverageFilePath} unittest`;
const pyCoverageReportCmd = `coverage json --pretty-print -o ${rawOutputPath}`;

// Global Array
const aiModels = ["ChatGPT", "Copilot"];
const codeReferences = ["PromptOnly", "AIGenerated", "BookExampleCode"]
const testFiles = [];
const results = {
    "ChatGPT": {},
    "Copilot": {}
};
const convertedResults = {
    "ChatGPT": {},
    "Copilot": {}
};

// Read considered algorithms from config file
const configData = JSON.parse(fs.readFileSync('config/consideredAlgorithms.json', 'utf8'));
const consideredAlgorithms = configData.considered.map(entry => entry[0]);


// ---------------------------------- Main function ----------------------------------

// Create json object, find all test files and run the python unit test command for each file
async function main() {
    await findFiles('py_testgen_app/test/');
    await runCmd(`coverage erase`);
    console.log(`Collecting coverage data for ${testFiles.length} test files...`);
    await runCoverageUnitTest();
    console.log(`Combining coverage data...`);
    await runCmd(`coverage combine reports/python_testgen/resources/coverageFiles/`);
    await runCmd(pyCoverageReportCmd);
    console.log(`Full Coverage Report created: ${rawOutputPath}`);
    await runCmd(`coverage erase`);
    postProcessRawReport();
    convertReport();
    console.log(`Converted Coverage Report created: ${convertedOutputPath}`);
}

// ---------------------------------- Functions ----------------------------------

// Find all Python test files in the project directory and its subdirectories
async function findFiles(directory) {
    const files = fs.readdirSync(directory);
    for (const file of files) {
        const filePath = path.join(directory, file);
        const fileStat = fs.statSync(filePath);
        const sliceValue = "py_testgen_app/test/".length;
        const algorithm = getAIModelAndAlgorithmAndReference(filePath, sliceValue)[1];
        if (fileStat.isDirectory()) {
            findFiles(filePath);
        } else if (file.endsWith("_test.py") && consideredAlgorithms.includes(algorithm)) {
            testFiles.push(filePath);
        }
    }
}

async function runCoverageUnitTest() {
    for (const testFile of testFiles) {
        await runCmd(`${pyCoverageRunCmd} ${testFile}`);
    }
}

function postProcessRawReport() {
    const rawReport = JSON.parse(fs.readFileSync(rawOutputPath, 'utf8'));
    for (const filePath of Object.keys(rawReport.files)) {
        if (filePath.includes('py_testgen_app/src/')) {
            const [aiModel, algorithm, reference] = getAIModelAndAlgorithmAndReference(filePath, sliceValue = `py_testgen_app/src/`.length);
            createResultObjectFields(aiModel, algorithm, reference);
            results[aiModel][algorithm][reference].push(rawReport.files[filePath].summary);
        }
    }
    // When a test file has a coverage of 0%, it is not included in the raw report, therefore we need to add it manually with a dummy summary
    for (const file of testFiles) {
        referencedSrcFile = file.replaceAll('\\', '/').replace('py_testgen_app/test/', 'py_testgen_app/src/').replace('_test.py', '.py');
        const [aiModel, algorithm, reference] = getAIModelAndAlgorithmAndReference(referencedSrcFile, sliceValue = `py_testgen_app/src/`.length);
        if (!Object.keys(rawReport.files).includes(referencedSrcFile) && consideredAlgorithms.includes(algorithm)) {
            const dummySummary = {
                "covered_lines": 0,
                "num_statements": 100,
                "percent_covered": 0.0,
                "percent_covered_display": "0",
                "missing_lines": 100,
                "excluded_lines": 0,
                "num_branches": 100,
                "num_partial_branches": 0,
                "covered_branches": 0,
                "missing_branches": 100
            }
            if (!results[aiModel][algorithm]) {
                results[aiModel][algorithm] = {};
            }
            if (!results[aiModel][algorithm][reference]) {
                results[aiModel][algorithm][reference] = [];
            }
            results[aiModel][algorithm][reference].push(dummySummary);
        }
    }
    fs.writeFileSync(outputPath, JSON.stringify(results, null, 4));
}

// Filter the data to only include what is needed for the evaluation
function convertReport() {
    for (const ai of aiModels) {
        for (const algorithm of consideredAlgorithms) {
            for (const reference of codeReferences) {
                for (const object of results[ai][algorithm][reference]) {
                    const totalCoverage = Math.round(object.percent_covered * 100) / 100;
                    createResultObjectFields(ai, algorithm, reference); 
                    convertedResults[ai][algorithm][reference].push(totalCoverage);
                }
            }
        }
    }
    fs.writeFileSync(convertedOutputPath, JSON.stringify(convertedResults, null, 2));
}

// ---------------------------------- Helper functions ----------------------------------

// Get the AI model and algorithm from the file path
function getAIModelAndAlgorithmAndReference(filePath, sliceValue = 18) {
    const parts = filePath.replaceAll('\\', '/').slice(sliceValue).split("/");
    return [parts[0], parts[1], parts[2]];
}

async function runCmd(cmd) {
    try {
        const { stdout, stderr } = await exec(cmd);
    } catch (error) {
        // Nothing to do here
    }
}

function createResultObjectFields(aiModel, algorithm, reference) {
    if (!convertedResults[ai][algorithm]) {
        convertedResults[ai][algorithm] = {};
    }
    if (!convertedResults[ai][algorithm][reference]) {
        convertedResults[ai][algorithm][reference] = [];
    }
}

main();
