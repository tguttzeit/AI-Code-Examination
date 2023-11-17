const fs = require('fs');
const path = require('path');
const util = require('util');
const exec = util.promisify(require('child_process').exec);

// ---------------------------------- Initialization ----------------------------------
// Adjustable parameters
const timeOutSeconds = 5;

// Paths
const outputPath = 'reports/python/pythonUnitTestReport.json';
const testFileDirectory = 'py_app/test';

// Global Arrays
// Find considered algorithms
const algorithmsCfg = JSON.parse(fs.readFileSync('config/consideredAlgorithms.json', 'utf8'));
const consideredAlgorithms = algorithmsCfg.considered.map(algorithm => algorithm[0]);
const results = {
    "ChatGPT": {},
    "Copilot": {}
};
const testFiles = [];

// ---------------------------------- Main function ----------------------------------

// Create json object, find all test files and run the python unit test command for each file
async function main() {
    findTestFiles(testFileDirectory);
    console.log(testFiles);
    await runTests();
    writeFiles();
}

// ------------------------------------- Functions -------------------------------------

// Find all files ending on "_test.py" in the test directory
function findTestFiles(directoryPath) {
    const files = fs.readdirSync(directoryPath);
    for (const file of files) {
        const filePath = path.join(directoryPath, file);
        if (fs.statSync(filePath).isDirectory()) {
            findTestFiles(filePath);
        } else if (file.endsWith('_test.py') && !filePath.includes('BookExample')) {
            const [aiModel, algorithm] = getAiModelAndAlgorithm(filePath, sliceValue = "py_app/test/".length);
            if (consideredAlgorithms.includes(algorithm)) {
                testFiles.push(filePath);
            }
        }
    }
}

// Run the python unit test command for each file and save the result in the results array
async function runTests() {
    for (const testFile of testFiles) {
        const [aiModel, algorithm] = getAiModelAndAlgorithm(testFile, sliceValue = "py_app/test/".length);
        if (!results[aiModel][algorithm]) {
            results[aiModel][algorithm] = [];
        }
        const result = await runShellCommand(testFile);
        results[aiModel][algorithm].push(result);
    }
}

async function writeFiles() {
    fs.writeFileSync(outputPath, JSON.stringify(results, null, 0)); //indentation depth = 0, looks better in this case
    console.log("\n======================================================\nUnit Tests finished! ");
    console.log(`See report in ${outputPath}.`);
}

// ---------------------------------- Helper functions ----------------------------------

// Run the python unit test command and return 1 if it fails and 0 if it succeeds
async function runShellCommand(testFile) {
    try {
        // The test fails after running five seconds automatically
        const { stdout, stderr } = await exec(`timeout ${timeOutSeconds} python3 -m unittest ${testFile}`);
        console.log(`SUCCESS! ${testFile}`); //for some reason, the stdout is empty
        return 0;
    } catch (error) {
        console.log(`${error.message}`);
        return 1;
    }
}

// Get the aiModel and algorithm from the file path
function getAiModelAndAlgorithm(filePath, sliceValue) {
    const parts = filePath.replaceAll('\\', '/').slice(sliceValue).split("/");
    return [parts[0], parts[1]];
}

main();