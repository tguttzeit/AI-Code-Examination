package Copilot.DepthFirstSearch.T18;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjList;

    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<Integer>();
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (Edge edge: edges) {
            adjList.get(edge.source).add(edge.dest);
            adjList.get(edge.dest).add(edge.source);
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
        discovered[startNode] = true;
        visitedNodes.add(startNode);
        for (Integer neighbor: adjList.get(startNode)) {
            if (!discovered[neighbor]) {
                dfs(neighbor, discovered);
            }
        }
    }
}
