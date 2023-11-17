#!/bin/bash

# RUN PYLINT
echo "Running pylint..."
mkdir -p ./reports/python/resources
pylint --rcfile=./config/pylint/quality.pylintrc --output=./reports/python/resources/pylintResults.json --recursive=y py_app/src

# CONVERT PYLINT REPORT
npm run pyconvertpylint


