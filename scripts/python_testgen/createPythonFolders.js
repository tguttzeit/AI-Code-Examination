const fs = require('fs');
const { execSync } = require('child_process');
const cfgPath = './config/consideredAlgorithms.json';
const os = require('os');

// Numbers of folders to create
const from = 1;
const to = 10;

// Find considered algorithms and corresponding class names
const configData = JSON.parse(fs.readFileSync(cfgPath));
const consideredAlgorithms = configData.considered.map(entry => entry[1]);
const consideredAlgorithmClassName = configData.considered.map(entry => entry[0]);

const aiModels = ["ChatGPT", "Copilot"];
const referenceCode = ["BookExampleCode", "AIGenerated", "PromptOnly"];

for (const ai of aiModels) {
  for (let index = 0; index < consideredAlgorithms.length; index++) {
    const algorithm = consideredAlgorithms[index];
    const algorithmCamelCase = consideredAlgorithmClassName[index];

    for (const reference of referenceCode) {
      for (let i = from; i <= to; i++) {

        const folderPath = `py_testgen_app/src/${ai}/${algorithmCamelCase}/${reference}/T${i}`;
        const testFolderPath = `py_testgen_app/test/${ai}/${algorithmCamelCase}/${reference}/T${i}`;
        const bookExampleTestPath = `py_testgen_app/test/BookExampleTest`;
        fs.mkdirSync(folderPath, { recursive: true });
        fs.mkdirSync(testFolderPath, { recursive: true });
        fs.mkdirSync(bookExampleTestPath, { recursive: true });

        const className = algorithm === "breadth_first_search" ? "graph" : algorithm;
        const classNameCamelCase = algorithm === "breadth_first_search" ? "Graph" : algorithmCamelCase;

        // copy Bookexamples tests into extra folder
        execSync(`cp -R py_app/test/BookExample/${className}_test.py ${bookExampleTestPath}/${className}_test.py`);
        // copy classes to test against into the correct folder, BookExampleCode
        // and PromptOnly both get the code from the BookExamples
        if (reference === "BookExampleCode" || reference === "PromptOnly") {
          execSync(`cp -R py_app/src/BookExample/${className}.py ${folderPath}/${className}.py`);
        }
        const fileContent = `from py_testgen_app.src.${ai}.BreadthFirstSearch.${reference}.T${i}.${className} import ${classNameCamelCase}\n\nimport unittest\n\nclass ${classNameCamelCase}Test(unittest.TestCase):\n    `
        fs.writeFileSync(`${testFolderPath}/${className}_test.py`, fileContent);
      }
    }
  }
}
