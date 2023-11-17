const fs = require('fs');
const path = require('path');
const util = require('util');
const exec = util.promisify(require('child_process').exec);
const os = require('os');

// ---------------------------------- Initialization ----------------------------------

// Adjustable Parameters
const timeOutSeconds = 5;

const outputPath = 'reports/java/javaUnitTestReport.json';
const testDirectories = ["java_app/src/test/java/ChatGPT", "java_app/src/test/java/Copilot"];

// Check the operating system and set the paths to the JUnit and HamCrest JAR file accordingly
// Unix separators are used as default
let jUnitCmd, compileTestCmd;
if (os.platform() === 'win32') {
    // Set the command to compile the Java files with windows separators
    jUnitCmd =`timeout ${timeOutSeconds} java -cp .;lib/*;java_app/bin/main;java_app/bin/test org.junit.runner.JUnitCore`;
    compileTestCmd = 'javac -cp .;lib/*;java_app/bin/main -d java_app/bin/test';
} else {
    // Set the command to compile the Java files with unix separators
    jUnitCmd = `timeout ${timeOutSeconds} java -cp .:lib/*:java_app/bin/main:java_app/bin/test org.junit.runner.JUnitCore`;
    compileTestCmd = 'javac -cp .:lib/*:java_app/bin/main -d java_app/bin/test';
}

// Find considered algorithms
const cfgPath = "./config/consideredAlgorithms.json";
const consideredAlgorithms = JSON.parse(fs.readFileSync(cfgPath, 'utf8')).considered.map(algorithm => algorithm[0]);

// Create all needed arrays and objects
const testFiles = [];
const testsToRun = [];
const results = {
    "ChatGPT": {},
    "Copilot": {}
};

// ---------------------------------- Main function ----------------------------------

// Create json object, find all test files and run the python unit test command for each file
async function main() {
    for (const directory of testDirectories) {
        findTestJavaFiles(directory);
    }
    // Create the bin directory if it doesn't exist
    fs.mkdirSync('java_app/bin/test', { recursive: true });
    await compileTestFiles(testFiles);
    await jUnit(results);

    fs.writeFileSync(outputPath, JSON.stringify(results, null, 0)); //indentation depth = 0, looks better in this case
}

// ---------------------------------- Functions ----------------------------------

// Find all Java test files in the project directory and its subdirectories
function findTestJavaFiles(directory) {
    const files = fs.readdirSync(directory);
    for (const file of files) {
        const filePath = path.join(directory, file);
        const fileStat = fs.statSync(filePath);
        if (fileStat.isDirectory()) {
            findTestJavaFiles(filePath);
        } else if (file.endsWith("Test.java")) {
            testFiles.push(filePath);
        }
    }
}

// Compile considered test files and add them to the files that should be run later
async function compileTestFiles(testFiles) {
    for (const file of testFiles) {
        for (const algorithm of consideredAlgorithms) {
            // Check if the algorithm is one of the considered algorithms
            if (file.includes(algorithm) && !file.includes('BookExample')) {
                const compiledTest = await runCompileCmd(file);
                if (compiledTest) {
                    testsToRun.push(compiledTest);
                } else {
                    [aiModel, algo] = getAIModelAndAlgorithm(file);
                    if (!results[aiModel][algorithm]) {
                        results[aiModel][algorithm] = [];
                    }
                    results[aiModel][algorithm].push(1);
                }
            }
        }
    }
}

// Run the jUnit test command and return 1 if it fails and 0 if it succeeds
async function jUnit(results) {
    for (const testFile of testsToRun) {
        [aiModel, algorithm] = getAIModelAndAlgorithm(testFile, sliceValue = 18);
        if (!results[aiModel][algorithm]) {
            results[aiModel][algorithm] = [];
        }
        className = testFile.replaceAll('\\', '/').replaceAll("/", ".").slice(18, -6);
        const result = await runJUnitCmd(testFile);
        await results[aiModel][algorithm].push(result);
    }
}


// ---------------------------------- Helper functions ----------------------------------

// Get the AI model and algorithm from the file path
function getAIModelAndAlgorithm(filePath, sliceValue = 23) {
    const parts = filePath.replaceAll('\\', '/').slice(sliceValue).split("/");
    return [parts[0], parts[1]];
}

// Compile the file and move the class file to the bin directory if successful
async function runCompileCmd(file) {
    try {
        const { stdout, stderr } = await exec(`${compileTestCmd} ${file}`);
        console.log(`Compiled ${file}`);
        return file.replaceAll("\\", "/").replace('src/test/java', 'bin/test').replace('.java', '.class');
    } catch (error) {
        console.log(error.message);
    }
}

// Run the JUnit command and return 1 if it fails and 0 if it succeeds
async function runJUnitCmd(testFile) {
    className = testFile.replaceAll('\\', '/').replaceAll("/", ".").slice(18, -6);
    console.log(`For ${testFile}:`)
    try {
        const { stdout, stderr } = await exec(`${jUnitCmd} ${className}`);
        console.log(stdout);
        return 0;
    } catch (error) {
        console.log(error.stdout);
        return 1;
    }
}

main();