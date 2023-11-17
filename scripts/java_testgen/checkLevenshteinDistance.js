const fs = require('fs');
const path = require('path');
const levenshtein = require('js-levenshtein');


// ------------------------ Initialization ------------------------

//Paths
const outputPath = 'reports/java_testgen/tg_javaLevenshteinReport.json';
const fullOutputPath = 'reports/java_testgen/resources/tg_javaFullLevenshteinReport.json';
const oldPath = 'java_testgen_app/src/old/java';
const codePaths = ['java_testgen_app/src/test/java/ChatGPT', "java_testgen_app/src/test/java/Copilot"];

// Find considered algorithms
const algorithmsCfg = JSON.parse(fs.readFileSync('config/consideredAlgorithms.json', 'utf8'));
const consideredAlgorithms = algorithmsCfg.considered.map(algorithm => algorithm[0]);

// Create all needed arrays and objects
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

// ------------------------ Main function ------------------------

async function main() {
    prepareFiltering();
    runLevenshteinDistanceCheck();
    postProcessResults();
    outputResults();
}

// ------------------------ Functions ------------------------

// Removes report files, finds all java files and old (unchanged) java test files
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
        const sliceValue = `java_testgen_app/src/old/java/`.length;
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
        const respectiveOldFile = filePath.replaceAll("\\","/").replace('java_testgen_app/src/test', 'java_testgen_app/src/old');
        const sliceValue = `java_testgen_app/src/test/java/`.length;
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
    if (!fs.existsSync("reports/java_testgen/resources")){
        fs.mkdirSync("reports/java_testgen/resources");
    }
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

function getAIModelAndAlgorithmAndReference(filePath, sliceValue = 23) {
    const parts = filePath.replaceAll('\\', '/').slice(sliceValue).split("/");
    return [parts[0], parts[1], parts[2]];
}

// Find all files ending on .java in the given directory and its subdirectories
function findFiles(directory, fileList) {
    const files = fs.readdirSync(directory);
    for (const file of files) {
        const filePath = path.join(directory, file);
        const fileStat = fs.statSync(filePath);
        if (fileStat.isDirectory()) {
            findFiles(filePath, fileList);
        } else if (file.endsWith('.java')) {
            fileList.push(filePath.replaceAll("\\","/"));
        }
    }
}

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