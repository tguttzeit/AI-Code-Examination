const fs = require('fs');
const { execSync } = require('child_process');
const os = require("os");

// Numbers of folders to create
const from = 1;
const to = 10;

// Find considered algorithms
const algorithmsCfg = JSON.parse(fs.readFileSync('config/consideredAlgorithms.json', 'utf8'));
const consideredAlgorithms = algorithmsCfg.considered.map(algorithm => algorithm[0]);
const aiModels = ["ChatGPT", "Copilot"];
const referenceCode = ["BookExampleCode", "AIGenerated", "PromptOnly"];

let lineReplacingCommand = os.platform() === "darwin" ? `sed -i '' "1s/.*/package` : `sed -i "1s/.*/package`;

for (const ai of aiModels) {
  for (let algorithm of consideredAlgorithms) {
    for (reference of referenceCode) {
      for (let i = from; i <= to; i++) {

        const testFolderPath = `java_testgen_app/src/test/java/${ai}/${algorithm}/${reference}/T${i}`;
        const folderPath = `java_testgen_app/src/main/java/${ai}/${algorithm}/${reference}/T${i}`;
        const bookExampleTestPath = `java_testgen_app/src/test/java/BookExampleTest`;
        fs.mkdirSync(folderPath, { recursive: true });
        fs.mkdirSync(testFolderPath, { recursive: true });
        fs.mkdirSync(bookExampleTestPath, { recursive: true });
        const className = algorithm === "BreadthFirstSearch" ? "Graph" : `${algorithm}`;
        // copy Bookexamples tests into extra folder
        execSync(`cp -R java_app/src/test/java/BookExamples/${className}Test.java ${bookExampleTestPath}/${className}Test.java`);
        // copy classes to test against into the correct folder, BookExampleCode
        // and PromptOnly both get the code from the BookExamples
        if (reference === "BookExampleCode" || reference === "PromptOnly") {
          execSync(`cp -R java_app/src/main/java/BookExamples/${className}.java ${folderPath}/${className}.java`);
          execSync(`${lineReplacingCommand} ${ai}.${algorithm}.${reference}.T${i};/" ${folderPath}/${className}.java`);
        }
        fs.writeFileSync(`${testFolderPath}/${className}Test.java`, `package ${ai}.${algorithm}.${reference}.T${i};\n\npublic class ${className}Test {\n\n}`);
      }
    }
  }
}
