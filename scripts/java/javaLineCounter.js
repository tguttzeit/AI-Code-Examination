const fs = require('fs');
const util = require('util');
const path = require('path');
const readdir = util.promisify(fs.readdir);

// ---------------------------------- Initialization ----------------------------------

// Paths
const outputPath = 'reports/java/javaAlgorithmsLineCount.json';
const chatGPTPath = 'java_app/src/main/java/ChatGPT';
const copilotPath = 'java_app/src/main/java/Copilot';

// Find considered algorithms
const cfgPath = "./config/consideredAlgorithms.json";
const consideredAlgorithms = JSON.parse(fs.readFileSync(cfgPath, 'utf8')).considered.map(algorithm => algorithm[0]);

// ---------------------------------- Main function ----------------------------------

async function main() {
  try {
    const chatGPTLineCount = await countLinesInDirectory(chatGPTPath);
    const copilotLineCount = await countLinesInDirectory(copilotPath);

    const results = {
      chatGPT: chatGPTLineCount,
      copilot: copilotLineCount,
    };

    const json = JSON.stringify(results, null, 2);
    fs.writeFileSync(outputPath, json, 'utf8');

    console.log('Line count done!');
  } catch (error) {
    console.log(error);
  }
}

// ---------------------------------- Functions ----------------------------------

async function countLinesInDirectory(directoryPath) {
  const results = {};
  for (let i = 0; i < consideredAlgorithms.length; i++) {
    const algorithm = consideredAlgorithms[i];
    const algorithmPath = path.join(directoryPath, algorithm);
    const algorithmVersions = await readdir(algorithmPath);
    results[algorithm] = [];

    for (let j = 0; j < algorithmVersions.length; j++) {
      const versionPath = path.join(algorithmPath, algorithmVersions[j]);
      const javaFiles = await readdir(versionPath);

      const javaFilePath = path.join(versionPath, javaFiles[0]);
      const javaFileLines = countLines(javaFilePath);

      results[algorithm].push(javaFileLines);
    }
  }

  return results;
}

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

    if (trimmed.startsWith('import')) {
      continue; // Skip import lines
    }

    if (trimmed.startsWith('package')) {
      continue; // Skip package lines
    }

    if (inMultilineComment) {
      // Check if we've reached the end of the comment
      if (trimmed.endsWith('*/')) {
        inMultilineComment = false;
      }
      continue; // Skip comment lines
    }

    if (trimmed.startsWith('//')) {
      continue; // Skip single-line comments
    }

    if (trimmed.startsWith('/*')) {
      inMultilineComment = true; // Start of multi-line comment
      continue; // Skip comment lines
    }
    count++;
  }
  return count;
}

main();