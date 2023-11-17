package ChatGPT.DepthFirstSearch.T29;

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
            adjacencyList.get(edge.dest).add(edge.source);
        }
    }

    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        visitedNodes.add(startNode);

        for (Integer neighbor : adjacencyList.get(startNode)) {
            if (!discovered[neighbor]) {
                dfs(neighbor, discovered);
            }
        }
    }

    public static class Edge {
        public int source, dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }
}
