package Copilot.DepthFirstSearch.T4;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;

    public DepthFirstSearch(List<Edge> edges, int n) {

        visitedNodes = new ArrayList<>();
        adjacencyList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (Edge edge : edges) {
            adjacencyList.get(edge.source).add(edge.dest);
            adjacencyList.get(edge.dest).add(edge.source);
        }
    }

    public static class Edge {
        int source;
        int dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    public void dfs(int startNode, boolean[] discovered) {

        discovered[startNode] = true;
        visitedNodes.add(startNode);

        for (int i = 0; i < adjacencyList.get(startNode).size(); i++) {
            int dest = adjacencyList.get(startNode).get(i);

            if (!discovered[dest]) {
                dfs(dest, discovered);
            }
        }
    }
}
