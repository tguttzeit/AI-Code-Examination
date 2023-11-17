const fs = require('fs');
const util = require('util');
const exec = util.promisify(require('child_process').exec);

// ---------------------------------- Initialization ----------------------------------

// Adjustable Parameters
const desiredSampleSize = 10;
// Adjust this to avoid running into an endless loop in this script (in case there are less than 50 T folders per algorithm)
const algorithmSampleSize = 50;

// Global Arrays
const unusableAlgorithms = [];
const aiModels = ["ChatGPT", "Copilot"];
// Find considered algorithms
const configData = JSON.parse(fs.readFileSync('config/consideredAlgorithms.json', 'utf8'));
const consideredAlgorithms = configData.considered.map(entry => entry[1]);
const consideredAlgorithmClassName = configData.considered.map(entry => entry[0]);

const unitTestCmd = `timeout 2 python3 -m unittest`;

// ---------------------------------- Main function ----------------------------------

async function main() {
    for (let index = 0; index < consideredAlgorithms.length; index++) {
        const algorithm = consideredAlgorithms[index];
        const algorithmCamelCase = consideredAlgorithmClassName[index];
        for (const ai of aiModels) {
            const visited = [];
            await console.log(`Searching for ${ai} and ${algorithmCamelCase}:`)
            let fullyCorrect = false;
            let algorithmNumber;
            do {
                algorithmNumber = Math.floor(Math.random() * 50) + 1;
                if (!visited.includes(algorithmNumber)) {
                    visited.push(algorithmNumber);
                    let testFilePath;
                    if (algorithm === "breadth_first_search") {
                        testFilePath = `py_app/test/${ai}/${algorithmCamelCase}/T${algorithmNumber}/graph_test.py`;
                    } else {
                        testFilePath = `py_app/test/${ai}/${algorithmCamelCase}/T${algorithmNumber}/${algorithm}_test.py`;
                    }
                    if (await runUnitTestCmd(testFilePath)) {
                        await console.log(`... works!`)
                        fullyCorrect = true;
                    }
                }
            } while (!fullyCorrect && visited.length < algorithmSampleSize);
            if (!fullyCorrect) {
                unusableAlgorithms.push(`${ai}/${algorithmCamelCase}`);
            } else {
                for (let i = 1; i <= desiredSampleSize; i++) {
                    let fromPath;
                    let toPath;
                    if (algorithm === "breadth_first_search") {
                        fromPath = `py_app/src/${ai}/${algorithmCamelCase}/T${algorithmNumber}/graph.py`;
                        toPath = `py_testgen_app/src//${ai}/${algorithmCamelCase}/AIGenerated/T${i}/graph.py`;
                    } else {
                        fromPath = `py_app/src/${ai}/${algorithmCamelCase}/T${algorithmNumber}/${algorithm}.py`;
                        toPath = `py_testgen_app/src/${ai}/${algorithmCamelCase}/AIGenerated/T${i}/${algorithm}.py`;
                    }
                    await exec(`cp -R ${fromPath} ${toPath}`);
                }
            }
        }
    }
    if (unusableAlgorithms.length > 0) {
        await console.log(`For the following algorithms, no correct implementation could be found:\n${unusableAlgorithms.join("; ")}`);
    }
}

// ---------------------------------- Helper functions ----------------------------------

// Run the JUnit command and return true if it succeeds
async function runUnitTestCmd(testFile) {
    console.log(`Trying ${testFile}`)
    try {
        await exec(`${unitTestCmd} ${testFile}`);
        return true;
    } catch (error) {
        return false;
    }
}

main();

