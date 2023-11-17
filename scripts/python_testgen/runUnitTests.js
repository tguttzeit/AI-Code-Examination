const fs = require('fs');
const path = require('path');
const util = require('util');
const exec = util.promisify(require('child_process').exec);
const os = require('os');

// ---------------------------------- Initialization ----------------------------------

// Adjustable Parameters
const timeOutSeconds = 5;

// Paths
const outputPath = 'reports/python_testgen/tg_pyUnitTestReport.json';
const fullOutputPath = 'reports/python_testgen/resources/tg_pyFullUnitTestReport.json';
const testDirectories = ["py_testgen_app/test/ChatGPT", "py_testgen_app/test/Copilot"];

// Check the operating system and set the paths to the JUnit and HamCrest JAR file accordingly
// Unix separators are used as default
const unitTestCmd = `timeout ${timeOutSeconds} python3 -m unittest`;

const configData = JSON.parse(fs.readFileSync('config/consideredAlgorithms.json', 'utf8'));
const consideredAlgorithms = configData.considered.map(entry => entry[0]);

// Create all needed arrays and objects
const testFiles = [];
const results = {
    "ChatGPT": {},
    "Copilot": {}
};
const fullResults = {
    "ChatGPT": {},
    "Copilot": {}
};

// ---------------------------------- Main function ----------------------------------

// Create json object, find all test files and run the python unit test command for each file
async function main() {
    for (const directory of testDirectories) {
        findFiles(directory);
    }
    console.log()
    await runUnitTests(results);

    fs.writeFileSync(outputPath, JSON.stringify(results, null, 0)); //indentation depth = 0, looks better in this case
    fs.writeFileSync(fullOutputPath, JSON.stringify(fullResults, null, 2));
}

// ---------------------------------- Functions ----------------------------------

// Find all Python test files in the project directory and its subdirectories
function findFiles(directory) {
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

// Run the jUnit test command and return 1 if it fails and 0 if it succeeds
async function runUnitTests(results) {
    for (const testFile of testFiles) {
        const sliceValue = "py_testgen_app/test/".length;
        const [aiModel, algorithm, reference] = getAIModelAndAlgorithmAndReference(testFile, sliceValue);
        if (!results[aiModel][algorithm]) {
            results[aiModel][algorithm] = {};
        }
        if (!results[aiModel][algorithm][reference]) {
            results[aiModel][algorithm][reference] = [];
        }
        if (!fullResults[aiModel][algorithm]) {
            fullResults[aiModel][algorithm] = {};
        }
        if (!fullResults[aiModel][algorithm][reference]) {
            fullResults[aiModel][algorithm][reference] = [];
        }
        const result = await runUnitTestCmd(testFile);
        await results[aiModel][algorithm][reference].push(result);
        await fullResults[aiModel][algorithm][reference].push({
            path: testFile,
            result: result
        });
    }
}

// ---------------------------------- Helper functions ----------------------------------

// Get the AI model and algorithm from the file path
function getAIModelAndAlgorithmAndReference(filePath, sliceValue = 18) {
    const parts = filePath.replaceAll('\\', '/').slice(sliceValue).split("/");
    return [parts[0], parts[1], parts[2]];
}

// Run the JUnit command and return 1 if it fails and 0 if it succeeds
async function runUnitTestCmd(testFile) {
    try {
        const { stdout, stderr } = await exec(`${unitTestCmd} ${testFile}`);
        console.log(`SUCCESS! ${testFile}`);
        return 0;
    } catch (error) {
        console.log(`FAILED! ${testFile}`);
        return 1;
    }
}

main();
