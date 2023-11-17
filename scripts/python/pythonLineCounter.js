const fs = require('fs');
const util = require('util');
const path = require('path');
const readdir = util.promisify(fs.readdir);

// ---------------------------------- Initialization ----------------------------------

// Find considered algorithms
const algorithmsCfg = JSON.parse(fs.readFileSync('config/consideredAlgorithms.json', 'utf8'));
const consideredAlgorithms = algorithmsCfg.considered.map(algorithm => algorithm[0]);

const outputPath= 'reports/python/pythonAlgorithmsLineCount.json';

// ---------------------------------- Main function ----------------------------------

async function main() {
  try {
    const chatGPTPath = 'py_app/src/ChatGPT';
    const chatGPTResults = await countLinesInDirectory(chatGPTPath);

    const copilotPath = 'py_app/src/Copilot';
    const copilotResults = await countLinesInDirectory(copilotPath);

    const results = {
      chatGPT: chatGPTResults,
      copilot: copilotResults,
    };

    const json = JSON.stringify(results, null, 2);
    fs.writeFileSync(outputPath, json, 'utf8');

    console.log('Line count done!');
  } catch (error) {
    console.log(error);
  }
}

// ------------------------------------- Functions -------------------------------------

function countLines(filename) {
  const content = fs.readFileSync(filename, 'utf-8');
  const lines = content.split('\n');
  let count = 0;
  let inMultilineComment = false;
  
  for (const line of lines) {
    const trimmed = line.trim();
    if (!trimmed) {
      continue; // Skip empty lines
    }

    if (inMultilineComment) {
      // Check if we've reached the end of the comment
      if (trimmed.includes('"""')) {
        inMultilineComment = false;
      }
      continue; // Skip comment lines
    }

    if (trimmed.startsWith('from') || trimmed.startsWith('import')) {
      continue; // Skip import lines
    }

    if (trimmed.startsWith('#')) {
      continue; // Skip single-line comments
    }

    if (trimmed.includes('"""')) {
      inMultilineComment = true; // Start of multi-line comment
      continue; // Skip comment lines
    }
    count++;
  }
  return count;
}

async function countLinesInDirectory(directoryPath) {
  const results = {};
  for (let i = 0; i < consideredAlgorithms.length; i++) {
    const algorithm = consideredAlgorithms[i];
    const algorithmPath = path.join(directoryPath, algorithm);
    const algorithmVersions = await readdir(algorithmPath);
    results[algorithm] = [];

    for (let j = 0; j < algorithmVersions.length; j++) {
      algorithmVersion = algorithmVersions[j];
      const versionPath = path.join(algorithmPath, algorithmVersion);
      var pyFiles = await readdir(versionPath);
      // remove files containting "__" from the pyFiles list
      pyFiles = pyFiles.filter(file => !file.includes('__'));
      const codeFilePath = path.join(versionPath, pyFiles[0]);
      const codeLines = countLines(codeFilePath);
      results[algorithm].push(codeLines);
    }
  }
  return results;
}


main();