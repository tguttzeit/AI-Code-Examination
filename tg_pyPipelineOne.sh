#!/bin/bash
# PREPARES THE PROJECT STRUCTURE

# PREREQUISITES
echo "STEP 0 -Checking dependencies..."
npm install

# CREATE FOLDERS
echo "STEP 1 - Creating folders"
npm run pytgfolders

# COPY RANDOM CODE GENERATION FILES
echo "STEP 2 - Copying random code generation files"
npm run pytgrandom

# FURTHER INFORMATION
echo -e "\n\n#########################################################################################\n"
echo "Preparation finished. You can now start generating test cases and copy them into the following folders:"
echo "py_testgen_app/test/ChatGPT and py_testgen_app/test/Copilot"
echo "Afterwards, run the following command to check if your test generations are sufficient for the pipeline:"
echo "npm run pytgcheck"
echo -e "\n#########################################################################################\n\n"