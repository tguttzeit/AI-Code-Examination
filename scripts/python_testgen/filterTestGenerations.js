const fs = require('fs');
const { execSync } = require('child_process');
const util = require('util');
const exec = util.promisify(require('child_process').exec);
const path = require('path');
const os = require('os');

// ------------------------ Initialization ------------------------

// Adjustable Parameters
const timeOutSeconds = 5;

// Paths
const unsufficientOutputPath = 'reports/python_testgen/unsufficientTests.json';
const rawOutputPath = 'reports/python_testgen/resources/rawPylintTestReport.json';
const codeCheckOutputPath = 'reports/python_testgen/resources/codeCheck.json';

// Global Arrays
const testFiles = [];
const endlessTests = [];
// Find considered algorithms
const algorithmsCfg = JSON.parse(fs.readFileSync('config/consideredAlgorithms.json', 'utf8'));
const consideredAlgorithms = algorithmsCfg.considered.map(algorithm => algorithm[0]);

// Commands
const pylintCmd = `pylint --rcfile=./config/pylint/syntax.pylintrc --recursive=y --disable=E0401 --output=`
const unitTestCmd = `timeout ${timeOutSeconds} python3 -m unittest`;


// ------------------------ Main function ------------------------

async function main() {
    prepareFiltering();
    // Check if the reference code files are okay
    if (runPylint('./py_testgen_app/src', codeCheckOutputPath)) {
        console.log('Something really went wrong. Syntax errors in reference code should not happen. Check the preparation pipeline.');
        return;
    }
    const pylintFailed = runPylint('./py_testgen_app/test', rawOutputPath);
    const endlessLoopsExisting = await runUnitTests();
    if (pylintFailed || endlessLoopsExisting) {
        await postProcessReport();
    }
    printResult();
}

// ------------------------ Functions ------------------------

// Removes report files, finds all java files and creates bin directories
function prepareFiltering() {
    // Delete the old report if it exists
    if (fs.existsSync(rawOutputPath)) {
        fs.rmSync(rawOutputPath);
    }
    if (fs.existsSync(codeCheckOutputPath)) {
        fs.rmSync(codeCheckOutputPath);
    }
    if (fs.existsSync(unsufficientOutputPath)) {
        fs.rmSync(unsufficientOutputPath);
    }
    findPyFiles('py_testgen_app/test');
}

// Find all files ending on .java in the given directory and its subdirectories
function findPyFiles(directory) {
    const files = fs.readdirSync(directory);
    for (const file of files) {
        const filePath = path.join(directory, file);
        const fileStat = fs.statSync(filePath);
        if (fileStat.isDirectory()) {
            findPyFiles(filePath);
        } else if (file.endsWith('test.py') && isConsideredAlgorithm(filePath) && !filePath.includes('py_testgen_app/test/BookExampleTest')) {
            testFiles.push(filePath);
        }
    }
}

async function runUnitTests() {
    let failed = false;
    for (const testFile of testFiles) {
        try {
            const { stdout, stderr } = await exec(`${unitTestCmd} ${testFile}`);
        } catch (error) {
            // If a unittest command execution fails due to the timeout, stderr only contains "."
            // If the command fails because the unittest fails, there would be the typical "FAILED! ..." output
            // Since we only want to know if there is an endless loop, we can just check for the "."
            if (error.stderr === ".") {
                failed = true;
                endlessTests.push(testFile);
            }
        }
    }
    return failed;
}


async function postProcessReport() {
    // Read the raw report
    const rawReport = await JSON.parse(fs.readFileSync(rawOutputPath, 'utf-8'));
    const filteredReport = [];
    for (const report of rawReport) {
        if (!Object.keys(filteredReport).includes(report.path) && testFiles.includes(report.path)) {
            filteredReport.push({
                path: report.path,
                error: report.message
            });
            copyUnsufficientTest(report.path);
        }
    }
    for (const endlessTest of endlessTests) {
        filteredReport.push({
            path: endlessTest,
            error: "Some kind of endless loop..."
        });
        copyUnsufficientTest(endlessTest);
    }
    if (filteredReport.length > 0) {
        // Sort by paths
        filteredReport.sort((a, b) => a.path.localeCompare(b.path));
        fs.writeFileSync(unsufficientOutputPath, JSON.stringify(filteredReport, null, 4));
    }
}

function printResult() {
    // If there are uncompilable files, write them to the uncompilable files report
    if (fs.existsSync(unsufficientOutputPath)) {
        const unsufficientTests = JSON.parse(fs.readFileSync(unsufficientOutputPath, 'utf8'));
        console.log(`There are ${unsufficientTests.length} files that cannot be used. See ${unsufficientOutputPath} for more information.`);
    } else {
        console.log(`All test files are sufficient!`);
    }
    // Remove raw files
    fs.rmSync(rawOutputPath);
    fs.rmSync(codeCheckOutputPath);
}


// ------------------------ Helper functions ------------------------

function isConsideredAlgorithm(filePath) {
    for (const algorithm of consideredAlgorithms) {
        if (filePath.includes(algorithm)) {
            return true;
        }
    }
    return false;
}

function runPylint(directoryPath, outputPath) {
    try {
        execSync(`${pylintCmd}${outputPath} ${directoryPath}`);
        return false;
    } catch (error) {
        // An error is thrown as soon as there is an syntax error
        return true;
    }
}


function copyUnsufficientTest(filePath) {
    const toPath = filePath.replaceAll('\\', '/').replace('py_testgen_app/test', 'py_testgen_app/old');
    if (!fs.existsSync(path.dirname(toPath))) {
        fs.mkdirSync(path.dirname(toPath), { recursive: true });
    }
    if (!fs.existsSync(toPath)) {
        execSync(`cp -R ${filePath} ${toPath}`);
    } else {
        console.log(`File ${toPath} already exists, so no need to copy it.`);
    }
}

main();