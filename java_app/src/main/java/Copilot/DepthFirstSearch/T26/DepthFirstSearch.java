package Copilot.DepthFirstSearch.T26;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;

    public DepthFirstSearch(List<Edge> edges, int n) {
        this.visitedNodes = new ArrayList<Integer>();
        this.adjacencyList = new ArrayList<List<Integer>>(n);
        for (int i = 0; i < n; i++) {
            this.adjacencyList.add(i, new ArrayList<Integer>());
        }
        for (Edge e : edges) {
            this.adjacencyList.get(e.source).add(e.dest);
        }
    }

    public void dfs(int startNode, boolean[] discovered) {
        visitedNodes.add(startNode);
        discovered[startNode] = true;
        for (int i = 0; i < adjacencyList.get(startNode).size(); i++) {
            int neighbor = adjacencyList.get(startNode).get(i);
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
