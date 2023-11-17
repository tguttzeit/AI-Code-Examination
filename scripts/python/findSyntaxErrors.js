const fs = require('fs');
const util = require('util');
const exec = util.promisify(require('child_process').exec);

// ---------------------------------- Initialization ----------------------------------

// Paths
const outputFilePathRaw = './reports/python/resources/syntaxErrorsRaw.json';
const outputFilePath = './reports/python//syntaxErrors.json';

// ---------------------------------- Main function ----------------------------------

async function main() {
    // Delete the uncompilable files report if it exists
    if (fs.existsSync(outputFilePathRaw)) {
        fs.rmSync(outputFilePathRaw);
    }
    await runCommand();
    const errorAmount = await postProcessReport();
    if (errorAmount === 0) {
        console.log('No syntax errors found!');
        fs.rmSync(outputFilePathRaw);
    } else {
        console.log(`Amount of syntax errors: ${errorAmount}! See ${outputFilePath} for Details.`);
    }
}

// ------------------------------------- Functions -------------------------------------

async function runCommand() {
    try {
        await exec(`pylint --rcfile=./config/pylint/syntax.pylintrc --output=${outputFilePathRaw} --recursive=y py_app/src`);
    } catch (error) {
        // Since syntax errors are expected, we do not want to print the error
        // An error is thrown as soon as there are syntax errors, therefore an error print would be misleading
        return;
    }
}

// Postprocess the report to remove duplicates
async function postProcessReport() {
    const rawReport = await JSON.parse(fs.readFileSync(outputFilePathRaw, 'utf-8'));
    const filteredReport = [];
    if (rawReport.length > 0) {
        for (const report of rawReport) {
            let contained = false;
            for (const filteredReportEntry of filteredReport) {
                if (filteredReportEntry === report.path) {
                    contained = true;
                }
            }
            if (!contained) {
                filteredReport.push(report.path);
            }
        }
        filteredReport.sort();
        fs.writeFileSync(outputFilePath, JSON.stringify(filteredReport, null, 4));
        return filteredReport.length;
    } else {
        return 0;
    }
}


main();

