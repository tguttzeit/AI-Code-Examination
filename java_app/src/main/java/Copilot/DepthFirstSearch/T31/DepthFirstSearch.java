package Copilot.DepthFirstSearch.T31;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public static ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
    public static List<List<Integer>> adjList = new ArrayList<>();
    public static class Edge {
        public int source;
        public int dest;
        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }
    public DepthFirstSearch(List<Edge> edges, int n) {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (Edge e : edges) {
            adjList.get(e.source).add(e.dest);
            adjList.get(e.dest).add(e.source);
        }
    }
    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        visitedNodes.add(startNode);
        for (int i : adjList.get(startNode)) {
            if (!discovered[i]) {
                dfs(i, discovered);
            }
        }
    }
}
