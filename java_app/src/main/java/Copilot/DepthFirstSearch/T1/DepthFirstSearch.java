package Copilot.DepthFirstSearch.T1;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;

    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<Integer>();
        adjacencyList = new ArrayList<List<Integer>>(n);
        for (int i = 0; i < n; i++) {
            adjacencyList.add(i, new ArrayList<Integer>());
        }
        for (Edge e : edges) {
            adjacencyList.get(e.source).add(e.dest);
        }
    }

    public static class Edge {
        public int source;
        public int dest;
    }

    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        visitedNodes.add(startNode);
        for (int i : adjacencyList.get(startNode)) {
            if (!discovered[i]) {
                dfs(i, discovered);
            }
        }
    }
}
