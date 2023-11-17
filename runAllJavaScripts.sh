#!/bin/bash

# PREREQUISITES
echo "STEP 0 -Checking dependencies..."
npm install

# RUN LINECOUNTER
echo "STEP 1 - Running lineCounter"
npm run javacount
echo "done."

# RUN CHECKSTYLE
echo -e "\nSTEP 2 - Running Checkstyle"
npm run checkstyle

# RUN JUNIT TESTS
echo -e "\nSTEP 3 - Running JUnit tests"
# Code is compiled when running checkstyle, therefore no need to run ./scripts/java/compileCode.sh
npm run javatest
echo "done."

# CREATE ANALYSIS JSON FILE
echo -e "\nSTEP 4 - Creating analysis JSON file"
npm run javajoin
echo "done."

# FURTHER INFORMATION
echo -e "\n\n#########################################################################################\n"
echo "                               - F I N I S H E D -"
echo "- UNITTEST RESULTS:             ./reports/java/javaUnitTestReport.json"
echo "- CONVERTED CHECKSTYLE REPORT:  ./reports/java/convertedCheckstyleReport.json"
echo "- LINECOUNTER RESULTS:          ./reports/java/javaAlgorithmsLineCount.json"
echo "- ANALYSIS FILE:                ./reports/java/allJavaResults.json"
echo "- UNCOMPILABLE FILES:           ./reports/java/uncompilableFiles.json"
