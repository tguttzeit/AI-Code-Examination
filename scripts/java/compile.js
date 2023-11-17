const fs = require("fs");
const util = require("util");
const exec = util.promisify(require("child_process").exec);
const path = require("path");
const os = require("os");

// ---------------------------------- Initialization ----------------------------------

// Paths
const consideredAlgorithmsPath = "config/consideredAlgorithms.json";
const javaFilesPaths = [
  "java_app/src/main/java/ChatGPT",
  "java_app/src/main/java/Copilot",
];
const testFilesPaths = [
  "java_app/src/test/java/ChatGPT",
  "java_app/src/test/java/Copilot",
];

// Command Strings
// Check the operating system use the command with the correct separators
// Unix separators are used as default
let compileJavaCmd, compileTestCmd;
if (os.platform() === "win32") {
  // Set the command to compile the Java files with windows separators
  compileJavaCmd = "javac -cp .;lib/* -d java_app/bin/main";
  compileTestCmd = "javac -cp .;lib/*;java_app/bin/main -d java_app/bin/test";
} else {
  // Set the command to compile the Java files with unix separators
  compileJavaCmd = "javac -cp .:lib/* -d java_app/bin/main";
  compileTestCmd = "javac -cp .:lib/*:java_app/bin/main -d java_app/bin/test";
}

// Global Arrays
const aiModels = ["ChatGPT", "Copilot"];
const javaFiles = [];
const testFiles = [];
const algorithmsCfg = JSON.parse(
  fs.readFileSync(consideredAlgorithmsPath, "utf8")
);
const consideredAlgorithms = algorithmsCfg.considered.map(
  (algorithm) => algorithm[0]
);

// ---------------------------------- Main function ----------------------------------

async function main() {
  //Find all java and test files in the given src or test directory that need to be compiled
  for (i in aiModels) {
    findFiles(javaFilesPaths[i], javaFiles, (endingString = ".java"));
    findFiles(testFilesPaths[i], testFiles, (endingString = "Test.java"));
  }
  console.log(
    `Found ${javaFiles.length} java files and ${testFiles.length} test files to compile.\n`
  );

  // Create the bin directory if it doesn't exist
  fs.mkdirSync("java_app/bin/main", { recursive: true });
  fs.mkdirSync("java_app/bin/test", { recursive: true });

  // Compile all java and test files
  await compileFiles(javaFiles, compileJavaCmd);
  await compileFiles(testFiles, compileTestCmd);
}

// ---------------------------------- Functions ----------------------------------

// Find all files ending on the given String in the given directory and its subdirectories
function findFiles(directory, fileList, endingString) {
  const files = fs.readdirSync(directory);
  for (const file of files) {
    const filePath = path.join(directory, file);
    const fileStat = fs.statSync(filePath);
    if (fileStat.isDirectory()) {
      findFiles(filePath, fileList, endingString);
    } else if (
      // only add it if it is one of the considered algorithms and ends on the given string
      consideredAlgorithms.includes(getAlgorithmFromPath(filePath)) &&
      file.endsWith(endingString)
    ) {
      fileList.push(filePath);
    }
  }
}

// Compile all files in the given list with the given command
async function compileFiles(fileList, command) {
  for (const file of fileList) {
    // Compile the file and move the class file to the bin directory if successful
    try {
      await exec(`${command} ${file}`);
      console.log(`Compiled ${file}`);
    } catch (error) {
      console.error(error.message);
    }
  }
}

// ---------------------------------- Helper functions ----------------------------------

// The algorithm name always is on the 6th position in the path in this case, 
// so we can just get it from there
function getAlgorithmFromPath(filePath) {
  const parts = String(filePath).replaceAll("\\", "/").split("/");
  return parts[5];
}

main();
