# Instructions for Generating Source Code

This guide describes how to generate Java and Python code with ChatGPT and GitHub Copilot. It will also describe how to use the scripts to prepare the project structure or to examine the generated code. The examination data (located in `/reports/<programming language>`) can be used in the analysis repository for Matlab or the tools on the AI-Therapy Statistics website to analyse the results.

## Prerequisites
1. Install Java (We used JDK version `17.0.2.8`).
2. Install Python (We used version `3.10.12`).
3. Install Pylint (We used version `2.17.5`).
4. Install NodeJS (We used version `18.17.1`).
5. Install Matlab (We used version `2022b`).

## Preparing the project folders

1. Remove all old `T<x>` folders in `java_app/src/main`/`py_app/src` and `java_app/src/test`/`py_app/test` main for each algorithm.
2. If you want to increase the sample size, open `scripts/java/createJavaFolders`/`scripts/python/createPythonFolders` and change the value of the `to` constant. 50 is recommended.
3. In a terminal, run the following
   **Java:**
   ```shell
   npm install
   npm run javafolders
   ```
   **Python:**
   ```shell
   npm install
   npm run pyfolders
   ```

## Generating code

### ChatGPT
1. Go to https://chat.openai.com
2. Log in or sign up to open ChatGPT.
3. If you are not in a new chat, press "New chat" in the top left corner.
4. Type one of the algorithm instructions in the "Send a message" box and press enter. (See the _Algorithm Instructions_ chapter at the end of this document for the instructions provided).
5. Copy the generated code from the chat and paste it into one of the recently generated Tx folders in `java_app/src/main/java/ChatGPT/<algorithm>/T<x>`/`py_app/src/ChatGPT/<algorithm>/T<x>`.
6. If the copied code contains any kind of main function, main class or similar, remove it. 
7. Repeat steps 3-5 for each generated algorithm.
8. After you generated all files, run `npm run javaerrors` or `npm run pyerrors`. These script will either tell you if there are uncompilable/uninterpretable files or if everything worked successfully. In the first case, these files need to be generated again. You can find a list of these files in `reports/java/uncompilableFiles.json`/`reports/python/syntaxErrors.json`.

**_NOTE:_** If you don't want to have a very long history of chats, you can open the settings by pressing the three dots next to your profile name in the bottom left corner. Then press "Settings". Then press "Data controls" and turn off the "Chat history & browsing" option.  
This will change the button in the top left corner to 'Clear chat'. Pressing it will reset the current chat window and allow you to generate a new code. ChatGPT will not use the contents of the old window as context for the new generation.

### Copilot
These instructions only cover the generation process using VS Code. Other IDEs may be different.
1. If necessary, go to https://copilot.github.com and sign up for GitHub Copilot.
2. Open a new VS Code window and folder.
3. In VS Code, go to the "Extensions" tab and install the GitHub Copilot extension.
4. Follow the instructions in the bottom right corner of VS Code to sign in to GitHub Copilot.
5. **Java:** 
   1. Open the command palette (Ctrl+Shift+P) and type "Java: Create Java Project".
   2. Follow the prompts to create a new Java project.
   3. Remove `App.js` from the src folder.
   4. Create a new `.java` file in the src folder and give it the same name as the algorithm you want to generate code for.
6. **Python:**
   1. Create a new `.py` file and name it as the algorithm you want to generate code for (in `snake_case`).
   2. Write the class header for the algorithm into the new file. (The class will be written in `CamelCase`).
7. Add one of the algorithm instructions to the file above the class as a code comment. (See the _Algorithm Instructions_ chapter at the end of this document for the instructions provided).
8.  Place the cursor in the class body with the appropriate indentation and press Ctrl+Enter to open the suggestion window. **Be careful:** Never click on any kind of "accept"-option, since it would serve GitHub Copilot as a context for future generations. 
9.  Copy and paste each suggestion into a separate file in a `T<x>` folder in `java_app/src/main/java/Copilot/<algorithm>/T<x>`/`py_app/src/Copilot/<algorithm>/T<x>`. Add any import statements that are needed so that the code can be compiled/interpreted.
10. Close the suggestion window.
11. Repeat steps 8 - 10 to generate additional suggestions.
12. After you generated all files, run `npm run javaerrors` or `npm run pyerrors`. These script will either tell you if there are uncompilable/uninterpretable files or if everything worked successfully. In the first case, these files need to be generated again. You can find a list of these files in `reports/java/uncompilableFiles.json`/`reports/python/syntaxErrors.json`.

## Running report pipelines
To generate all data files of the examination, open a terminal in the project's root folder and run one of the following commands:
```shell
# Java:
./runAllJavaScripts.sh
# Python:
./runAllPythonScripts.sh
```
_**NOTE:**_ If the scripts cannot be executed, try adding the execution rights with: 
```shell
sudo chmod +x script_name.sh
```

The data files containing the results of the examination can be found in `reports/java`/`reports/python`. These files can be used in the code analysis repository as explained in [Instructions for analyising the evaluation](https://github.com/tguttzeit/tha_4-ai_code_examination/blob/main/docs/instructions-analysis.md). More information about some of the examinations can be found in the respective `resource` folder.

## Algorithm instructions - Java

### Bellman Ford Instructions
```java
// Implement a non-static BellmanFord class with a static method bellmanFord(List<Edge> edges, int source, int n). 
// The method should return a Map<Integer, Integer> which contains the shortest path to every other node in the graph. 
// If there is a negative cycle, return null. 
// If there is no path to another node, skip this node in the output. 
// Implement a public local static class Edge with public int parameters source, dest, weight. 
```

### Binary Search Algorithm Instructions
```java
// Implement a non-static class named BinarySearch. 
// Implement the public binarySearch(int, int[]) method. The method should return a boolean.
```

### Binary To Decimal Instructions
```java
// Implement a non-static BinaryToDecimal class. 
// Implement the public convertToDecimal(String binary) method. The method should return an int with the decimal.
```

### Breadth First Search Algorithm Instructions
```java
// Implement a non-static breadth first search class named Graph(int vertices). 
// Implement the public bfs(int sourceVertex) method. The method should return an integer array of parent nodes for each vertex in the graph. The array of parent node values are all initialized to -1 in the bfs(int sourceVertex) method.
// Implement the public addEdge(int, int). The method should add an edge between two vertices.
```

### Depth First Search Instructions
```java
// Implement a non-static public class DepthFirstSearch. 
// Implement the global variable public ArrayList<Integer> visitedNodes. 
// Implement the global variable public List<List<Integer>>, which represents an adjacency list. 
// Implement a constructor public DepthFirstSearch(List<Edge> edges, int n). 
// Implement an inner class public static class Edge with global int variables source, dest. 
// Implement the public void dfs(int startNode, boolean[] discovered) method. The method should implement a depth first search algorithm by pre-order on an undirected graph and write the visited nodes into the global ArrayList<Integer> visitedNodes.
```

### Dijkstra Instructions
```java
// Implement a non-static Dijkstra class with a constructor Dijkstra(List<Edge> edges, int n). 
// Implement a public non-static method findShortestPaths(int source). 
// This method should return a Map<Integer, Integer> which contains the shortest path to every other node in the graph. 
// If there is no path to another node, skip this node in the output. 
// Implement a public local static class Edge with public int parameters source, dest, weight. 
// Implement a public local static class Node with public int parameters vertex, weight. 
```

### Egyptian Fractions Instructions
```java
// Implement a non-static class named EgyptianFractions. 
// Implement the public build(Long numerator, Long denominator) method with a List<Long> return value. 
```

### Floyd Warshall Instructions
```java
// Implement a non-static FloydWarshall class with the constructor FloydWarshall(int nodes). 
// Implement a non-static public method addEdge(int source, int dest, int weight), which returns nothing. 
// Implement a non-static public method path(int source, int dest), which returns an Integer List. 
// Implement a non-static public method run(), which runs the Floyd Warshall algorithm.
```

### Knapsack Algorithm Instructions
```java
// Implement a non-static 0-1 knapsack class named Knapsack. 
// Implement the public int bottomUp(int capacity, int[] weights, int[] values) method. The method should return an int with the maximum value.
```

### Kruskal Instructions
```java
// Implement a non-static Kruskal class with a static method runKruskalAlgorithm(List edges, int n). The method should return a List 
// Implement a public local static class Edge with public int parameters src, dest, weight. 
// Implement a public local static class DisjointSet which manages the graph.
```

### Merge Sort Algorithm Instructions
```java
// Implement a non-static merge sort algorithm class named MergeSort with a public void mergeSort(int[]) method.
```

### Quick Sort Algorithm Instructions
```java
// Implement a non-static quick sort algorithm class named QuickSort with a public void sort(int[]) method.
```

## Algorithm instructions - Python

### Bellman Ford Instructions
```python
# Implement a Bellman Ford algorithm class named BellmanFord in python.
# The constructor should take an integer "vertices".
# Implement a public add_edge() method which takes three integers "source", "destination" and "weight" and returns nothing.
# Implement a public method bellman_ford() which takes an integer "source".
# The method should return a dictionary, containing the shortest path to every other node in the graph. If there is a negative cycle, return None.
# If there is no path to another node, skip this node in the output.
```

###  Binary Search Algorithm Instructions
```python
# Implement a non-static class named BinarySearch in python.
# Implement the public binary_search() method.
# The method should use an integer, an integer list as parameters.
# The method should return a boolean.
```

### Binary To Decimal Instructions
```python
# Implement a non-static BinaryToDecimal class in python.
# Implement the public convert_to_decimal() method.
# The method should take a string "binary". The method should return an int with the decimal.
```

### Breadth First Search Algorithm Instructions
```python
# Implement a non-static breadth first search class named Graph in python.
# The class should take an integer "vertices".
# Implement the public bfs() method. The method should take an integer "vertex".
# The method should return an integer list of visited nodes in the graph.
# Implement the public add_edge() method. The method should take two integers.
# The method should add an edge between two vertices.
```

### Depth First Search Instructions
```python
# Implement a depth first search algorithm class named DepthFirstSearch in python.
# Implement a public add_edge() method which takes two integers "source", "destination" and returns nothing.
# Implement a public dfs() method which takes an integer "start_node" and returns a list of visited nodes.
```

### Dijkstra Instructions
```python
# Implement a class named Dijkstra which implements the Dijkstra algorithm in python.
# The constructor should take an integer "vertices".
# Implement a method add_edge(), which takes three integers "source", "destination", "weight" and returns nothing.
# Implement a method find_shortest_paths() which takes an integer "source" and returns a dictionary, containing the shortest path to every other node in the graph.
# If there is no path to another node, skip this node in the output.
```

### Egyptian Fractions Instructions
```python
# Implement an egyptian fractions algorithm class named EgyptianFractions in python.
# Implement the public build() method which takes two long "numerator", "denominator" and returns a list.
```

### Floyd Warshall Instructions
```python
# Implement a FloydWarshall algorithm class named FloydWarshall in python.
# The constructor should take an integer "nodes".
# Implement a public method add_edge() which takes three integers "source", "destination", "weight" as parameters and returns nothing.
# Implement a public method path() which takes two integers "source" and "destination" and returns an integer list. If there is no path from source to destination, return an empty list.
# Implement a public method run(), which runs the FloydWarshall algorithm.
```

### Knapsack Algorithm Instructions
```python
# Implement a non-static 0-1 knapsack class named Knapsack in python.
# Implement the public bottom_up() method. The method should take an integer "capacity",
# an integer list "weights" and an integer list "values".
# The method should return an int with the maximum value.
```

### Kruskal Instructions
```python
# Implement a Kruskal algorithm class named Kruskal in python.
# The constructor should take an integer "vertices".
# Implement a public method add_edge() which takes three integers "source", "destination", "weight" as parameters and returns nothing.
# Implement a method run_kruskal_algorithm() which creates the minimal spanning tree and returns a list of edges.
```

### Merge Sort Algorithm Instructions
```python
# Implement a non-static merge sort algorithm class named MergeSort with a public
# merge_sort() method in python. The method should take an integer list and
# should return the sorted list.
```

### Quick Sort Algorithm Instructions
```python
# Implement a non-static quick sort algorithm class named QuickSort with a public sort()
# method in python. The method should take an integer list and should return nothing.
```
