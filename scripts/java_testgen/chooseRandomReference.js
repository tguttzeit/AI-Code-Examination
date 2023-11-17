const fs = require('fs');
const util = require('util');
const exec = util.promisify(require('child_process').exec);
const os = require("os");

// ---------------------------------- Initialization ----------------------------------

// Adjustable Parameters
const sampleSize = 10;
// Adjust this to avoid running into an endless loop in this script (in case there are less than 50 T folders per algorithm)
const algorithmSampleSize = 50;

// Global Arrays
const unusableAlgorithms = [];
const aiModels = ["ChatGPT", "Copilot"];
// Find considered algorithms
const algorithmsCfg = JSON.parse(fs.readFileSync('config/consideredAlgorithms.json', 'utf8'));
const consideredAlgorithms = algorithmsCfg.considered.map(algorithm => algorithm[0]);

// Commands
// Check the operating system and set the paths to the JUnit and HamCrest JAR file accordingly
// Unix separators are used as default
let jUnitCmd, compileTestCmd;
if (os.platform() === 'win32') {
    // Set the command to compile the Java files with windows separators
    jUnitCmd = 'timeout 5 java -cp .;lib/*;java_app/bin/main;java_app/bin/test org.junit.runner.JUnitCore';
    compileTestCmd = 'javac -cp .;lib/*;java_app/bin/main -d java_app/bin/test';
} else {
    // Set the command to compile the Java files with unix separators
    jUnitCmd = 'timeout 5 java -cp .:lib/*:java_app/bin/main:java_app/bin/test org.junit.runner.JUnitCore';
    compileTestCmd = 'javac -cp .:lib/*:java_app/bin/main -d java_app/bin/test';
}

// ---------------------------------- Main function ----------------------------------

async function main() {
    for (const algorithm of consideredAlgorithms) {
        let filePath;
        for (const ai of aiModels) {
            const visited = [];
            console.log(`Searching for ${ai} and ${algorithm}:`)
            let fullyCorrect = false;
            let algorithmNumber;
            do {
                algorithmNumber = Math.floor(Math.random() * 50) + 1;
                if (!visited.includes(algorithmNumber)) {
                    visited.push(algorithmNumber);
                    let testFilePath;
                    if (algorithm === "BreadthFirstSearch") {
                        filePath = `java_app/src/main/java/${ai}/${algorithm}/T${algorithmNumber}/Graph.java`;
                        testFilePath = `java_app/src/test/java/${ai}/${algorithm}/T${algorithmNumber}/GraphTest.java`;
                    } else {
                        filePath = `java_app/src/main/java/${ai}/${algorithm}/T${algorithmNumber}/${algorithm}.java`;
                        testFilePath = `java_app/src/test/java/${ai}/${algorithm}/T${algorithmNumber}/${algorithm}Test.java`;
                    }
                    const compiledClass = await runCompileCmd(filePath)
                    const compiledTest = await runCompileTestCmd(testFilePath);
                    if (!compiledTest || !compiledClass) {
                        continue;
                    }
                    if (await runJUnitCmd(compiledTest)) {
                        console.log(`... works!`)
                        fullyCorrect = true;
                    }
                }
            } while (!fullyCorrect && visited.length < algorithmSampleSize)
            if (!fullyCorrect) {
                unusableAlgorithms.push(`${ai}/${algorithm}`);
            } else {
                for (let i = 1; i <= sampleSize; i++) {
                    let toPath;
                    if (algorithm === "BreadthFirstSearch") {
                        toPath = `java_testgen_app/src/main/java/${ai}/${algorithm}/AIGenerated/T${i}/Graph.java`;
                    } else {
                        toPath = `java_testgen_app/src/main/java/${ai}/${algorithm}/AIGenerated/T${i}/${algorithm}.java`;
                    }
                    await exec(`cp -R ${filePath} ${toPath}`);
                    // Command is different for Mac
                    if (os.platform() === "darwin") {
                        await exec(`sed -i '' "s/${ai}.${algorithm}.T${algorithmNumber}/${ai}.${algorithm}.AIGenerated.T${i}/" ${toPath}`);
                    } else {
                        await exec(`sed -i "s/${ai}.${algorithm}.T${algorithmNumber}/${ai}.${algorithm}.AIGenerated.T${i}/" ${toPath}`);
                    }
                }
            }
            console.log(`Finished Copying ${ai} and ${algorithm}\n\n`);
        }
    }

    
    if (unusableAlgorithms.length > 0) {
        console.log(`For the following algorithms, no correct implementation could be found:\n${unusableAlgorithms.join(", ")}`);
    }
}

// ---------------------------------- Helper functions ----------------------------------

// Compile the file and move the class file to the bin directory if successful
async function runCompileCmd(file) {
    try {
        const { stdout, stderr } = await exec(`${compileTestCmd} ${file}`);
        return file.replaceAll("\\", "/").replace('src/main/java', 'bin/main').replace('.java', '.class');
    } catch (error) {
        console.log(error.message);
        return null;
    }
}

// Compile the test file and move the class file to the bin directory if successful
async function runCompileTestCmd(file) {
    try {
        const { stdout, stderr } = await exec(`${compileTestCmd} ${file}`);
        return file.replaceAll("\\", "/").replace('src/test/java', 'bin/test').replace('.java', '.class');
    } catch (error) {
        console.log(error.message);
        return null;
    }
}

// Run the JUnit command and return true if it succeeds
async function runJUnitCmd(testFile) {
    className = testFile.replaceAll('\\', '/').replaceAll("/", ".").slice(18, -6);
    console.log(`Trying ${testFile}`)
    try {
        await exec(`${jUnitCmd} ${className}`);
        return true;
    } catch (error) {
        return false;
    }
}



main();

