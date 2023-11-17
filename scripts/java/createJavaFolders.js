const fs = require("fs");
const { execSync } = require("child_process");
const os = require("os");

// Numbers of folders to create
const from = 1;
const to = 50;
const aiModels = ["ChatGPT", "Copilot"];

// Find considered algorithms
const consideredAlgorithmsPath = "config/consideredAlgorithms.json";
const algorithmsCfg = JSON.parse(
  fs.readFileSync(consideredAlgorithmsPath, "utf8")
);
const consideredAlgorithms = algorithmsCfg.considered.map(
  (algorithm) => algorithm[0]
);

// The command is different for mac, since it requires an empty string between -i and the file path
let lineReplacingCommand = os.platform() === "darwin" ? "sed -i '' \"1s/.*/package": 'sed -i "1s/.*/package';


for (const ai of aiModels) {
  for (const algorithm of consideredAlgorithms) {
    for (let i = from; i <= to; i++) {
      // Create the folder structure
      const folderPath = `java_app/src/main/java/${ai}/${algorithm}/T${i}`;
      const testFolderPath = `java_app/src/test/java/${ai}/${algorithm}/T${i}`;
      fs.mkdirSync(folderPath, { recursive: true });
      fs.mkdirSync(testFolderPath, { recursive: true });

      // Create the java files
      // Since the breadth first search algorithm files are always named "Graph", it needs to be handled separately
      const className = algorithm === "BreadthFirstSearch" ? "Graph" : algorithm;
      // Copy the test file
      execSync(
        `cp -R java_app/src/test/java/BookExamples/${className}Test.java ${testFolderPath}/${className}Test.java`
      );
      // Change the package name
      execSync(
        `${lineReplacingCommand} ${ai}.${algorithm}.T${i};/" ${testFolderPath}/${className}Test.java`
      );
      // Create the source code file
      fs.writeFileSync(
        `${folderPath}/${className}.java`,
        `package ${ai}.${algorithm}.T${i};\n\npublic class ${className} {\n};`
      );
    }
  }
}
