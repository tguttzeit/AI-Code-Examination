package Copilot.DepthFirstSearch.T23;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjList;

    public DepthFirstSearch(List<Edge> edges, int n) {
        this.visitedNodes = new ArrayList<Integer>();
        this.adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            this.adjList.add(new ArrayList<>());
        }
        for (Edge edge : edges) {
            this.adjList.get(edge.source).add(edge.dest);
            this.adjList.get(edge.dest).add(edge.source);
        }
    }

    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        this.visitedNodes.add(startNode);
        for (int neighbor : this.adjList.get(startNode)) {
            if (!discovered[neighbor]) {
                dfs(neighbor, discovered);
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
