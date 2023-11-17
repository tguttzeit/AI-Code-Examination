package ChatGPT.DepthFirstSearch.T4;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;

    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<>();
        adjacencyList = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adjacencyList.get(edge.source).add(edge.dest);
            adjacencyList.get(edge.dest).add(edge.source); // For an undirected graph
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
        visitedNodes.clear(); // Clear the visited nodes list before each DFS
        dfsRecursive(startNode, discovered);
    }

    private void dfsRecursive(int node, boolean[] discovered) {
        discovered[node] = true;
        visitedNodes.add(node);

        for (int neighbor : adjacencyList.get(node)) {
            if (!discovered[neighbor]) {
                dfsRecursive(neighbor, discovered);
            }
        }
    }
}
