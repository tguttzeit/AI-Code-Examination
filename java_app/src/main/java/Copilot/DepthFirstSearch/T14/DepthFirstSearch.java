package Copilot.DepthFirstSearch.T14;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;

    public DepthFirstSearch(List<Edge> edges, int n) {
        this.visitedNodes = new ArrayList<Integer>();
        this.adjacencyList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            this.adjacencyList.add(new ArrayList<Integer>());
        }
        for (Edge edge : edges) {
            this.adjacencyList.get(edge.source).add(edge.dest);
            this.adjacencyList.get(edge.dest).add(edge.source);
        }
    }

    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        this.visitedNodes.add(startNode);
        for (int i = 0; i < this.adjacencyList.get(startNode).size(); i++) {
            int nextNode = this.adjacencyList.get(startNode).get(i);
            if (!discovered[nextNode]) {
                dfs(nextNode, discovered);
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
