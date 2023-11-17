package Copilot.DepthFirstSearch.T45;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;
    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<Integer>();
        adjacencyList = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        for(Edge edge : edges) {
            adjacencyList.get(edge.source).add(edge.dest);
            adjacencyList.get(edge.dest).add(edge.source);
        }
    }
    public void dfs(int startNode, boolean[] discovered) {
        visitedNodes.add(startNode);
        discovered[startNode] = true;
        for(int i : adjacencyList.get(startNode)) {
            if(!discovered[i]) {
                dfs(i, discovered);
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
