package ChatGPT.DepthFirstSearch.T28;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    // Global variables
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;

    // Inner class to represent an edge
    public static class Edge {
        int source;
        int dest;

        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    // Constructor
    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<>();
        adjacencyList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Build adjacency list from edges
        for (Edge edge : edges) {
            adjacencyList.get(edge.source).add(edge.dest);
            adjacencyList.get(edge.dest).add(edge.source); // Assuming undirected graph
        }
    }

    // Depth First Search method
    public void dfs(int startNode, boolean[] discovered) {
        // Mark the current node as visited
        discovered[startNode] = true;

        // Pre-order traversal: Add the current node to the visitedNodes list
        visitedNodes.add(startNode);

        // Visit all adjacent nodes
        for (int neighbor : adjacencyList.get(startNode)) {
            if (!discovered[neighbor]) {
                dfs(neighbor, discovered);
            }
        }
    }
}
