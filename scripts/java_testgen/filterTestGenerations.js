const fs = require('fs');
const { execSync } = require('child_process');
const path = require('path');
const os = require('os');

// ------------------------ Initialization ------------------------

// Adjustable Parameters
const timeOutSeconds = 5;

// Paths
const outputPath = 'reports/java_testgen/unsufficientTests.json';
const codePaths = ['java_testgen_app/src/main/java/ChatGPT', 'java_testgen_app/src/main/java/Copilot'];

// Global Arrays
const unsufficientTests = [];
// Find all Java files in the project directory and its subdirectories
const codeFiles = [];
// Find considered algorithms
const algorithmsCfg = JSON.parse(fs.readFileSync('config/consideredAlgorithms.json', 'utf8'));
const consideredAlgorithms = algorithmsCfg.considered.map(algorithm => algorithm[0]);

// Commands
// Check the operating system and set the paths to the JUnit and HamCrest JAR file accordingly
// Unix separators are used as default
let compileCodeCmd, compileTestCmd, jUnitCmd;
if (os.platform() === 'win32') {
    // Set the command to compile the Java files with windows separators
    compileCodeCmd = 'javac -cp .;lib/* -d java_testgen_app/bin/main';
    compileTestCmd = 'javac -cp .;lib/*;java_testgen_app/bin/main -d java_testgen_app/bin/test';
    jUnitCmd = `timeout ${timeOutSeconds} java -cp .;lib/*;java_testgen_app/bin/main;java_testgen_app/bin/test org.junit.runner.JUnitCore`;
} else {
    // Set the command to compile the Java files with unix separators
    compileCodeCmd = 'javac -cp .:lib/* -d java_testgen_app/bin/main';
    compileTestCmd = 'javac -cp .:lib/*:java_testgen_app/bin/main -d java_testgen_app/bin/test';
    jUnitCmd = `timeout ${timeOutSeconds} java -cp .:lib/*:java_testgen_app/bin/main:java_testgen_app/bin/test org.junit.runner.JUnitCore`;
}

// ------------------------ Main function ------------------------

async function main() {
    prepareFiltering();
    compileFiles();
    printResult();
}

// ------------------------ Functions ------------------------

// Removes report files, finds all java files and creates bin directories
function prepareFiltering() {
    // Delete the old report if it exists
    if (fs.existsSync(outputPath)) {
        fs.rmSync(outputPath);
    }

    for (const codePath of codePaths) {
        findJavaFiles(codePath);
    }

    // Create the bin directory if it doesn't exist
    fs.mkdirSync('java_testgen_app/bin/main', { recursive: true });
    fs.mkdirSync('java_testgen_app/bin/test', { recursive: true });
}

// Find all files ending on .java in the given directory and its subdirectories
function findJavaFiles(directory) {
    const files = fs.readdirSync(directory);
    for (const file of files) {
        const filePath = path.join(directory, file);
        const fileStat = fs.statSync(filePath);
        if (fileStat.isDirectory()) {
            findJavaFiles(filePath);
        } else if (file.endsWith('.java')) {
            codeFiles.push(filePath);
        }
    }
}

function compileFiles() {
    for (const codePath of codeFiles) {
        for (const algorithm of consideredAlgorithms) {
            // Check if the algorithm is one of the considered algorithms
            if (codePath.includes(algorithm)) {
                testPath = getTestPathFromCodePath(codePath);
                // Compile the file and move the class file to the bin directory if successful
                if (runCommand(`${compileCodeCmd} ${codePath}`)) {
                    console.log(`Compiled ${codePath}`);
                    if (runCommand(`${compileTestCmd} ${testPath}`)) {
                        console.log(`Compiled ${testPath} as well.`);
                        if (!runJUnitCmd(testPath)) {
                            unsufficientTests.push(testPath);
                            copyUnsufficientTestFile(testPath);
                        }
                    } else {
                        unsufficientTests.push(testPath);
                        copyUnsufficientTestFile(testPath);
                    }
                } else {
                    msg = `Something really went wrong! Uncompilable reference code should not happen. Check the prepartion pipeline!`;
                    console.log(msg);
                }
            };
        }
    }
}

function printResult() {
    // If there are uncompilable files, write them to the uncompilable files report
    if (unsufficientTests.length > 0) {
        console.log(`${unsufficientTests.length} test files are not compilable or end in an endless loop!`)
        const json = JSON.stringify(unsufficientTests, null, 2);
        if (!fs.existsSync("reports/java_testgen/resources")){
            fs.mkdirSync("reports/java_testgen/resources");
        }
        fs.writeFileSync(outputPath, json, 'utf8');
    } else {
        console.log('\n\n\nAll files compiled successfully!');
    }
}

// ------------------------ Helper functions ------------------------

// Run the given shell command
function runCommand(command) {
    try {
        execSync(command, { stdio: 'inherit' });
        return true;
    } catch (error) {
        return false;
    }
}

async function runJUnitCmd(testFile) {
    const sliceFrom = "java_testgen_app/bin/test/".length;
    const className = testFile.replaceAll('\\', '/').replaceAll("/", ".").slice(sliceFrom, -6);
    try {
        const { stdout, stderr } = await exec(`${jUnitCmd} ${className}`);
    } catch (error) {
        if (error.stderr === ".") {
            testWithoutEndlessLoop = false;
        }
        return false;
    }

}

function copyUnsufficientTestFile(filePath) {
    const toPath = filePath.replaceAll('\\', '/').replace('java_testgen_app/src/test/java', 'java_testgen_app/src/old/java');
    if (!fs.existsSync(path.dirname(toPath))) {
        fs.mkdirSync(path.dirname(toPath), { recursive: true });
    }
    if (!fs.existsSync(toPath)) {
        execSync(`cp -R ${filePath} ${toPath}`);
    } else {
        console.log(`File ${toPath} already exists, so no need to copy it.`);
    }
}

function getTestPathFromCodePath(codePath) {
    return codePath.replace('main', 'test').replace('.java', 'Test.java');
}

main();