#!/bin/bash

# RUN PYLINT FOR CHATGPT AND COPILOT
pylint --rcfile=./config/pylint/syntax.pylintrc --output=./reports/python/resources/syntaxErrors.json --recursive=y py_app/src
syntax_error_count=$(jq length ./reports/python/resources/syntaxErrors.json)

echo "Syntax error check completed. Amount of syntax errors: $syntax_error_count! See ./reports/python/resources/syntaxErrors.json for details." 
