package ChatGPT.DepthFirstSearch.T10;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    // Global variables
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;

    // Edge inner class
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
        adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adjacencyList.get(edge.source).add(edge.dest);
            adjacencyList.get(edge.dest).add(edge.source);
        }
    }

    // DFS method
    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        visitedNodes.add(startNode);

        for (int neighbor : adjacencyList.get(startNode)) {
            if (!discovered[neighbor]) {
                dfs(neighbor, discovered);
            }
        }
    }
}
