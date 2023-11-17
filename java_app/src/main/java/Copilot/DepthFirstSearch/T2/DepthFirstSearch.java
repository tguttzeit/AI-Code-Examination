package Copilot.DepthFirstSearch.T2;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjList;
    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<Integer>();
        adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (Edge e : edges) {
            adjList.get(e.source).add(e.dest);
        }
    }
    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        visitedNodes.add(startNode);
        for (int dest : adjList.get(startNode)) {
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
