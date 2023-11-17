const fs = require("fs");
const { execSync } = require("child_process");
const path = require("path");
const os = require("os");

// ---------------------------------- Initialization ----------------------------------

// Paths
const outputPath = "reports/java/resources/uncompilableFiles.json";
const consideredAlgorithmsPath = "config/consideredAlgorithms.json";
const javaFilesPaths = [
  "java_app/src/main/java/ChatGPT",
  "java_app/src/main/java/Copilot",
];

// Check the operating system use the command with the correct separators
// Unix separators are used as default
let compileCmd;
if (os.platform() === "win32") {
  // Set the command to compile the Java files with windows separators
  compileCmd = "javac -cp .;lib/* -d java_app/bin/main";
} else {
  // Set the command to compile the Java files with unix separators
  compileCmd = "javac -cp .:lib/* -d java_app/bin/main";
}

// Global Arrays
const javaFiles = [];
const uncompilableFiles = [];
// Find considered algorithms
const algorithmsCfg = JSON.parse(
  fs.readFileSync(consideredAlgorithmsPath, "utf8")
);
const consideredAlgorithms = algorithmsCfg.considered.map(
  (algorithm) => algorithm[0]
);

// ---------------------------------- Main function ----------------------------------

function main() {
  prepareFilesAndDirectories();

  for (const directory of javaFilesPaths) {
    findFiles(directory);
  }

  findUncompilableFiles();
  createReport();
}

// ---------------------------------- Functions ----------------------------------

function prepareFilesAndDirectories() {
  // Delete the uncompilable files report if it exists
  if (fs.existsSync(outputPath)) {
    fs.rmSync(outputPath);
  }
  // Create the bin directory if it doesn't exist
  fs.mkdirSync("java_app/bin/main", { recursive: true });
  fs.mkdirSync("java_app/bin/test", { recursive: true });
}

// Find all files ending on the given String in the given directory and its subdirectories
function findFiles(directory) {
  const files = fs.readdirSync(directory);
  for (const file of files) {
    const filePath = path.join(directory, file);
    const fileStat = fs.statSync(filePath);
    if (fileStat.isDirectory()) {
      findFiles(filePath);
    } else if (
      // only add it if it is one of the considered algorithms and ends on the given string
      consideredAlgorithms.includes(getAlgorithmFromPath(filePath)) &&
      file.endsWith(".java")
    ) {
      javaFiles.push(filePath);
    }
  }
}

function findUncompilableFiles() {
  for (const file of javaFiles) {
    // Compile the file and move the class file to the bin directory if successful
    try {
      execSync(`${compileCmd} ${file}`, { stdio: "inherit" });
      console.log(`Compiled ${file}`);
    } catch (error) {
      console.log(`Could not compile ${file}`);
      uncompilableFiles.push(file);
    }
  }
}

// If there are uncompilable files, write them to the uncompilable files report
function createReport() {
  if (uncompilableFiles.length > 0) {
    console.log(`\n\n\nCould not compile ${uncompilableFiles.length} files!`);
    const json = JSON.stringify(uncompilableFiles, null, 2);
    fs.writeFileSync(outputPath, json, "utf8");
  } else {
    console.log("\n\n\nAll files compiled successfully!");
  }
}

// ---------------------------------- Helper functions ----------------------------------

// The algorithm name always is on 6th position in the path in this case,
// so we can just get it from there
function getAlgorithmFromPath(filePath) {
  const parts = filePath.replaceAll("\\", "/").split("/");
  return parts[5];
}

main();
