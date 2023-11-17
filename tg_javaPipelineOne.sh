#!/bin/bash
# PREPARES THE PROJECT STRUCTURE

# PREREQUISITES
echo "STEP 0 -Checking dependencies..."
npm install

# CREATE FOLDERS
echo "STEP 1 - Creating folders"
npm run javatgfolders

# COPY RANDOM CODE GENERATION FILES
echo "STEP 2 - Copying random code generation files"
npm run javatgrandom

# FURTHER INFORMATION
echo -e "\n\n#########################################################################################\n"
echo "Preparation finished. You can now start generating test cases and copy them into the following folders:"
echo "java_testgen_app/src/test/java/ChatGPT and java_testgen_app/src/test/java/Copilot"
echo "Afterwards, run the following command to check if your test generations are sufficient for the pipeline:"
echo "npm run javatgcheck"
echo -e "\n#########################################################################################\n\n"