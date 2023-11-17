#!/bin/bash

# PREREQUISITES
echo "STEP 0 - Checking dependencies..."
npm install

# RUN LINECOUNTER
echo "STEP 1 - Running lineCounter"
npm run pycount
echo "done."

# RUN PYLINT
echo -e "\nSTEP 2 - Running Pylinit"
./scripts/python/runPylint.sh

# RUN UNITTESTS TESTS
echo -e "\nSTEP 3 - Running Unit tests"
npm run pytest
echo "done."

# CREATE ANALYSIS JSON FILE
echo -e "\nSTEP 4 - Creating analysis JSON file"
npm run pyjoin
echo "done."

# FURTHER INFORMATION
echo -e "\n\n#########################################################################################\n"
echo "                               - F I N I S H E D -"
echo "- UNITTEST RESULTS:         ./reports/python/pythonUnitTestReport.json"
echo "- FULL PYLINT REPORT:       ./reports/python/fullPylintReport.json"
echo "- CONVERTED PYLINT REPORT:  ./reports/python/convertedPylintReport.json"
echo "- LINECOUNTER RESULTS:      ./reports/python/pythonAlgorithmsLineCount.json"
echo "- ANALYSIS FILE:            ./reports/python/allPythonResults.json"
echo "- FILES WITH SYNTAX ERRORS: ./reports/python/syntaxErrors.json"
echo -e "\n\n"
