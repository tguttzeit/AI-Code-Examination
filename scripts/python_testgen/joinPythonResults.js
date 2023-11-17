const fs = require('fs');

// Path to json Files
const correctnessResults = './reports/python_testgen/tg_pyUnitTestReport.json';
const levenshteinResults = './reports/python_testgen/tg_pyLevenshteinReport.json';
const coverageResults = './reports/python_testgen/tg_pyConvertedCoverageReport.json';
const outputFileName = './reports/python_testgen/allPythonTGResults.json';

function mergeArrays(data) {
  const result = {
      "ChatGPT": {
          "AIGenerated": [],
          "BookExampleCode": [],
          "PromptOnly": []
      },
      "Copilot": {
          "AIGenerated": [],
          "BookExampleCode": [],
          "PromptOnly": []
      }
  };

  for (const model in data) {
      for (const task in data[model]) {
          for (const key in data[model][task]) {
              result[model][key] = result[model][key].concat(data[model][task][key]);
          }
      }
  }

  return result;
}


const dataCorrectness = JSON.parse(fs.readFileSync(correctnessResults));
const dataLevenshtein = JSON.parse(fs.readFileSync(levenshteinResults));
const dataCoverage = JSON.parse(fs.readFileSync(coverageResults));

const outputData = {
  "correctness": mergeArrays(dataCorrectness),
  "levenshtein": mergeArrays(dataLevenshtein),
  "coverage": mergeArrays(dataCoverage)
};

fs.writeFileSync(outputFileName, JSON.stringify(outputData, null, 0));
console.log(`Joined results array can be found in '${outputFileName}'.`);
