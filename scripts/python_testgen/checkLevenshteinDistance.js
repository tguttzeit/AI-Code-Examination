const fs = require('fs');
const path = require('path');
const levenshtein = require('js-levenshtein');


// ------------------------ Initialization ------------------------

// Paths
const outputPath = 'reports/python_testgen/tg_pyLevenshteinReport.json';
const fullOutputPath = 'reports/python_testgen/resources/tg_pyFullLevenshteinReport.json';
const oldPath = 'py_testgen_app/old';
const codePaths = ['py_testgen_app/test/ChatGPT', "py_testgen_app/test/Copilot"];

// Global Arrays
const oldFiles = [];
const allFiles = [];
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
    prepareFiltering();
    runLevenshteinDistanceCheck();
    postProcessResults();
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
        findFiles(codePath, allFiles);
    }
    findFiles(oldPath, oldFiles);
}

// Run the levenshtein distance check for all files
function runLevenshteinDistanceCheck() {
    for (const filePath of oldFiles) {
        const sliceValue = `py_testgen_app/old/`.length;
        const [aiModel, algorithm, reference] = getAIModelAndAlgorithmAndReference(filePath, sliceValue);
        if (consideredAlgorithms.includes(algorithm)) {
            const newPath = filePath.replaceAll('old', 'test');
            const fileContentOld = preProcessContent(fs.readFileSync(filePath, 'utf8'));
            const fileContentNew = preProcessContent(fs.readFileSync(newPath, 'utf8'));
            const distance = levenshtein(fileContentOld, fileContentNew);
            createResultObjectFields(aiModel, algorithm, reference);
            results[aiModel][algorithm][reference].push(distance);
            fullResults[aiModel][algorithm][reference].push({
                path: filePath,
                distance: distance
            });
        }
    }
}

// Since we only have files that had errors in the current results array, we need to add the files that had no errors
function postProcessResults() {
    for (const filePath of allFiles) {
        const respectiveOldFile = filePath.replaceAll("\\","/").replace('py_testgen_app/test/', 'py_testgen_app/old/');
        const sliceValue = `py_testgen_app/test/`.length;
        const [aiModel, algorithm, reference] = getAIModelAndAlgorithmAndReference(filePath, sliceValue);
        if (!oldFiles.includes(respectiveOldFile) && consideredAlgorithms.includes(algorithm)) {
            createResultObjectFields(aiModel, algorithm, reference);
            results[aiModel][algorithm][reference].push(0);
            fullResults[aiModel][algorithm][reference].push({
                path: filePath,
                distance: 0
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

// Remove comments, imports and whitespaces
function preProcessContent(content) {
    const withoutPythonComments = content.replaceAll(/#.*[^\n]/gm, '');
    const withoutPythonFromImports = withoutPythonComments.replaceAll(/from.*[^\n]/gm, '');
    const withoutPythonImports = withoutPythonFromImports.replaceAll(/import.*[^\n]/gm, '');
    const withoutWhitespaces = withoutPythonImports.replaceAll(/\s/g, '');
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
            fileList.push(filePath.replaceAll("\\","/"));
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