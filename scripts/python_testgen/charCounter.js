const fs = require('fs');
const path = require('path');

// ------------------------ Initialization ------------------------

// Paths
const outputPath = 'reports/python_testgen/tg_pyCharCounts.json';
const fullOutputPath = 'reports/python_testgen/resources/tg_pyFullCharCounts.json';
const codePaths = ['py_testgen_app/test/ChatGPT', "py_testgen_app/test/Copilot"];

// Global Arrays
const testFiles = [];
const results = {
    "ChatGPT": {},
    "Copilot": {}
}
const fullResults = {
    "ChatGPT": {},
    "Copilot": {}
}
// Find considered algorithms
const algorithmsCfg = JSON.parse(fs.readFileSync('config/consideredAlgorithms.json', 'utf8'));
const consideredAlgorithms = algorithmsCfg.considered.map(algorithm => algorithm[0]);

// ------------------------ Main function ------------------------

async function main() {
    console.log("This script needs to be run after the script that checks for uncompilable test files (filterTestGenerations.js)!");
    prepareFiltering();
    countChars();
    outputResults();
}

// ------------------------ Functions ------------------------

// Removes report files, finds all python files and old (unchanged) python test files
function prepareFiltering() {
    // Delete the old report if it exists
    if (fs.existsSync(outputPath)) {
        fs.rmSync(outputPath);
    }
    for (const codePath of codePaths) {
        findFiles(codePath, testFiles);
    }
}

// Count chars for all unchanged files
function countChars() {
    for (const testFile of testFiles) {
        let fileContent;
        let path;
        const respectiveOldFile = testFile.replace('py_testgen_app/test/', 'py_testgen_app/test/');
        if (fs.existsSync(respectiveOldFile)) {
            fileContent = preProcessContent(fs.readFileSync(respectiveOldFile, 'utf8'));
            path = respectiveOldFile;
        }
        else {
            fileContent = preProcessContent(fs.readFileSync(testFile, 'utf8'));
            path = testFile;
        }
        const sliceValue = `py_testgen_app/test/`.length;
        const [aiModel, algorithm, reference] = getAIModelAndAlgorithmAndReference(testFile, sliceValue);
        if (consideredAlgorithms.includes(algorithm)) { 
            createResultObjectFields(aiModel, algorithm, reference);
            results[aiModel][algorithm][reference].push(fileContent.length);
            fullResults[aiModel][algorithm][reference].push({
                path: path,
                charCount: fileContent.length
            });
        }
    }
}

// Write the results to the output file
function outputResults() {
    fs.writeFileSync(outputPath, JSON.stringify(results, null, 0));
    fs.writeFileSync(fullOutputPath, JSON.stringify(fullResults, null, 1));
}

// ------------------------ Helper functions ------------------------

// Remove comments, imports, package declarations and whitespaces
function preProcessContent(content) {
    const withoutComments = content.replaceAll(/\/\*[\s\S]*?\*\/|([^\\:]|^)\/\/.*$/gm, '');
    const withoutImports = withoutComments.replaceAll(/import.*;/gm, '');
    const withoutPackage = withoutImports.replaceAll(/package.*;/gm, '');
    const withoutWhitespaces = withoutPackage.replaceAll(/\s/g, '');
    return withoutWhitespaces;
}

function getAIModelAndAlgorithmAndReference(filePath, sliceValue = 18) {
    const parts = filePath.replaceAll('\\', '/').slice(sliceValue).split("/");
    return [parts[0], parts[1], parts[2]];
}

// Find all files ending on .py in the given directory and its subdirectories
function findFiles(directory, fileList) {
    const files = fs.readdirSync(directory);
    for (const file of files) {
        const filePath = path.join(directory, file);
        const fileStat = fs.statSync(filePath);
        if (fileStat.isDirectory()) {
            findFiles(filePath, fileList);
        } else if (file.endsWith('.py')) {
            fileList.push(filePath);
        }
    }
}

// Create the fields for the result object if they don't exist yet
function createResultObjectFields(aiModel, algorithm, reference) {
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
}

main();