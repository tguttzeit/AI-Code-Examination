package Copilot.Kruskal.T7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> mst = new ArrayList<>();
        // create disjoint set
        DisjointSet ds = new DisjointSet(n);
        // sort edges by weight
        Collections.sort(edges, (a, b) -> a.weight - b.weight);
        // iterate through edges
        for (Edge edge : edges) {
            // if the src and dest are not in the same set
            if (ds.find(edge.src) != ds.find(edge.dest)) {
                // add the edge to the mst
                mst.add(edge);
                // union the src and dest
                ds.union(edge.src, edge.dest);
            }
        }
        return mst;
    }
    public static class Edge {
        public int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public static class DisjointSet {
        private int[] parent, rank;
        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = i;
            }
        }
        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }
        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
            }
        }
    }

}
