package Copilot.DepthFirstSearch.T36;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;

    public DepthFirstSearch(List<Edge> edges, int n) {
        visitedNodes = new ArrayList<Integer>();
        adjacencyList = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.size(); i++) {
            adjacencyList.get(edges.get(i).source).add(edges.get(i).dest);
            adjacencyList.get(edges.get(i).dest).add(edges.get(i).source);
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
        public int source;
        public int dest;

        public Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }
}
