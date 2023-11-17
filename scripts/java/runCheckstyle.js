const fs = require("fs");
const path = require("path");
const util = require("util");
const exec = util.promisify(require("child_process").exec);
const os = require("os");

// ---------------------------------- Initialization ----------------------------------

// Paths
const consideredAlgorithmsPath = "config/consideredAlgorithms.json";
const javaFilesPaths = [
  "java_app/src/main/java/ChatGPT",
  "java_app/src/main/java/Copilot",
];
const outputPathRaw = "reports/java/resources/CheckstyleReport.xml";
const outputPathFull = "reports/java/resources/fullCheckstyleReport.json";
const outputPathConverted = "reports/java/convertedCheckstyleReport.json";
const uncompilableFilesReportPath = "reports/java/uncompilableFiles.json";

// Command Strings
const checkstyleCmd =
  "java -jar lib/checkstyle-10.9.2-all.jar -c config/checkstyle/checkstyle.xml -f xml";
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
const aiModels = ["ChatGPT", "Copilot"];
const javaFiles = [];
const uncompilableFiles = [];
const fullReport = [];
const result = {};
// Find considered algorithms
const algorithmsCfg = JSON.parse(
  fs.readFileSync(consideredAlgorithmsPath, "utf8")
);
const consideredAlgorithms = algorithmsCfg.considered.map(
  (algorithm) => algorithm[0]
);

// ---------------------------------- Main function ----------------------------------

async function main() {
  prepareFilesAndDirectories();

  for (i in aiModels) {
    findFiles(javaFilesPaths[i]);
  }
  console.log(`Found ${javaFiles.length} java files to compile.\n`);
  await compileAndRunCheckstyle();
  await createFullReport();
  convertCheckstyleReport();
  createUncompilableFilesReport();
}

// ---------------------------------- Functions ----------------------------------

// Delete and rename files to avoid conflicts
function prepareFilesAndDirectories() {
  // Rename old checkstyle report and delete the one from before
  if (fs.existsSync(`${outputPathRaw}.old`)) {
    fs.rmSync(`${outputPathRaw}.old`, { force: true });
  }
  if (fs.existsSync(outputPathRaw)) {
    fs.renameSync(outputPathRaw, `${outputPathRaw}.old`);
  }
  // Delete the uncompilable files report if it exists
  if (fs.existsSync(uncompilableFilesReportPath)) {
    fs.rmSync(uncompilableFilesReportPath);
  }

  // Create the bin directory if it doesn't exist
  fs.mkdirSync("./java_app/bin/main", { recursive: true });
  fs.mkdirSync("./java_app/bin/test", { recursive: true });
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
      consideredAlgorithms.includes(
        getAIModelAndAlgorithmFromPath(filePath)[1]
      ) &&
      file.endsWith(".java")
    ) {
      javaFiles.push(filePath);
    }
  }
}

// Compile code and run checkstyle for all considered algorithms
async function compileAndRunCheckstyle() {
  for (const file of javaFiles) {
    // Only run checkstyle if the file was compiled successfully
    if (await runCompileCmd(file)) {
      await runCheckstyleCmd(file);
    }
  }
}

// Create a JSON report from the XML report
async function createFullReport() {
  const fileTags = await parseXML(outputPathRaw);
  // Iterate over the array of XML strings and extract the file name and errors
  for (const filePath of javaFiles) {
    const reportObject = { path: filePath, errors: [] };
    for (const fileTag of fileTags) {
      // extract file name from xml tag
      const fileName = fileTag.match(/name="([^"]*)"/)[1];
      if (fileName.includes(filePath) && fileTag.includes(`error`)) {
        // extract errors from xml tag
        const errors = await extractErrorsFromXML(fileTag);
        reportObject.errors = errors;
      }
    }
    fullReport.push(reportObject);
  }
  fs.writeFileSync(outputPathFull, JSON.stringify(fullReport, null, 2));
}

function convertCheckstyleReport() {
  for (const reportObject of fullReport) {
    const indexOfJavaApp = reportObject.path.indexOf("java_app");
    const path = reportObject.path.substring(indexOfJavaApp);
    const [aiModel, algorithm] = getAIModelAndAlgorithmFromPath(path);
    createResultObjectFields(aiModel, algorithm);
    result[aiModel][algorithm].push(reportObject.errors.length);
  }
  // Indentation depth = 0, looks better in this case
  fs.writeFileSync(outputPathConverted, JSON.stringify(result, null, 0));
}

// If files could not be compiled, write them to a report since they have to be regenerated
function createUncompilableFilesReport() {
  if (uncompilableFiles.length > 0) {
    console.log(`\n\n\nCould not compile ${uncompilableFiles.length} files!`);
    const json = JSON.stringify(uncompilableFiles, null, 2);
    fs.writeFileSync(uncompilableFilesReportPath, json, "utf8");
  } else {
    console.log("\n\n\nAll files compiled successfully!");
  }
}

// ---------------------------------- Helper functions ----------------------------------

// The AI Model name always is on the 5th and the algorithm name on
// the 6th position in the path in this case,
// so we can just get it from there
function getAIModelAndAlgorithmFromPath(filePath) {
  const parts = filePath.replaceAll("\\", "/").split("/");
  return [parts[4], parts[5]];
}

// Compile the Java files and return true if it was compiled successfully and false if not
async function runCompileCmd(file) {
  try {
    await exec(`${compileCmd} "${file}"`);
    console.log(`Compiled ${file}`);
    return true;
  } catch (error) {
    console.log(`Could not compile ${file}`);
    uncompilableFiles.push(file);
    return false;
  }
}

// Run checkstyle for the given file
async function runCheckstyleCmd(file) {
  console.log(`---> Running checkstyle...`);
  try {
    await exec(`${checkstyleCmd} "${file}" >> "${outputPathRaw}"`);
  } catch (error) {
    console.error(
      `---> Error running checkstyle for ${file}: ${error.message}`
    );
  }
}

// Read the XML file and split it into an array of XML strings
async function parseXML(inputFile) {
  const xmlContent = fs.readFileSync(inputFile, "utf-8");
  const xmlList = xmlContent.split(/<\?xml.*?\?>\s*/); // split on <?xml...?>
  const fileTags = xmlList
    .filter(Boolean)
    .map((xml) => xml.match(/<file.*<\/file>/s)[0]);
  return fileTags;
}

// Extract the errors from the XML string
async function extractErrorsFromXML(fileTag) {
  const errors = [];
  lines = fileTag.split(`\n`);
  for (line of lines) {
    // Check if this line is an error tag and extract the line, column and message
    if (line.includes(`error`)) {
      const foundLine = line.match(/line="([^"]*)"/)[1];
      const message = line.match(/message="([^"]*)"/)[1];
      // Some messages don't contain a column
      let column = "";
      if (line.includes(`column`)) {
        column = line.match(/column="([^"]*)"/)[1];
      }
      const error = {
        line: foundLine,
        column: column,
        message: message,
      };
      errors.push(error);
    }
  }
  return errors;
}

// Create the fields for the result object if they don't exist yet
function createResultObjectFields(aiModel, algorithm) {
  if (!result[aiModel]) {
    result[aiModel] = {};
  }
  if (!result[aiModel][algorithm]) {
    result[aiModel][algorithm] = [];
  }
}

main();
