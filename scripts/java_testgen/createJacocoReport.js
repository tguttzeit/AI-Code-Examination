const fs = require('fs');
const { execSync } = require('child_process');
const csv = require('csv-parser');

// ---------------------------------- Initialization ----------------------------------

// Paths
const rawReportPath = 'reports/java_testgen/resources/rawJacocoReport.csv';
const fullReportPath = 'reports/java_testgen/resources/fullJacocoReport.json';
const outputPath = 'reports/java_testgen/resources/tg_javaCoverageReport.json';
const convertedOutputPath = 'reports/java_testgen/tg_javaConvertedCoverageReport.json';
const classFilesPath = 'java_testgen_app/bin';

// Global Arrays
// Find considered algorithms
const algorithmsCfg = JSON.parse(fs.readFileSync('config/consideredAlgorithms.json', 'utf8'));
const consideredAlgorithms = algorithmsCfg.considered.map(algorithm => algorithm[0]);
// Create all needed arrays and objects
const aiModels = ["ChatGPT", "Copilot"];
const codeReferences = ["AIGenerated", "BookExampleCode", "PromptOnly"];
const rawResults = [];
const cleanResult = [];
const results = {
    "ChatGPT": {},
    "Copilot": {}
};
const convertedResults = {
    "ChatGPT": {},
    "Copilot": {}
};


// ---------------------------------- Main ----------------------------------

async function main() {
    prepareAndCreateCSV();
    await parseCSV();
    preProcessJacocoReport();
    createJacocoReport();
    convertJacocoReport();
    writeFiles();
}

// ---------------------------------- Functions ----------------------------------

// Create the directory and the CSV file from jacoco.exec
function prepareAndCreateCSV() {
    fs.mkdirSync('reports/java_testgen/resources', { recursive: true });
    execSync(`touch ${rawReportPath}`);

    execSync(`java -jar lib/jacococli.jar report jacoco.exec --classfiles ${classFilesPath} --csv ${rawReportPath}`)
    //fs.rmSync('jacoco.exec');
}

// Parse the CSV file
async function parseCSV() {
    const csvData = fs.readFileSync(rawReportPath, 'utf8');
    csv({ headers: true })
        .on('data', (data) => {
            rawResults.push(data);
        })
        .on('end', () => {
            console.log('CSV file successfully processed');
        })
        .write(csvData);
}

// Process CSV data to create a coverage.py-like report
function preProcessJacocoReport() {
    const fusedObjects = {};
    for (const object of rawResults) {
        // Skip the header lines and test classes
        if (!(object._0 === 'GROUP' || object._2.endsWith("Test"))) {
            const package = object._1;
            // Since the CSV file contains multiple lines for one file, we need to fuse them together
            if (!fusedObjects[package]) {
                let missed_branches = parseInt(object._5);
                let covered_branches = parseInt(object._6);
                let missed_lines = parseInt(object._7);
                let covered_lines = parseInt(object._8);
                const className = object._2.split(".")[0];
                const filePath = `${object._1.replaceAll(".", "/")}/${className}.java`;
                fusedObjects[package] = {
                    path: filePath,
                    covered_lines: covered_lines,
                    num_statements: 0,
                    percent_covered: 0,
                    percent_covered_display: ``,
                    missing_lines: missed_lines,
                    num_branches: 0,
                    covered_branches: covered_branches,
                    missing_branches: missed_branches
                }
            }
            fusedObjects[package].covered_lines += parseInt(object._7);
            fusedObjects[package].missing_lines += parseInt(object._8);
            fusedObjects[package].covered_branches += parseInt(object._6);
            fusedObjects[package].missing_branches += parseInt(object._5);
        }
    }
    for (const fusedObject of Object.values(fusedObjects)) {
        const num_branches = fusedObject.missing_branches + fusedObject.covered_branches;
        const num_statements = fusedObject.missing_lines + fusedObject.covered_lines;
        const percent_covered = ((fusedObject.covered_branches + fusedObject.covered_lines) / (num_branches + num_statements)) * 100;
        fusedObject.num_branches = num_branches;
        fusedObject.num_statements = num_statements;
        fusedObject.percent_covered = percent_covered;
        fusedObject.percent_covered_display = `${Math.round(percent_covered)}`;
        cleanResult.push(fusedObject);
    }
}

// Convert the report to the format sorted by AI model and algorithm
function createJacocoReport() {
    for (const object of cleanResult) {
        const [aiModel, algorithm, reference] = getAIModelAndAlgorithmAndReference(object.path, sliceValue = 0);
        if (!results[aiModel][algorithm]) {
            results[aiModel][algorithm] = {};
        }
        if (!results[aiModel][algorithm][reference]) {
            results[aiModel][algorithm][reference] = [];
        }
        results[aiModel][algorithm][reference].push(object);
    }
}

// Filter the data to only include coverage percentages for branch, line and total coverage
function convertJacocoReport() {
    for (const ai of aiModels) {
        for (const algorithm of consideredAlgorithms) {
            for (const reference of codeReferences) {
                for (const object of results[ai][algorithm][reference]) {
                    const totalCoverage = Math.round(object.percent_covered * 100) / 100;
                    if (!convertedResults[ai][algorithm]) {
                        convertedResults[ai][algorithm] = {};
                    }
                    if (!convertedResults[ai][algorithm][reference]) {
                        convertedResults[ai][algorithm][reference] = [];
                    }
                    convertedResults[ai][algorithm][reference].push(totalCoverage);
                }
            }
        }
    }
}

// Create the directory and write the files
function writeFiles() {
    if (!fs.existsSync("reports/java_testgen/resources")){
        fs.mkdirSync("reports/java_testgen/resources");
    }
    fs.writeFileSync(fullReportPath, JSON.stringify(cleanResult, null, 2));
    fs.writeFileSync(outputPath, JSON.stringify(results, null, 2));
    fs.writeFileSync(convertedOutputPath, JSON.stringify(convertedResults, null, 2));
}

// ---------------------------------- Helper functions ----------------------------------

// Get the AI model and algorithm from the file path
function getAIModelAndAlgorithmAndReference(filePath) {
    const parts = filePath.split("/");
    return [parts[0], parts[1], parts[2]];
}

main();
