#!/bin/bash
# PREPARES THE PROJECT STRUCTURE

# PREREQUISITES
echo "STEP 0 -Checking dependencies..."
npm install

# LEVENSHTEIN
echo "STEP 1 - Checking Levenshtein Distance"
npm run javatglevenshtein

echo "STEP 2 - Checking Character Count"
npm run javatgcharcount

# UNIT TESTS
echo "STEP 3 - Running Unit Tests"
npm run javatgtest

# COVERAGE
echo "STEP 4 - Checking Code Coverage"
npm run javatgcoverage

# FURTHER INFORMATION
echo -e "\n\n#########################################################################################\n"
echo "                               - F I N I S H E D -"
echo "- LEVENSHTEIN REPORT:           ./reports/java_testgen/tg_javaLevenshteinReport.json"
echo "- UNITTEST RESULTS:             ./reports/java_testgen/tg_javaUnitTestReport.json"
echo "- COVERAGE REPORT:              ./reports/java_testgen/tg_javaCoverageReport.json"
echo "- CONVERTED COVERAGE REPORT:    ./reports/java_testgen/tg_javaConvertedCoverageReport.json"
echo -e "\n#########################################################################################\n\n"
