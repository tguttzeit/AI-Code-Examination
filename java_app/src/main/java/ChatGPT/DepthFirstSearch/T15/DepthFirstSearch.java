package ChatGPT.DepthFirstSearch.T15;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    // Inner class representing an edge
    public static class Edge {
        int source;
        int dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    // Global variables
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;

    // Constructor
    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<>();
        adjacencyList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Build the adjacency list
        for (Edge edge : edges) {
            adjacencyList.get(edge.source).add(edge.dest);
            adjacencyList.get(edge.dest).add(edge.source);
        }
    }

    // DFS method
    public void dfs(int startNode, boolean[] discovered) {
        visitedNodes.clear();
        dfsRecursive(startNode, discovered);
    }

    private void dfsRecursive(int currentNode, boolean[] discovered) {
        visitedNodes.add(currentNode);
        discovered[currentNode] = true;

        for (int neighbor : adjacencyList.get(currentNode)) {
            if (!discovered[neighbor]) {
                dfsRecursive(neighbor, discovered);
            }
        }
    }
}
