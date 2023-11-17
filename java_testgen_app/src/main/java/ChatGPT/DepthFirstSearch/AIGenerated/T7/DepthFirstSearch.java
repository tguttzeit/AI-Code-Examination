package ChatGPT.DepthFirstSearch.AIGenerated.T7;

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
            adjacencyList.get(edge.dest).add(edge.source);
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
        if (!discovered[startNode]) {
            discovered[startNode] = true;
            visitedNodes.add(startNode);

            List<Integer> neighbors = adjacencyList.get(startNode);
            for (int neighbor : neighbors) {
                if (!discovered[neighbor]) {
                    dfs(neighbor, discovered);
                }
            }
        }
    }
}
