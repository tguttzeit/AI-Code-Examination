package Copilot.DepthFirstSearch.T24;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    // Implement the global variable public ArrayList<Integer> visitedNodes.
    // Implement the global variable public List<List<Integer>>, which represents an adjacency list.
    public ArrayList<Integer> visitedNodes = new ArrayList<Integer>();
    public List<List<Integer>> adjList = new ArrayList<List<Integer>>();

    // Implement a constructor public DepthFirstSearch(List<Edge> edges, int n).
    public DepthFirstSearch(List<Edge> edges, int n) {
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge.dest);
        }
    }

    // Implement an inner class public static class Edge with global int variables source, dest.
    public static class Edge {
        int source;
        int dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    // Implement the public void dfs(int startNode, boolean[] discovered) method. The method should implement a depth first search algorithm by pre-order on an undirected graph and write the visited nodes into the global ArrayList<Integer> visitedNodes.
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
