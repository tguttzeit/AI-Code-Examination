const fs = require('fs');
const path = require('path');

// ---------------------------------- Initialization ----------------------------------

// Paths
const directoryToSearch = 'py_app/src';
const reportFilePath = 'reports/python/resources/pylintResults.json';
const pylintReport = JSON.parse(fs.readFileSync(reportFilePath, 'utf-8'));
const fullOutputPath = 'reports/python/resources/fullPylintReport.json';
const outputPath = 'reports/python/convertedPylintReport.json';


// Global Arrays
const pythonFiles = [];
const result = {
    "ChatGPT": {},
    "Copilot": {}
};
// Algorithms that should be considered for the report
// Find considered algorithms
const algorithmsCfg = JSON.parse(fs.readFileSync('config/consideredAlgorithms.json', 'utf8'));
const consideredAlgorithms = algorithmsCfg.considered.map(algorithm => algorithm[0]);


// ---------------------------------- Main function ----------------------------------

function main() {
    findPythonFiles(directoryToSearch);
    const filteredPylintReport = filterReport(pylintReport); 
    const reportWithoutDuplicates = removeDuplicatesFromReport(filteredPylintReport);
    joinReportWithFileList(reportWithoutDuplicates);
    convertPylintReport();
    writeFiles();
}

// Find all python files in project directory (except __init-py__) and add them to a json array
function findPythonFiles(directoryPath) {
    const files = fs.readdirSync(directoryPath);
    for (const file of files) {
        const filePath = path.join(directoryPath, file);
        const [aiModel, algorithm] = getAiModelAndAlgorithm(filePath, sliceValue = "py_app/src/".length);

        if (file === '__init__.py') {
            return;
        }

        if (fs.statSync(filePath).isDirectory()) {
            findPythonFiles(filePath, pythonFiles);
        } else if (filePath.includes('BookExample') || !consideredAlgorithms.includes(algorithm)) {
            // skip BookExample files and algorithms that are not considered
            // Removing them here is still more performant than running pylint file by file
            return;
        } else if (file.endsWith('.py')) {
            const pathObject = {
                path: filePath,
                errors: []
            }
            pythonFiles.push(pathObject);
        }
    }
}

// Filter the original pylint report to remove unwanted errors
function filterReport(pylintReport) {
    const result = pylintReport.filter((obj) => {
        const [aiModel, algorithm] = getAiModelAndAlgorithm(obj.path, sliceValue = "py_app/src/".length);
        // Filter out all errors that are not related to the clean code guidelines
        if (obj.symbol === 'invalid-name' && !obj.message.includes("doesn't conform to '^.{1,20}$' pattern")) {
            return false;
            // Filter out all errors that don't belong to the considered algorithms
        } else if (consideredAlgorithms.includes(algorithm)) {
            return true;
        }
    });
    return result;
}

// Remove duplicates from the original pylint report
function removeDuplicatesFromReport(pylintReport) {
    const uniqueObjects = {};
    const result = pylintReport.filter((obj) => {
        const objAsString = JSON.stringify(obj);
        // If the object is not in the Array yet, add it
        if (!uniqueObjects[objAsString]) {
            uniqueObjects[objAsString] = true;
            return true;
        }
        return false;
    });
    return result;
}

// Add the errors from the pylint report to the file array to get a full report
function joinReportWithFileList(reportWithoutDuplicates) {
    for (const file of pythonFiles) {
        for (const report of reportWithoutDuplicates) {
            if (file.path === report.path) {
                errorObject = {
                    line: report.line,
                    column: report.column,
                    message: report.message
                };
                file.errors.push(errorObject);
            }
        }
    }
}

// Convert the report into a format split by aiModel and algorithm
function convertPylintReport() {
    for (reportObject of pythonFiles) {
        const [aiModel, algorithm] = getAiModelAndAlgorithm(reportObject.path, sliceValue = "py_app/src/".length);
        if (!result[aiModel][algorithm]) {
            result[aiModel][algorithm] = [];
        }
        result[aiModel][algorithm].push(reportObject.errors.length);
    };
}

//Write report array into json file
function writeFiles() {
    if (!fs.existsSync("reports/python/resources")){
        fs.mkdirSync("reports/python/resources");
    }
    fs.writeFileSync(fullOutputPath, JSON.stringify(pylintReport, null, 2)); 
    fs.writeFileSync(outputPath, JSON.stringify(result, null, 0)); //indentation depth = 0, looks better in this case
    console.log(`Finished pylint report was saved in ${outputPath}.`);
}

// ---------------------------------- Helper functions ----------------------------------

function getAiModelAndAlgorithm(filePath, sliceValue) {
    const parts = filePath.replaceAll('\\', '/').slice(sliceValue).split("/");
    return [parts[0], parts[1]];
}


main();
