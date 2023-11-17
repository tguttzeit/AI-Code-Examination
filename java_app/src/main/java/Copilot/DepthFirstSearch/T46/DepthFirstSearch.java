package Copilot.DepthFirstSearch.T46;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public static ArrayList<Integer> visitedNodes;
    public static List<List<Integer>> adjacencyList;

    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<Integer>();
        adjacencyList = new ArrayList<List<Integer>>(n);

        for (int i = 0; i < n; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }

        for (Edge e : edges) {
            adjacencyList.get(e.source).add(e.dest);
            adjacencyList.get(e.dest).add(e.source);
        }
    }

    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        visitedNodes.add(startNode);

        for (int i = 0; i < adjacencyList.get(startNode).size(); i++) {
            int dest = adjacencyList.get(startNode).get(i);
            if (discovered[dest] == false) {
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
