const fs = require('fs');
const { execSync } = require('child_process');
const cfgPath = './config/consideredAlgorithms.json';
const os = require('os');

// Numbers of folders to create
const from = 1;
const to = 50;

// The command is different for mac, since it requires an empty string between -i and the file path
const lineReplacingCommand = os.platform() === "darwin" ? "sed -i '' \"1s/.*/package": 'sed -i "1s/.*/package';

// Find considered algorithms and corresponding class names
const configData = JSON.parse(fs.readFileSync(cfgPath));
const consideredAlgorithms = configData.considered.map(entry => entry[1]);
const consideredAlgorithmClassName = configData.considered.map(entry => entry[0]);

const aiModels = ["ChatGPT", "Copilot"];

for (const ai of aiModels) {
  for (let index = 0; index < consideredAlgorithms.length; index++) {
    const algorithm = consideredAlgorithms[index];
    const algorithmCamelCase = consideredAlgorithmClassName[index];
    const className = algorithm === "breadth_first_search" ? "graph" : algorithm;
    const classNameCamelCase = algorithm === "breadth_first_search" ? "Graph" : algorithmCamelCase;

    for (let i = from; i <= to; i++) {
      const folderPath = `py_app/src/${ai}/${algorithmCamelCase}/T${i}`;
      const testFolderPath = `py_app/test/${ai}/${algorithmCamelCase}/T${i}`;

      fs.mkdirSync(folderPath, { recursive: true });
      fs.mkdirSync(testFolderPath, { recursive: true });
      fs.writeFileSync(`${folderPath}/${className}.py`, `class ${classNameCamelCase}:\n\n`);
      execSync(`cp -R py_app/test/BookExample/${className}_test.py ${testFolderPath}/${className}_test.py`);
      execSync(`${lineReplacingCommand} py_app.src.${ai}.${algorithmCamelCase}.T${i}.${className} import ${classNameCamelCase}/" ${testFolderPath}/${className}_test.py`);
    }
  }
}

