package Copilot.DepthFirstSearch.T33;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public ArrayList<Integer> visitedNodes;
    public List<List<Integer>> adjacencyList;

    public DepthFirstSearch(List<Edge> edges, int n) {
        this.visitedNodes = new ArrayList<Integer>();
        this.adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            this.adjacencyList.add(new ArrayList<Integer>());
        }
        for(Edge e : edges) {
            this.adjacencyList.get(e.source).add(e.dest);
            this.adjacencyList.get(e.dest).add(e.source);
        }
    }

    public void dfs(int startNode, boolean[] discovered) {
        discovered[startNode] = true;
        this.visitedNodes.add(startNode);
        for(int i : this.adjacencyList.get(startNode)) {
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
