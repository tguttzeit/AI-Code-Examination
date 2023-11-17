package ChatGPT.DepthFirstSearch.T6;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    // Global variables
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;

    // Inner Edge class
    public static class Edge {
        int source;
        int dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    // Constructor
    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<>();
        adjacencyList = new ArrayList<>();

        // Initialize adjacencyList with empty lists
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Populate adjacencyList from the edges
        for (Edge edge : edges) {
            adjacencyList.get(edge.source).add(edge.dest);
            adjacencyList.get(edge.dest).add(edge.source);
        }
    }

    // Depth First Search (DFS) method
    public void dfs(int startNode, boolean[] discovered) {
        // Mark the current node as visited
        visitedNodes.add(startNode);
        discovered[startNode] = true;

        // Visit all adjacent nodes of the current node
        for (int neighbor : adjacencyList.get(startNode)) {
            if (!discovered[neighbor]) {
                // Recursively call DFS for unvisited neighbors
                dfs(neighbor, discovered);
            }
        }
    }
}
