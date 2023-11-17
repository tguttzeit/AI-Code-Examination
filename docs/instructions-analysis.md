# Instructions for Analysing the Examination Results
This guide describes how to analyse the data created after following the two guides for generating code with ChatGPT and GitHub Copilot. It will explain how to use the scripts of the [analysis repository](https://github.com/t-muras/AI-Code-Analysis) and the [AI Therapy web tools](https://www.ai-therapy.com/psychology-statistics/).

## Using the Analysis Repository
### Source Code Generation
1. Open the Repository in MATLAB (We used Version 2022b).
2. Copy the data files from `reports/<programming language>` in the examination repository into the respective folders in `data/<programming_language>` of the analysis repository.
3. Depending on the algorithms you want to analyse, run either the scripts in `scripts/<programming language>` ending on `_all.m` or the ones without. The ones without only analyse the original six algorithms that were examined in the bachelor's thesis this project is based on.
4. Depending on which script you executed, you can find the graphics in `images/<programming_language>_<number>`.

### Test Case Generation
1. Open the Repository in MATLAB (We used Version 2022b).
2. Copy the data files from `reports/<programming language>_testgen` in the examination repository into the respective folders in `data/<programming_language>_testgen` of the analysis repository.
3. Run either the scripts in `scripts/<programming language>_testgen`. You can find the graphics in `images/<programming_language>_testgen`.

## Using the AI Therapy Web Tools
### Source Code Generation
1. Calculate the [mean, mode, median](https://www.ai-therapy.com/psychology-statistics/descriptive/mean-mode-median), the [dispersion](https://www.ai-therapy.com/psychology-statistics/descriptive/dispersion) and do the [normality tests](https://www.ai-therapy.com/psychology-statistics/distributions/normal) by following the given links. Paste the data, you want to calculate the metrics for, in `reports/<programming_language>/all<Programming Language>Results.json` into the data fields. Click the submit button and get your data on the following site.
2. To do the [Mann-Whitney U-Test](https://www.ai-therapy.com/psychology-statistics/hypothesis-testing/two-samples), select "Independent groups" for "Experiment" design and "Non-parametric" for "Data". Whatever data you want to compare, copy it from the `reports/<programming_language>/all<Programming Language>Results.json` files into the two Sample data fields. You can find the signifance level we used either in the paper or in the [evaluation documentation file](https://github.com/tguttzeit/tha_4-ai_code_examination/blob/main/docs/evaluation_code_generation.md).

### Test Case Generation
1. Calculate the [mean, mode, median](https://www.ai-therapy.com/psychology-statistics/descriptive/mean-mode-median), the [dispersion](https://www.ai-therapy.com/psychology-statistics/descriptive/dispersion) and do the [normality tests](https://www.ai-therapy.com/psychology-statistics/distributions/normal), following the given links.Paste the data, you want to calculate the metrics for, in `reports/<programming_language>_testgen/all<Programming Language>TGResults.json` into the data fields. Click the submit button and get your data on the following site.
2. To do the [Mann-Whitney U-Test](https://www.ai-therapy.com/psychology-statistics/hypothesis-testing/two-samples), select "Independent groups" for "Experiment design" and "Non-parametric" for "Data". Whatever data you want to compare, copy it from the `reports/<programming_language>_testgen/all<Programming Language>TGResults.json` files into the two Sample data fields. You can find the signifance level we used either in the paper or in the [evaluation documentation file](https://github.com/tguttzeit/tha_4-ai_code_examination/blob/main/docs/evaluation_test_generation.md).
3. To check if there is a difference between the three approaches, you can do the [Kruskal-Wallis Test](https://www.ai-therapy.com/psychology-statistics/hypothesis-testing/anova), by selecting "Independent groups" for "Experiment design" and "Non-parametric" for "Data". Whatever data you want to compare, copy it from the `reports/<programming_language>_testgen/all<Programming Language>TGResults.json` files into the three Sample data fields. You can find the signifance level we used either in the paper or in the [evaluation documentation file](https://github.com/tguttzeit/tha_4-ai_code_examination/blob/main/docs/evaluation_test_generation.md).
