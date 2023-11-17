package Copilot.DepthFirstSearch.T13;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjList;

    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<Integer>();
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge.dest);
            adjList.get(edge.dest).add(edge.source);
        }
    }

    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        visitedNodes.add(startNode);
        for (int i = 0; i < adjList.get(startNode).size(); i++) {
            int dest = adjList.get(startNode).get(i);
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
