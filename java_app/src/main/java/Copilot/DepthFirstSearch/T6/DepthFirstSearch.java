package Copilot.DepthFirstSearch.T6;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;
    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<Integer>();
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            int source = edges.get(i).source;
            int dest = edges.get(i).dest;
            adjacencyList.get(source).add(dest);
            adjacencyList.get(dest).add(source);
        }
    }
    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        visitedNodes.add(startNode);
        for (int i = 0; i < adjacencyList.get(startNode).size(); i++) {
            int neighbor = adjacencyList.get(startNode).get(i);
            if (discovered[neighbor] == false) {
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