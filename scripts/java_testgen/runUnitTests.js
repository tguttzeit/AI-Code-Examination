const fs = require('fs');
const path = require('path');
const util = require('util');
const exec = util.promisify(require('child_process').exec);
const os = require('os');

// ---------------------------------- Initialization ----------------------------------

// Adjustable Parameters
const timeOutSeconds = 5;

// Paths
const outputPath = 'reports/java_testgen/tg_javaUnitTestReport.json';
const fullOutputPath = 'reports/java_testgen/resources/tg_javaFullTestReport.json';
const testDirectories = ["java_testgen_app/src/test/java/ChatGPT", "java_testgen_app/src/test/java/Copilot"];
const javaDirectories = ["java_testgen_app/src/main/java/ChatGPT", "java_testgen_app/src/main/java/Copilot"];

// Global Arrays
// Create all needed arrays and objects
const javaFiles = [];
const testFiles = [];
const testsToRun = [];
const results = {
    "ChatGPT": {},
    "Copilot": {}
};
const fullResults = {
    "ChatGPT": {},
    "Copilot": {}
};
// Find considered algorithms
const cfgPath = "./config/consideredAlgorithms.json";
const consideredAlgorithms = JSON.parse(fs.readFileSync(cfgPath, 'utf8')).considered.map(algorithm => algorithm[0]);

// Commands
// Check the operating system and set the paths to the JUnit and HamCrest JAR file accordingly
// Unix separators are used as default
const jacocoCmd = `java -jar lib/jacococli.jar instrument java_testgen_app/bin --dest java_testgen_app/jacoco`;
let compileCmd, jUnitCmd, compileTestCmd;
if (os.platform() === 'win32') {
    // Set the command to compile the Java files with windows separators
    compileCmd = 'javac -cp .;lib/* -d java_testgen_app/bin/main';
    compileTestCmd = 'javac -cp .;lib/*;java_testgen_app/bin/main -d java_testgen_app/bin/test';
    jUnitCmd = `timeout ${timeOutSeconds} java -javaagent:lib/jacocoagent.jar -cp .;lib/*;java_testgen_app/jacoco/main;java_testgen_app/bin/test org.junit.runner.JUnitCore`;
} else {
    // Set the command to compile the Java files with unix separators
    compileCmd = 'javac -cp .:lib/* -d java_testgen_app/bin/main';
    compileTestCmd = 'javac -cp .:lib/*:java_testgen_app/bin/main -d java_testgen_app/bin/test';
    jUnitCmd = `timeout ${timeOutSeconds} java -javaagent:lib/jacocoagent.jar -cp .:lib/*:java_testgen_app/jacoco/main:java_testgen_app/bin/test org.junit.runner.JUnitCore`;
}

// ---------------------------------- Main function ----------------------------------

// Create json object, find all test files and run the python unit test command for each file
async function main() {
    for (const directory of javaDirectories) {
        findJavaFiles(directory);
    }
    for (const directory of testDirectories) {
        findTestJavaFiles(directory);
    }
    // Create the bin directory if it doesn't exist
    fs.mkdirSync('java_testgen_app/bin/test', { recursive: true });
    fs.mkdirSync('java_testgen_app/bin/main', { recursive: true });
    await compileJavaFiles(javaFiles);
    await compileTestFiles(testFiles);
    await runInstrumentCmd();
    await jUnit(results);

    if (!fs.existsSync("reports/java_testgen/resources")){
        fs.mkdirSync("reports/java_testgen/resources");
    }
    fs.writeFileSync(outputPath, JSON.stringify(results, null, 0)); //indentation depth = 0, looks better in this case
    fs.writeFileSync(fullOutputPath, JSON.stringify(fullResults, null, 2));
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

function findJavaFiles(directory) {
    const files = fs.readdirSync(directory);
    for (const file of files) {
        const filePath = path.join(directory, file);
        const fileStat = fs.statSync(filePath);
        if (fileStat.isDirectory()) {
            findJavaFiles(filePath);
        } else if (file.endsWith('.java')) {
            for (const algorithm of consideredAlgorithms) {
                // Check if the algorithm is one of the considered algorithms
                if (filePath.includes(algorithm)) {
                    // Add the file to the array of Java files
                    javaFiles.push(filePath);
                }
            }
        }
    }
}

// Compile code and run checkstyle for all considered algorithms
async function compileJavaFiles(javaFiles) {
    for (const file of javaFiles) {
        await runCompileCmd(file);
    }
}

// Compile considered test files and add them to the files that should be run later
async function compileTestFiles(testFiles) {
    for (const file of testFiles) {
        for (const algorithm of consideredAlgorithms) {
            // Check if the algorithm is one of the considered algorithms
            if (file.includes(algorithm)) {
                const compiledTest = await runTestCompileCmd(file);
                if (compiledTest) {
                    testsToRun.push(compiledTest);
                } else {
                    const [aiModel, algo, reference] = getAIModelAndAlgorithmAndReference(file);
                    createResultObjectFields(aiModel, algorithm, reference);
                    results[aiModel][algorithm][reference].push(1);
                    fullResults[aiModel][algorithm][reference].push({
                        path: file,
                        result: 1
                    });
                }
            }
        }
    }
}

// Run JUnit for all test files
async function jUnit() {
    for (const testFile of testsToRun) {
        const sliceFrom = "java_testgen_app/jacoco/test/".length;
        const sliceTo = -".java".length;
        const [aiModel, algorithm, reference] = getAIModelAndAlgorithmAndReference(testFile, sliceValue = sliceFrom);
        createResultObjectFields(aiModel, algorithm, reference);
        className = testFile.replaceAll('\\', '/').replaceAll("/", ".").slice(sliceFrom, sliceTo);
        const result = await runJUnitCmd(testFile);
        await results[aiModel][algorithm][reference].push(result);
        await fullResults[aiModel][algorithm][reference].push({
            path: testFile,
            result: result
        });
    }
}

// ---------------------------------- Helper functions ----------------------------------

// Get the AI model and algorithm from the file path
function getAIModelAndAlgorithmAndReference(filePath, sliceValue = 23) {
    const parts = filePath.replaceAll('\\', '/').slice(sliceValue).split("/");
    return [parts[0], parts[1], parts[2]];
}

// Compile the file and move the class file to the bin directory if successful
async function runTestCompileCmd(file) {
    try {
        const { stdout, stderr } = await exec(`${compileTestCmd} ${file}`);
        console.log(`Compiled ${file}`);
        return file.replaceAll("\\", "/").replace('src/test/java', 'jacoco/test').replace('.java', '.class');
    } catch (error) {
        console.log(error.message);
    }
}

async function runCompileCmd(file) {
    try {
        await exec(`${compileCmd} "${file}"`);
        console.log(`Compiled ${file}`);
        return true;
    } catch (error) {
        console.log(`Could not compile ${file}`);
        uncompilabeFiles.push(file);
        return false;
    }
}

async function runInstrumentCmd() {
    try {
        await exec(`${jacocoCmd}`);
        console.log(`Instrumented files`);
    } catch (error) {
        console.log(error);
    }
}

// Run the JUnit command and return 1 if it fails and 0 if it succeeds
async function runJUnitCmd(testFile) {
    const sliceFrom = "java_testgen_app/jacoco/test/".length;
    className = testFile.replaceAll('\\', '/').replaceAll("/", ".").slice(sliceFrom, -6);
    console.log(`For ${testFile}:`)
    try {
        const { stdout, stderr } = await exec(`${jUnitCmd} ${className}`);
        console.log("Success!");
        return 0;
    } catch (error) {
        console.log(error.stdout);
        return 1;
    }
}

// If the object fields needed don't exist yet, create them
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