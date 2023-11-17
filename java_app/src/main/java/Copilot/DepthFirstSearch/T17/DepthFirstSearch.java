package Copilot.DepthFirstSearch.T17;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;

    public DepthFirstSearch(List<Edge> edges, int n) {
        this.visitedNodes = new ArrayList<Integer>();
        this.adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            this.adjacencyList.get(edge.source).add(edge.dest);
            this.adjacencyList.get(edge.dest).add(edge.source);
        }
    }

    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        this.visitedNodes.add(startNode);

        for (int dest : this.adjacencyList.get(startNode)) {
            if (!discovered[dest]) {
                dfs(dest, discovered);
            }
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
}
