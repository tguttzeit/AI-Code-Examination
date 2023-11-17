# Instructions for Generating Test Cases

This guide describes how to generate Java and Python test cases with both ChatGPT and GitHub Copilot. It will also describe how to use the scripts to prepare the project structure or to examine the generated source code. The test data (located in `/reports/<programming language>_testgen`) can be used in the analysis repository for Matlab or the tools on the AI-Therapy Statistics website to analyse the results.

**_NOTE:_** This experiment can only be conducted if the source code generation experiment has already been conducted before.

## Preparing the project folders
1. Remove the following folders:
   1. **Java:**  
    `java_testgen_app/src/main/java/*`,  
    `java_testgen_app/src/test/java/*`,  
    `java_testgen_app/bin/main/java/*`,  
    `java_testgen_app/bin/test/java/*`,  
    `java_testgen_app/jacoco/main/java/*`,  
    `java_testgen_app/jacoco/test/java/*`,  
    `java_testgen_app/old/test/java/*`  
   2. **Python:**  
    `py_testgen_app/src/*`,  
    `py_testgen_app/test/*`,  
    `py_testgen_app/old/*`
2. Run one of the following two commands in a terminal in the project's root directory:
   ```shell
   # Java:
   ./tg_JavaPipelineOne.sh
   # Python:
   ./tg_pyPipelineOne.sh
   ```
3. When the script is finished, there should be an output telling you what to do next. Above that, there is an output telling whether finding a random AI-generated implementation for each algorithm was successful. If an algorithm has no usable implementation, this will be printed.

## Generating Code
### ChatGPT
1. Go to https://chat.openai.com
2. Log in or sign up to open ChatGPT.
3. If you are not in a new chat, press "New chat" in the top left corner.
4. Paste in the instructions, depending on the approach:
   1. **PromptOnly:** Type one of the test case instructions in the "Send a message" box and press enter. (See the _Test Case Instructions (PromptOnly)_ chapters at the end of this document for the instructions provided).
   2. **BookExampleCode:** Go to the `java_testgen_app/src/main/java/ChatGPT/<algorithm>/BookExampleCode/T1`/`py_testgen_app/src/ChatGPT/<algorithm>/BookExampleCode/T1` directory and copy the content of the file into to the "Send a message" box. Then take the test case instructions from the chapters _Test Case Instructions - (BookExampleCode/AIGenerated)_ and paste it below the algorithm implementation. Press Enter. 
   3. **AIGenerated:** Go to the `java_testgen_app/src/main/java/ChatGPT/<algorithm>/AIGenerated/T1`/`py_testgen_app/src/ChatGPT/<algorithm>/AIGenerated/T1` directory and copy the content of the file into to the "Send a message" box. Then take the test case instructions from the chapters _Test Case Instructions (BookExampleCode/AIGenerated)_ and paste it below the algorithm implementation. Press Enter.
5. Copy the generated code from the chat and paste it into the file in one of the recently generated  `java_testgen_app/src/test/java/ChatGPT/<algorithm>/T<x>`/`py_testgen_app/test/ChatGPT/<algorithm>/T<x>` folders.
6. If the copied code contains a new implementation of the algorithm itself, remove it. 
7. Repeat steps 3-5 for each generated algorithm.

**_NOTE:_** If you don't want to have a very long history of chats, you can open the settings by pressing the three dots next to your profile name in the bottom left corner. Then press "Settings". Then press " Data controls" and turn off the "Chat history & browsing" option.  
This will change the button in the top left corner to 'Clear chat'. Pressing it will reset the current chat window and allow you to generate a new code. ChatGPT will not use the contents of the old window as context for the new generation.

### Copilot
These instructions only cover the generation process using VS Code. Other IDEs may be different.
1. If necessary, go to https://copilot.github.com and sign up for GitHub copilot.
2. Open a new VS Code window and folder.
3. In VS Code, go to the "Extensions" tab and install the GitHub Copilot extension.
4. Follow the instructions in the bottom right corner of VS Code to sign in to GitHub Copilot.
5. **Java:** 
   1. Open the command palette (Ctrl+Shift+P) and type "Java: Create Java Project".
   2. Follow the prompts to create a new Java project.
   3. Remove `App.js` from the src folder.
   4. Create a new `.java` file in the src folder and give it the same name as the test class you want to generate code for.
6. **Python:** 
   1. Create a new `.py` file and name it as the test class you want to generate code for (in `snake_case`).
   2. Add `from <T1 package> import <Algorithm>` (from the test file) and `import unittest`.
   3. Write the class header for the test class into the new file. (The class will be written in `CamelCase` and inherits the `unittest.TestCase` class).
7. Paste in the instructions, depending on the approach:
   1. **PromptOnly:** Paste in one of the test case instructions above the class header (See the _Algorithm Instructions (PromptOnly)_ chapters at the end of this document for the instructions provided).
   2. **BookExampleCode:** Go to the `java_testgen_app/src/main/java/Copilot/<algorithm>/BookExampleCode/T1`/`py_testgen_app/src/Copilot/<algorithm>/BookExampleCode/T1` directory and copy the content of the file into to the file of your "Copilot VS Code window". Paste it above the class header of the test class. Then take the test case instructions from the chapter _Test Case Instructions (BookExampleCode/AIGenerated)_ and paste it above the class header of the test class. 
   3. **AIGenerated:** Go to the `java_testgen_app/src/main/java/Copilot/<algorithm>/AIGenerated/T1`/`py_testgen_app/src/Copilot/<algorithm>/AIGenerated/T1` directory and copy the content of the file into to the file of your "Copilot VS Code window". Paste it above the class header of the test class. Then take the test case instructions from the chapter _Test Case Instructions (BookExampleCode/AIGenerated)_ and paste it above the class header of the test class. 
8.  Place the cursor in the class body with the appropriate indentation and press Ctrl+Enter to open the suggestion window. **Be careful:** Never click on any kind of "accept"-option, since it would serve GitHub Copilot as a context for future generations. 
9.  Copy and paste each suggestion into a separate file in a `T<x>` folder in `java_app/src/main/java/Copilot/<algorithm>/T<x>`/`py_app/src/Copilot/<algorithm>/T<x>`.
10. Close the suggestion window.
11. Repeat steps 8 - 10 to generate additional suggestions.

## Checking if all files can be compiled or interpreted
Run one of the following commands:
```shell
# Java:
npm run javatgcheck
# Python
npm run pytgcheck
```
These scripts will create a file `reports/<programming language>_testgen/unsufficientTests.json` that lists all files that cannot be compiled or interpreted. Correct the content of these files with the least changes possible to make them compilable/interpretable. The amount of changes is calculated using the [Levenshtein distance](https://en.wikipedia.org/wiki/Levenshtein_distance). Try to achieve the smallest Levenshtein distance to the original file possible.
The only exception to the smallest Levenshtein distance is a halfway generated assertion statement. Since filling these with syntactically but not semantically correct code would affect the later results, delete those assertion statements.

**_NOTE:_** Sadly, we realized that the script checking for uninterpretable Python files misses some files. With the Pylint VS Code extension, those files can be detected, if it contains red error squiggles.

## Running report pipelines
To generate all data files of the examination, open a terminal in the project's root folder and run one of the following commands:
```shell
# Java:
./tg_javaPipelineTwo.sh
# Python:
./tg_pyPipelineTwo.sh
```
_**NOTE:**_ If the scripts cannot be executed, try adding the execution rights with: 
```shell
sudo chmod +x script_name.sh
```

The data files containing the results of the examination can be found in `reports/java_testgen`/`reports/python_testgen`. These files can be used in the code analysis repository as explained in [Instructions for analyising the evaluation](https://github.com/tguttzeit/tha_4-ai_code_examination/blob/main/docs/instructions-analysis.md). More information about some of the examinations can be found in the respective `resource` folder.

## Test Case Generation
### Java - Prompt Only
#### Bellman Ford
```java
// Implement a java test class called BellmanFordTest using JUnit version 4.
// The class BellmanFord that is to be tested contains the following:
// A local public static class Edge with public int parameters source, dest, weight.
// A public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) method. The returned Map contains the shortest path to every other node in the graph.
// If there is a negative cycle, the method returns null.
// If there is no path to another node or if the source and destination node are the same, this node is skipped in the output.
// Implement at least 3 different test cases.
// Build three graphs with the following edges and weights:
// Graph 1:
// List<BellmanFord.Edge> edges = Arrays.asList(
// new BellmanFord.Edge(0, 0, 1),
// new BellmanFord.Edge(1, 2, 3),
// new BellmanFord.Edge(1, 3, 2),
// new BellmanFord.Edge(1, 4, 2),
// new BellmanFord.Edge(3, 2, 5),
// new BellmanFord.Edge(4, 3, 3)
// );
// Graph 2:
// List<BellmanFord.Edge> edges = Arrays.asList(
// new BellmanFord.Edge(0, 1, -1),
// new BellmanFord.Edge(0, 2, 4),
// new BellmanFord.Edge(1, 2, 3),
// new BellmanFord.Edge(1, 4, -2),
// new BellmanFord.Edge(3, 2, 5),
// new BellmanFord.Edge(3, 1, 1),
// new BellmanFord.Edge(4, 3, -3)
// );
// Graph 3:
// List<BellmanFord.Edge> edges = Arrays.asList(
// new BellmanFord.Edge(0, 1, -1),
// new BellmanFord.Edge(0, 2, 4),
// new BellmanFord.Edge(1, 2, 3),
// new BellmanFord.Edge(1, 3, 2),
// new BellmanFord.Edge(1, 4, 2),
// new BellmanFord.Edge(3, 2, 5),
// new BellmanFord.Edge(3, 1, 1),
// new BellmanFord.Edge(4, 3, -3)
// );
```

#### Binary Search
```java
// Implement a java test class called BinarySearchTest using JUnit version 4.
// The class BinarySearch that is to be tested contains the following:
// A public boolean binarySearch(int x, int[] sortedNumbers) method.
// Implement at least 3 different test cases.
```

#### Binary To Decimal
```java
// Implement a java test class called BinaryToDecimalTest using JUnit version 4.
// The class BinaryToDecimal that is to be tested contains the following:
// A public int convertToDecimal(String binary) method. The returned int contains the
decimal.
// Implement at least 3 different test cases.
```

#### Breadth First Search
```java
// Implement a java test class called GraphTest using JUnit version 4.
// The class Graph that is to be tested implements the breadth first search algorithm and contains the following:
// A constructor Graph(int vertices).
// A public int[] bfs(int sourceVertex) method. The returned integer array contains the parent nodes for each vertex in the graph. The values of the parent node array are all initialized to -1 in the bfs(int sourceVertex) method.
// A public void addEdge(int, int) method, which adds an edge between two vertices.
// Implement at least 3 different test cases.
// Build a graph with the following edges:
// breadthFirstSearch.addEdge(0, 1);
// breadthFirstSearch.addEdge(0, 2);
// breadthFirstSearch.addEdge(1, 3);
// breadthFirstSearch.addEdge(2, 3);
// breadthFirstSearch.addEdge(3, 4);
// breadthFirstSearch.addEdge(3, 5);
```

#### Depth First Search
```java
// Implement a java test class called DepthFirstSearchTest using JUnit version 4.
// The class DepthFirstSearch that is to be tested contains the following:
// A global variable public ArrayList<Integer> visitedNodes.
// A global variable public List<List<Integer>>, which represents an adjacency list.
// A constructor public DepthFirstSearch(List<Edge> edges, int n).
// An inner public static class Edge with global int variables source, dest.
// A public void dfs(int startNode, boolean[] discovered) method. The method implements a depth first search algorithm by pre-order on an undirected graph and writes the visited nodes into the global ArrayList<Integer> visitedNodes.
// Consider all possible permutations.
// Implement at least 3 different test cases.
// Build a graph with the following edges:
// List<DepthFirstSearch.Edge> edges = Arrays.asList(
// new DepthFirstSearch.Edge(0, 1),
// new DepthFirstSearch.Edge(0, 3),
// new DepthFirstSearch.Edge(1, 4),
// new DepthFirstSearch.Edge(2, 4),
// new DepthFirstSearch.Edge(2, 5),
// new DepthFirstSearch.Edge(3, 1),
// new DepthFirstSearch.Edge(4, 3),
// new DepthFirstSearch.Edge(5, 5),
// new DepthFirstSearch.Edge(6, 6)
// );
```

#### Dijkstra
```java
// Implement a java test class called DijkstraTest using JUnit version 4.
// The class Dijkstra that is to be tested contains the following:
// A constructor Dijkstra(List<Edge> edges, int n).
// A local public static class Edge with public int parameters source, dest, weight.
// A local public class Node with public int parameters vertex, weight.
// A public boolean onlyPositiveEdgeCosts() method.
// A public Map<Integer, Integer> findShortestPaths(int source) method. The returned Map contains the shortest path to every other node in the graph.
// If there is no path to another node or if the source and destination node are the same, the node is skipped in the output.
// Implement at least 3 different test cases.
// Build three graphs with the following edges and weights:
// Graph 1:
// List<Dijkstra.Edge> edges = Arrays.asList(
// new Dijkstra.Edge(0, 1, 1),
// new Dijkstra.Edge(0, 2, 4),
// new Dijkstra.Edge(1, 2, 3),
// new Dijkstra.Edge(1, 3, 2),
// new Dijkstra.Edge(1, 4, 2),
// new Dijkstra.Edge(3, 2, 5),
// new Dijkstra.Edge(4, 3, 3)
// );
// Graph 2:
// List<Dijkstra.Edge> edges = Arrays.asList(
// new Dijkstra.Edge(0, 1, 1),
// new Dijkstra.Edge(0, 2, 4),
// new Dijkstra.Edge(1, 2, 3),
// new Dijkstra.Edge(1, 3, 2),
// new Dijkstra.Edge(1, 4, 2),
// new Dijkstra.Edge(3, 2, 5),
// new Dijkstra.Edge(3, 1, 1),
// new Dijkstra.Edge(4, 3, 3)
// );
// Graph 3:
// List<Dijkstra.Edge> edges = Arrays.asList(
// new Dijkstra.Edge(0, 0, 1),
// new Dijkstra.Edge(1, 2, 3),
// new Dijkstra.Edge(1, 3, 2),
// new Dijkstra.Edge(1, 4, 2),
// new Dijkstra.Edge(3, 2, 5),
// new Dijkstra.Edge(4, 3, 3)
// );
```

#### Egyptian Fractions
```java
// Implement a java test class called EgyptianFractionsTest using JUnit version 4.
// The class EgyptianFractions that is to be tested contains the following:
// A public List<Long> build(Long numerator, Long denominator) method.
// Implement at least 3 different test cases.
```

#### Floyd Warshall
```java
// Implement a java test class called FloydWarshallTest using JUnit version 4.
// The class FloydWarshall that is to be tested contains the following:
// A constructor FloydWarshall(int nodes).
// A non-static public void addEdge(int source, int dest, int weight) method.
// A non-static public List<Integer> path(int source, int dest) method.
// A non-static public void run() method, which runs the floyd warshall algorithm.
// If there is no path from source to destination or if the source and destination node are the same, the node is skipped in the output.
// Implement at least 3 different test cases.
// Build two graphs with the following edges and weights:
// Graph 1:
// floydWarshall.addEdge(0, 1, 10);
// floydWarshall.addEdge(0, 3, 5);
// floydWarshall.addEdge(1, 3, 2);
// floydWarshall.addEdge(1, 2, 1);
// floydWarshall.addEdge(2, 4, 4);
// floydWarshall.addEdge(3, 1, 3);
// floydWarshall.addEdge(3, 2, 9);
// floydWarshall.addEdge(3, 4, 2);
// floydWarshall.addEdge(4, 2, 6);
// Graph 2:
// floydWarshall.addEdge(0, 2, 5);
// floydWarshall.addEdge(1, 3, 5);
// floydWarshall.addEdge(2, 3, 4);
// floydWarshall.addEdge(3, 2, 4);
// floydWarshall.addEdge(4, 3, 4);
// floydWarshall.addEdge(2, 4, -2);
```

#### Knapsack
```java
// Implement a java test class called KnapsackTest using JUnit version 4.
// The class Knapsack that is to be tested contains the following:
// A public int bottomUp(int capacity, int[] weights, int[] values) method. The returned int contains the maximum value.
// Implement at least 3 different test cases.
```

#### Kruskal
```java
// Implement a java test class called KruskalTest using JUnit version 4.
// The class Kruskal that is to be tested contains the following:
// A public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) method.
// A local public static class Edge with public int parameters src, dest, weight.
// A local public static class DisjointSet, which manages the graph.
// Implement at least 3 different test cases.
// Build two graphs with the following edges and weights:
// Graph 1:
// List<Kruskal.Edge> edges = Arrays.asList(
// new Kruskal.Edge(0, 1, 7),
// new Kruskal.Edge(1, 2, 8),
// new Kruskal.Edge(0, 3, 5),
// new Kruskal.Edge(1, 3, 9),
// new Kruskal.Edge(1, 4, 7),
// new Kruskal.Edge(2, 4, 5),
// new Kruskal.Edge(3, 4, 15),
// new Kruskal.Edge(3, 5, 6),
// new Kruskal.Edge(4, 5, 8),
// new Kruskal.Edge(4, 6, 9),
// new Kruskal.Edge(5, 6, 11)
// );
// Graph 2:
// List<Kruskal.Edge> edges = Arrays.asList(
// new Kruskal.Edge(0, 1, -3),
// new Kruskal.Edge(0, 4, 1),
// new Kruskal.Edge(4, 1, 4),
// new Kruskal.Edge(2, 1, 9),
// new Kruskal.Edge(2, 4, 3),
// new Kruskal.Edge(4, 3, 2)
// );
```

#### Merge Sort
```java
// Implement a java test class called MergeSortTest using JUnit version 4.
// The class MergeSort that is to be tested contains the following:
// A public void mergeSort(int[]) method.
// Implement at least 3 different test cases.
```

#### Quick Sort
```java
// Implement a java test class called QuickSortTest using JUnit version 4.
// The class QuickSort that is to be tested contains the following:
// A public void sort(int[]) method.
// Implement at least 3 different test cases.
```

### Java - BookExampleCode/AIGenerated 
#### Bellman Ford
```java
// Implement a java test class for the bellman ford algorithm above using JUnit version 4.
// Implement at least 3 different test cases.
// Build three graphs with the following edges and weights:
// Graph 1:
// List<BellmanFord.Edge> edges = Arrays.asList(
// new BellmanFord.Edge(0, 0, 1),
// new BellmanFord.Edge(1, 2, 3),
// new BellmanFord.Edge(1, 3, 2),
// new BellmanFord.Edge(1, 4, 2),
// new BellmanFord.Edge(3, 2, 5),
// new BellmanFord.Edge(4, 3, 3)
// );
// Graph 2:
// List<BellmanFord.Edge> edges = Arrays.asList(
// new BellmanFord.Edge(0, 1, -1),
// new BellmanFord.Edge(0, 2, 4),
// new BellmanFord.Edge(1, 2, 3),
// new BellmanFord.Edge(1, 4, -2),
// new BellmanFord.Edge(3, 2, 5),
// new BellmanFord.Edge(3, 1, 1),
// new BellmanFord.Edge(4, 3, -3)
// );
// Graph 3:
// List<BellmanFord.Edge> edges = Arrays.asList(
// new BellmanFord.Edge(0, 1, -1),
// new BellmanFord.Edge(0, 2, 4),
// new BellmanFord.Edge(1, 2, 3),
// new BellmanFord.Edge(1, 3, 2),
// new BellmanFord.Edge(1, 4, 2),
// new BellmanFord.Edge(3, 2, 5),
// new BellmanFord.Edge(3, 1, 1),
// new BellmanFord.Edge(4, 3, -3)
// );
```

#### Binary Search
```java
// Implement a java test class for the binary search algorithm above using JUnit version 4.
// Implement at least 3 different test cases.
```

#### Binary To Decimal
```java
// Implement a java test class for the binary to decimal algorithm above using JUnit version 4.
// Implement at least 3 different test cases.
```

#### Breadth First Search
```java
// Implement a java test class for the breadth first search algorithm above using JUnit version 4.
// Implement at least 3 different test cases.
// Build a graph with the following edges:
// breadthFirstSearch.addEdge(0, 1);
// breadthFirstSearch.addEdge(0, 2);
// breadthFirstSearch.addEdge(1, 3);
// breadthFirstSearch.addEdge(2, 3);
// breadthFirstSearch.addEdge(3, 4);
// breadthFirstSearch.addEdge(3, 5);
```

#### Depth First Search
```java
// Implement a java test class for the depth first search algorithm above using JUnit version 4.
// Implement at least 3 different test cases.
// Build a graph with the following edges:
// List<DepthFirstSearch.Edge> edges = Arrays.asList(
// new DepthFirstSearch.Edge(0, 1),
// new DepthFirstSearch.Edge(0, 3),
// new DepthFirstSearch.Edge(1, 4),
// new DepthFirstSearch.Edge(2, 4),
// new DepthFirstSearch.Edge(2, 5),
// new DepthFirstSearch.Edge(3, 1),
// new DepthFirstSearch.Edge(4, 3),
// new DepthFirstSearch.Edge(5, 5),
// new DepthFirstSearch.Edge(6, 6)
// );
```

#### Dijkstra
```java
// Implement a java test class for the dijkstra algorithm above using JUnit version 4.
// Implement at least 3 different test cases.
// Build three graphs with the following edges and weights:
// Graph 1:
// List<Dijkstra.Edge> edges = Arrays.asList(
// new Dijkstra.Edge(0, 1, 1),
// new Dijkstra.Edge(0, 2, 4),
// new Dijkstra.Edge(1, 2, 3),
// new Dijkstra.Edge(1, 3, 2),
// new Dijkstra.Edge(1, 4, 2),
// new Dijkstra.Edge(3, 2, 5),
// new Dijkstra.Edge(4, 3, 3)
// );
// Graph 2:
// List<Dijkstra.Edge> edges = Arrays.asList(
// new Dijkstra.Edge(0, 1, 1),
// new Dijkstra.Edge(0, 2, 4),
// new Dijkstra.Edge(1, 2, 3),
// new Dijkstra.Edge(1, 3, 2),
// new Dijkstra.Edge(1, 4, 2),
// new Dijkstra.Edge(3, 2, 5),
// new Dijkstra.Edge(3, 1, 1),
// new Dijkstra.Edge(4, 3, 3)
// );
// Graph 3:
// List<Dijkstra.Edge> edges = Arrays.asList(
// new Dijkstra.Edge(0, 0, 1),
// new Dijkstra.Edge(1, 2, 3),
// new Dijkstra.Edge(1, 3, 2),
// new Dijkstra.Edge(1, 4, 2),
// new Dijkstra.Edge(3, 2, 5),
// new Dijkstra.Edge(4, 3, 3)
// );
```

#### Egyptian Fractions
```java
// Implement a java test class for the egyptian fractions algorithm above using JUnit version 4.
// Implement at least 3 different test cases.
```

#### Floyd Warshall
```java
// Implement a java test class for the floyd warshall algorithm above using JUnit version 4.
// Implement at least 3 different test cases.
// Build two graphs with the following edges and weights:
// Graph 1:
// floydWarshall.addEdge(0, 1, 10);
// floydWarshall.addEdge(0, 3, 5);
// floydWarshall.addEdge(1, 3, 2);
// floydWarshall.addEdge(1, 2, 1);
// floydWarshall.addEdge(2, 4, 4);
// floydWarshall.addEdge(3, 1, 3);
// floydWarshall.addEdge(3, 2, 9);
// floydWarshall.addEdge(3, 4, 2);
// floydWarshall.addEdge(4, 2, 6);
// Graph 2:
// floydWarshall.addEdge(0, 2, 5);
// floydWarshall.addEdge(1, 3, 5);
// floydWarshall.addEdge(2, 3, 4);
// floydWarshall.addEdge(3, 2, 4);
// floydWarshall.addEdge(4, 3, 4);
// floydWarshall.addEdge(2, 4, -2);
```

#### Knapsack
```java
// Implement a java test class for the knapsack algorithm above using JUnit version 4.
// Implement at least 3 different test cases.
```

#### Kruskal
```java
// Implement a java test class for the kruskal algorithm above using JUnit version 4.
// Implement at least 3 different test cases.
// Build two graphs with the following edges and weights:
// Graph 1:
// List<Kruskal.Edge> edges = Arrays.asList(
// new Kruskal.Edge(0, 1, 7),
// new Kruskal.Edge(1, 2, 8),
// new Kruskal.Edge(0, 3, 5),
// new Kruskal.Edge(1, 3, 9),
// new Kruskal.Edge(1, 4, 7),
// new Kruskal.Edge(2, 4, 5),
// new Kruskal.Edge(3, 4, 15),
// new Kruskal.Edge(3, 5, 6),
// new Kruskal.Edge(4, 5, 8),
// new Kruskal.Edge(4, 6, 9),
// new Kruskal.Edge(5, 6, 11)
// );
// Graph 2:
// List<Kruskal.Edge> edges = Arrays.asList(
// new Kruskal.Edge(0, 1, -3),
// new Kruskal.Edge(0, 4, 1),
// new Kruskal.Edge(4, 1, 4),
// new Kruskal.Edge(2, 1, 9),
// new Kruskal.Edge(2, 4, 3),
// new Kruskal.Edge(4, 3, 2)
// );
```

#### Merge Sort
```java
// Implement a java test class for the merge sort algorithm above using JUnit version 4.
// Implement at least 3 different test cases.
```

#### Quick Sort
```java
// Implement a java test class for the quick sort algorithm above using JUnit version 4.
// Implement at least 3 different test cases.
```
### Python - Prompt Only
#### Bellman Ford
```python
# Implement a python test class called BellmanFordTest using the unittest module.
# The class BellmanFord that is to be tested contains the following methods:
# A constructor, which takes an integer "vertices".
# A public method add_edge(), which takes three integers "source", "destination", "weight" and returns nothing.
# A public method bellman_ford(), which takes an integer "source" and returns a dictionary, containing the shortest path to every other node in the graph.
# If there is a negative cycle, the method returns None.
# If there is no path from source to destination or if the source and destination node are the same, this node is skipped in the output.
# Implement at least 3 different test cases.
# Build three graphs with the following edges and weights:
# Graph 1:
# self.bellmanFord.add_edge(0, 1, -1)
# self.bellmanFord.add_edge(0, 2, 4)
# self.bellmanFord.add_edge(1, 2, 3)
# self.bellmanFord.add_edge(1, 3, 2)
# self.bellmanFord.add_edge(1, 4, 2)
# self.bellmanFord.add_edge(3, 1, 1)
# self.bellmanFord.add_edge(4, 3, -3)
# Graph 2:
# self.bellmanFord.add_edge(0, 1, -1)
# self.bellmanFord.add_edge(0, 2, 4)
# self.bellmanFord.add_edge(1, 2, 3)
# self.bellmanFord.add_edge(1, 4, -2)
# self.bellmanFord.add_edge(3, 2, 5)
# self.bellmanFord.add_edge(3, 1, 1)
# self.bellmanFord.add_edge(4, 3, -3)
# Graph 3:
# self.bellmanFord.add_edge(0, 0, 1)
# self.bellmanFord.add_edge(1, 2, 3)
# self.bellmanFord.add_edge(1, 3, 2)
# self.bellmanFord.add_edge(1, 4, 2)
# self.bellmanFord.add_edge(3, 2, 5)
# self.bellmanFord.add_edge(4, 3, 3)
```

#### Binary Search
```python
# Implement a python test class called BinarySearchTest using the unittest module.
# The class BinarySearch that is to be tested contains the following methods:
# A public method binary_search(), which takes an integer and an integer list as parameters and returns a boolean.
# Implement at least 3 different test cases.
```

#### Binary To Decimal
```python
# Implement a python test class called BinaryToDecimalTest using the unittest module.
# The class BinaryToDecimal that is to be tested contains the following methods:
# A public method convert_to_decimal(), which takes a string "binary" as parameter and returns an integer with the decimal.
# Implement at least 3 different test cases.
```

#### Breadth First Search
```python
# Implement a python test class called GraphTest using the unittest module.
# The class Graph that is to be tested implements the breadth first search algorithm and contains the following methods:
# A constructor that takes an integer "vertices".
# A public method bfs(), which takes an integer "vertex" as parameter and returns an integer list of visited nodes in the graph.
# A public method add_edge(), which takes two integers as parameters and adds an edge between two vertices.
# Implement at least 3 different test cases.
# Build a graph with the following edges:
# self.graph.add_edge(0, 1)
# self.graph.add_edge(1, 0)
# self.graph.add_edge(0, 2)
# self.graph.add_edge(2, 0)
# self.graph.add_edge(1, 3)
# self.graph.add_edge(3, 1)
# self.graph.add_edge(2, 3)
# self.graph.add_edge(3, 2)
# self.graph.add_edge(3, 4)
# self.graph.add_edge(4, 3)
# self.graph.add_edge(3, 5)
# self.graph.add_edge(5, 3)
```

#### Depth First Search
```python
# Implement a python test class called DepthFirstSearchTest using the unittest module.
# The class DepthFirstSearch that is to be tested contains the following methods:
# A public method add_edge(), which takes two integers "source" and "destination" as parameters and returns nothing.
# A public method dfs(), which takes an integer "start_node" and returns a list of visited nodes.
# Consider all possible permutations.
# Implement at least 3 different test cases.
# Build a graph with the following edges:
# self.depthFirstSearch.add_edge(0, 1)
# self.depthFirstSearch.add_edge(1, 0)
# self.depthFirstSearch.add_edge(0, 3)
# self.depthFirstSearch.add_edge(3, 0)
# self.depthFirstSearch.add_edge(1, 4)
# self.depthFirstSearch.add_edge(4, 1)
# self.depthFirstSearch.add_edge(2, 4)
# self.depthFirstSearch.add_edge(4, 2)
# self.depthFirstSearch.add_edge(2, 5)
# self.depthFirstSearch.add_edge(5, 2)
# self.depthFirstSearch.add_edge(3, 1)
# self.depthFirstSearch.add_edge(1, 3)
# self.depthFirstSearch.add_edge(4, 3)
# self.depthFirstSearch.add_edge(3, 4)
# self.depthFirstSearch.add_edge(5, 5)
# self.depthFirstSearch.add_edge(6, 6)
```

#### Dijkstra
```python
# Implement a python test class called DijkstraTest using the unittest module.
# The class Dijkstra that is to be tested contains the following methods:
# A constructor, which takes an integer "vertices".
# A public method add_edge(), which takes three integers "source", "destination", "weight" and returns nothing.
# A public method find_shortest_paths(), which takes an integer "source" and returns a dictionary, containing the shortest path to every other node in the graph.
# If there is no path from source to destination or if the source and destination node are the same, this node is skipped in the output.
# Implement at least 3 different test cases.
# Build two graphs with the following edges and weights:
# Graph 1:
# self.dijkstra.add_edge(0, 1, 1)
# self.dijkstra.add_edge(0, 2, 4)
# self.dijkstra.add_edge(1, 2, 3)
# self.dijkstra.add_edge(1, 3, 2)
# self.dijkstra.add_edge(1, 4, 2)
# self.dijkstra.add_edge(3, 2, 5)
# self.dijkstra.add_edge(3, 1, 1)
# self.dijkstra.add_edge(4, 3, 3)
# Graph 2:
# self.dijkstra.add_edge(0, 0, 1)
# self.dijkstra.add_edge(1, 2, 3)
# self.dijkstra.add_edge(1, 3, 2)
# self.dijkstra.add_edge(1, 4, 2)
# self.dijkstra.add_edge(3, 2, 5)
# self.dijkstra.add_edge(4, 3, 3)
```

#### Egyptian Fractions
```python
# Implement a python test class called EgyptianFractionsTest using the unittest module.
# The class EgyptianFractions that is to be tested contains the following methods:
# A public method build(), which takes two long "numerator" and "denominator" as parameters and returns a list.
# Implement at least 3 different test cases.
```

#### Floyd Warshall
```python
# Implement a python test class called FloydWarshallTest using the unittest module.
# The class FloydWarshall that is to be tested contains the following methods:
# A constructor, which takes an integer "nodes".
# A public method add_edge(), which takes three integers "source", "destination", "weight" as parameters and returns nothing.
# A public method path(), which takes two integers "source" and "destination" and returns an integer list.
# A public method run(), which runs the floyd warshall algorithm.
# If there is no path from source to destination or if the source and destination node are the same, this node is skipped in the output.
# Implement at least 3 different test cases.
# Build two graphs with the following edges and weights:
# Graph 1:
# self.floydWarshall.add_edge(0, 1, 10)
# self.floydWarshall.add_edge(0, 3, 5)
# self.floydWarshall.add_edge(1, 3, 2)
# self.floydWarshall.add_edge(1, 2, 1)
# self.floydWarshall.add_edge(2, 4, 4)
# self.floydWarshall.add_edge(3, 1, 3)
# self.floydWarshall.add_edge(3, 2, 9)
# self.floydWarshall.add_edge(3, 4, 2)
# self.floydWarshall.add_edge(4, 2, 6)
# Graph 2:
# self.floydWarshall.add_edge(0, 2, 5)
# self.floydWarshall.add_edge(1, 3, 5)
# self.floydWarshall.add_edge(2, 3, 4)
# self.floydWarshall.add_edge(3, 2, 4)
# self.floydWarshall.add_edge(4, 3, 4)
# self.floydWarshall.add_edge(2, 4, -2)
```

#### Knapsack
```python
# Implement a python test class called KnapsackTest using the unittest module.
# The class Knapsack that is to be tested contains the following methods:
# A public method bottom_up(), which takes an integer "capacity", an integer list "weights" and an integer list "values" as parameters and returns an integer with the maximum value.
# Implement at least 3 different test cases.
```

#### Kruskal
```python
# Implement a python test class called KruskalTest using the unittest module.
# The class Kruskal that is to be tested contains the following methods:
# A constructor, which takes an integer "vertices".
# A public method add_edge(), which takes three integers "source", "destination", "weight"as parameters and returns nothing.
# A public method run_kruskal_algorithm(), which creates the minimal spanning tree and returns a list of edges.
# Implement at least 3 different test cases.
# Build two graphs with the following edges and weights:
# Graph 1:
# self.kruskal.add_edge(5, 6, 11)
# self.kruskal.add_edge(0, 1, 7)
# self.kruskal.add_edge(1, 2, 8)
# self.kruskal.add_edge(0, 3, 5)
# self.kruskal.add_edge(1, 3, 9)
# self.kruskal.add_edge(1, 4, 7)
# self.kruskal.add_edge(2, 4, 5)
# self.kruskal.add_edge(3, 4, 15)
# self.kruskal.add_edge(3, 5, 6)
# self.kruskal.add_edge(4, 5, 8)
# self.kruskal.add_edge(4, 6, 9)
# Graph 2:
# self.kruskal.add_edge(0, 1, -3)
# self.kruskal.add_edge(0, 4, 1)
# self.kruskal.add_edge(4, 1, 4)
# self.kruskal.add_edge(2, 1, 9)
# self.kruskal.add_edge(2, 4, 3)
# self.kruskal.add_edge(4, 3, 2)
```

#### Merge Sort
```python
# Implement a python test class called MergeSortTest using the unittest module.
# The class MergeSort that is to be tested contains the following methods:
# A public method merge_sort(), which takes an integer list as parameter and returns a sorted integer list.
# Implement at least 3 different test cases.
```

#### Quick Sort
```python
# Implement a python test class called QuickSortTest using the unittest module.
# The class QuickSort that is to be tested contains the following methods:
# A public method sort(), which takes an integer list as parameter and returns nothing.
# Implement at least 3 different test cases.
```

### Python - BookExampleCode/AIGenerated
#### Bellman Ford
```python
# Implement a test class for the bellman ford algorithm above using the python unittest module.
# Implement at least 3 different test cases.
# Build three graphs with the following edges and weights:
# Graph 1:
# self.bellmanFord.add_edge(0, 1, -1)
# self.bellmanFord.add_edge(0, 2, 4)
# self.bellmanFord.add_edge(1, 2, 3)
# self.bellmanFord.add_edge(1, 3, 2)
# self.bellmanFord.add_edge(1, 4, 2)
# self.bellmanFord.add_edge(3, 1, 1)
# self.bellmanFord.add_edge(4, 3, -3)
# Graph 2:
# self.bellmanFord.add_edge(0, 1, -1)
# self.bellmanFord.add_edge(0, 2, 4)
# self.bellmanFord.add_edge(1, 2, 3)
# self.bellmanFord.add_edge(1, 4, -2)
# self.bellmanFord.add_edge(3, 2, 5)
# self.bellmanFord.add_edge(3, 1, 1)
# self.bellmanFord.add_edge(4, 3, -3)
# Graph 3:
# self.bellmanFord.add_edge(0, 0, 1)
# self.bellmanFord.add_edge(1, 2, 3)
# self.bellmanFord.add_edge(1, 3, 2)
# self.bellmanFord.add_edge(1, 4, 2)
# self.bellmanFord.add_edge(3, 2, 5)
# self.bellmanFord.add_edge(4, 3, 3)
```

#### Binary Search
```python
# Implement a test class for the binary search algorithm above using the python unittest module.
# Implement at least 3 different test cases.
```

#### Binary To Decimal
```python
# Implement a test class for the binary to decimal algorithm above using the python unittest module.
# Implement at least 3 different test cases.
```

#### Breadth First Search
```python
# Implement a test class for the breadth first search algorithm above using the python unittest module.
# Implement at least 3 different test cases.
# Build a graph with the following edges:
# self.graph.add_edge(0, 1)
# self.graph.add_edge(1, 0)
# self.graph.add_edge(0, 2)
# self.graph.add_edge(2, 0)
# self.graph.add_edge(1, 3)
# self.graph.add_edge(3, 1)
# self.graph.add_edge(2, 3)
# self.graph.add_edge(3, 2)
# self.graph.add_edge(3, 4)
# self.graph.add_edge(4, 3)
# self.graph.add_edge(3, 5)
# self.graph.add_edge(5, 3)
```

#### Depth First Search
```python
# Implement a test class for the depth first search algorithm above using the python unittest module.
# Implement at least 3 different test cases.
# Consider all possible permutations.
# Build a graph with the following edges:
# self.depthFirstSearch.add_edge(0, 1)
# self.depthFirstSearch.add_edge(1, 0)
# self.depthFirstSearch.add_edge(0, 3)
# self.depthFirstSearch.add_edge(3, 0)
# self.depthFirstSearch.add_edge(1, 4)
# self.depthFirstSearch.add_edge(4, 1)
# self.depthFirstSearch.add_edge(2, 4)
# self.depthFirstSearch.add_edge(4, 2)
# self.depthFirstSearch.add_edge(2, 5)
# self.depthFirstSearch.add_edge(5, 2)
# self.depthFirstSearch.add_edge(3, 1)
# self.depthFirstSearch.add_edge(1, 3)
# self.depthFirstSearch.add_edge(4, 3)
# self.depthFirstSearch.add_edge(3, 4)
# self.depthFirstSearch.add_edge(5, 5)
# self.depthFirstSearch.add_edge(6, 6)
```

#### Dijkstra
```python
# Implement a test class for the dijkstra algorithm above using the python unittest module.
# Implement at least 3 different test cases.
# Build two graphs with the following edges and weights:
# Graph 1:
# self.dijkstra.add_edge(0, 1, 1)
# self.dijkstra.add_edge(0, 2, 4)
# self.dijkstra.add_edge(1, 2, 3)
# self.dijkstra.add_edge(1, 3, 2)
# self.dijkstra.add_edge(1, 4, 2)
# self.dijkstra.add_edge(3, 2, 5)
# self.dijkstra.add_edge(3, 1, 1)
# self.dijkstra.add_edge(4, 3, 3)
# Graph 2:
# self.dijkstra.add_edge(0, 0, 1)
# self.dijkstra.add_edge(1, 2, 3)
# self.dijkstra.add_edge(1, 3, 2)
# self.dijkstra.add_edge(1, 4, 2)
# self.dijkstra.add_edge(3, 2, 5)
# self.dijkstra.add_edge(4, 3, 3)
```

#### Egyptian Fractions
```python
# Implement a test class for the egyptian fractions algorithm above using the python unittest module.
# Implement at least 3 different test cases.
```

#### Floyd Warshall
```python
# Implement a test class for the floyd warshall algorithm above using the python unittest module.
# Implement at least 3 different test cases.
# Build two graphs with the following edges and weights:
# Graph 1:
# self.floydWarshall.add_edge(0, 1, 10)
# self.floydWarshall.add_edge(0, 3, 5)
# self.floydWarshall.add_edge(1, 3, 2)
# self.floydWarshall.add_edge(1, 2, 1)
# self.floydWarshall.add_edge(2, 4, 4)
# self.floydWarshall.add_edge(3, 1, 3)
# self.floydWarshall.add_edge(3, 2, 9)
# self.floydWarshall.add_edge(3, 4, 2)
# self.floydWarshall.add_edge(4, 2, 6)
# Graph 2:
# self.floydWarshall.add_edge(0, 2, 5)
# self.floydWarshall.add_edge(1, 3, 5)
# self.floydWarshall.add_edge(2, 3, 4)
# self.floydWarshall.add_edge(3, 2, 4)
# self.floydWarshall.add_edge(4, 3, 4)
# self.floydWarshall.add_edge(2, 4, -2)
```

#### Knapsack
```python
# Implement a test class for the knapsack algorithm above using the python unittest module.
# Implement at least 3 different test cases.
```

#### Kruskal
```python
# Implement a test class for the kruskal algorithm above using the python unittest module.
# Implement at least 3 different test cases.
# Build two graphs with the following edges and weights:
# Graph 1:
# self.kruskal.add_edge(5, 6, 11)
# self.kruskal.add_edge(0, 1, 7)
# self.kruskal.add_edge(1, 2, 8)
# self.kruskal.add_edge(0, 3, 5)
# self.kruskal.add_edge(1, 3, 9)
# self.kruskal.add_edge(1, 4, 7)
# self.kruskal.add_edge(2, 4, 5)
# self.kruskal.add_edge(3, 4, 15)
# self.kruskal.add_edge(3, 5, 6)
# self.kruskal.add_edge(4, 5, 8)
# self.kruskal.add_edge(4, 6, 9)
# Graph 2:
# self.kruskal.add_edge(0, 1, -3)
# self.kruskal.add_edge(0, 4, 1)
# self.kruskal.add_edge(4, 1, 4)
# self.kruskal.add_edge(2, 1, 9)
# self.kruskal.add_edge(2, 4, 3)
# self.kruskal.add_edge(4, 3, 2)
```

#### Merge Sort
```python
# Implement a test class for the merge sort algorithm above using the python unittest module.
# Implement at least 3 different test cases.
```

#### Quick Sort
```python
# Implement a test class for the quicksort algorithm above using the python unittest module.
# Implement at least 3 different test cases.
```
