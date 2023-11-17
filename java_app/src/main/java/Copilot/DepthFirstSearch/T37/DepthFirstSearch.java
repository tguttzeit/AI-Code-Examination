package Copilot.DepthFirstSearch.T37;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;

    public DepthFirstSearch(List<Edge> edges, int n) {
        this.visitedNodes = new ArrayList<Integer>();
        this.adjacencyList = new ArrayList<List<Integer>>(n);
        for (int i = 0; i < n; i++) {
            this.adjacencyList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.size(); i++) {
            this.adjacencyList.get(edges.get(i).source).add(edges.get(i).dest);
            this.adjacencyList.get(edges.get(i).dest).add(edges.get(i).source);
        }
    }

    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        this.visitedNodes.add(startNode);
        for (int i = 0; i < this.adjacencyList.get(startNode).size(); i++) {
            if (!discovered[this.adjacencyList.get(startNode).get(i)]) {
                dfs(this.adjacencyList.get(startNode).get(i), discovered);
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
