package ChatGPT.DepthFirstSearch.T7;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public static ArrayList<Integer> visitedNodes;
    public static List<List<Integer>> adjacencyList;

    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<>();
        adjacencyList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adjacencyList.get(edge.source).add(edge.dest);
            adjacencyList.get(edge.dest).add(edge.source); // Assuming undirected graph
        }
    }

    public static class Edge {
        public int source;
        public int dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    public void dfs(int startNode, boolean[] discovered) {
        visitedNodes.clear(); // Clear the visited nodes list
        dfsRecursive(startNode, discovered);
    }

    private void dfsRecursive(int node, boolean[] discovered) {
        visitedNodes.add(node);
        discovered[node] = true;

        for (int neighbor : adjacencyList.get(node)) {
            if (!discovered[neighbor]) {
                dfsRecursive(neighbor, discovered);
            }
        }
    }
}
