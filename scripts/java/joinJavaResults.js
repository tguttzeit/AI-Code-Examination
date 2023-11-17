const fs = require('fs');

// Path to json Files
const correctnessPath = './reports/java/javaUnitTestReport.json';
const qualityPath = './reports/java/convertedCheckstyleReport.json';
const outputPath = './reports/java/allJavaResults.json';

// Combines all Sub-Arrays of the given JSON-Object into one Array
function combineSubArrays(obj, result = []) {
  if (Array.isArray(obj)) {
    result.push(...obj);
  } else if (typeof obj === 'object') {
    for (const key in obj) {
      if (obj.hasOwnProperty(key)) {
        combineSubArrays(obj[key], result);
      }
    }
  }
  return result;
}

const dataCorrectness = JSON.parse(fs.readFileSync(correctnessPath));
const dataQuality = JSON.parse(fs.readFileSync(qualityPath));

// Join all correctness and quality results into one array for each model
const outputData = {
  "Code Correctness": {
    ChatGPT: combineSubArrays(dataCorrectness['ChatGPT']),
    Copilot: combineSubArrays(dataCorrectness['Copilot'])
  },
  "Code Quality": {
    ChatGPT: combineSubArrays(dataQuality['ChatGPT']),
    Copilot: combineSubArrays(dataQuality['Copilot'])
  }
};

fs.writeFileSync(outputPath, JSON.stringify(outputData, null, 0));
console.log(`Joined results array can be found in '${outputPath}'.`);
