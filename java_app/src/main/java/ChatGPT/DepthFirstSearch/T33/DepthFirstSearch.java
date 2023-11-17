package ChatGPT.DepthFirstSearch.T33;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    // Global variable to store visited nodes
    public ArrayList<Integer> visitedNodes;

    // Global variable representing the adjacency list
    public List<List<Integer>> adjacencyList;

    // Constructor to initialize the DepthFirstSearch class
    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<>();
        adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adjacencyList.get(edge.source).add(edge.dest);
            adjacencyList.get(edge.dest).add(edge.source);
        }
    }

    // Inner class representing an edge
    public static class Edge {
        int source;
        int dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    // Depth-First Search method
    public void dfs(int startNode, boolean[] discovered) {
        if (!discovered[startNode]) {
            visitedNodes.add(startNode);
            discovered[startNode] = true;

            for (int neighbor : adjacencyList.get(startNode)) {
                dfs(neighbor, discovered);
            }
        }
    }
}
