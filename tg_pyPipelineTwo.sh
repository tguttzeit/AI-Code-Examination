#!/bin/bash
# PREPARES THE PROJECT STRUCTURE

# PREREQUISITES
echo "STEP 0 -Checking dependencies..."
npm install

# LEVENSHTEIN
echo "STEP 1 - Checking Levenshtein Distance"
npm run pytglevenshtein

# CHAR COUNT
echo "STEP 2 - Checking Character Count"
npm run pytgcharcount

# UNIT TESTS
echo "STEP 3 - Running Unit Tests"
npm run pytgtest

# COVERAGE
echo "STEP 4 - Checking Code Coverage"
npm run pytgcoverage

# FURTHER INFORMATION
echo -e "\n\n#########################################################################################\n"
echo "                               - F I N I S H E D -"
echo "- LEVENSHTEIN REPORT:           ./reports/python_testgen/tg_pyLevenshteinReport.json"
echo "- UNITTEST RESULTS:             ./reports/python_testgen/tg_pyUnitTestReport.json"
echo "- COVERAGE REPORT:              ./reports/python_testgen/tg_pyCoverageReport.json"
echo "- CONVERTED COVERAGE REPORT:    ./reports/python_testgen/tg_pyConvertedCoverageReport.json"
echo -e "\n#########################################################################################\n\n"
