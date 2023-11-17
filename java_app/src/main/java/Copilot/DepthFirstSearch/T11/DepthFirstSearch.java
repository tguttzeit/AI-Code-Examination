package Copilot.DepthFirstSearch.T11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {
    public static ArrayList<Integer> visitedNodes;
    public static List<List<Integer>> adjacencyList;
    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<Integer>();
        adjacencyList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new LinkedList<>());
        }
        for (Edge edge: edges) {
            adjacencyList.get(edge.source).add(edge.dest);
            adjacencyList.get(edge.dest).add(edge.source);
        }
    }
    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        visitedNodes.add(startNode);
        for (int i = 0; i < adjacencyList.get(startNode).size(); i++) {
            if (!discovered[adjacencyList.get(startNode).get(i)]) {
                dfs(adjacencyList.get(startNode).get(i), discovered);
            }
        }
    }
    public static class Edge {
        public int source, dest;
        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }
}
