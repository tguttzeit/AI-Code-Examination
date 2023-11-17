const fs = require('fs');

// Path to json Files
const correctnessResults = './reports/python/pythonUnitTestReport.json';
const qualityResults = './reports/python/convertedPylintReport.json';
const outputFileName = './reports/python/allPythonResults.json';

function extractArraysFromJSON(obj, result = []) {
  if (Array.isArray(obj)) {
    result.push(...obj);
  } else if (typeof obj === 'object') {
    for (const key in obj) {
      if (obj.hasOwnProperty(key)) {
        extractArraysFromJSON(obj[key], result);
      }
    }
  }
  return result;
}
const correctnessData = JSON.parse(fs.readFileSync(correctnessResults));
const qualityData = JSON.parse(fs.readFileSync(qualityResults));

const outputData = {
  "Code Correctness": {
    ChatGPT: extractArraysFromJSON(correctnessData['ChatGPT']),
    Copilot: extractArraysFromJSON(correctnessData['Copilot'])
  },
  "Code Quality": {
    ChatGPT: extractArraysFromJSON(qualityData['ChatGPT']),
    Copilot: extractArraysFromJSON(qualityData['Copilot'])
  }
};

fs.writeFileSync(outputFileName, JSON.stringify(outputData, null, 0));
console.log(`Joined results array can be found in '${outputFileName}'.`);
