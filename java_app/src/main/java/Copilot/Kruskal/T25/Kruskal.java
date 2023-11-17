package Copilot.Kruskal.T25;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges);
        DisjointSet d = new DisjointSet(n);
        for (Edge e : edges) {
            if (d.find(e.src) != d.find(e.dest)) {
                mst.add(e);
                d.union(e.src, e.dest);
            }
        }
        return mst;
    }
    public static class Edge implements Comparable<Edge> {
        public int src;
        public int dest;
        public int weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    public static class DisjointSet {
        private int[] parent;
        private int[] rank;
        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        public int find(int i) {
            if (parent[i] == i) return i;
            return find(parent[i]);
        }
        public void union(int x, int y) {
            int xroot = find(x);
            int yroot = find(y);
            if (xroot == yroot) return;
            if (rank[xroot] < rank[yroot]) parent[xroot] = yroot;
            else if (rank[xroot] > rank[yroot]) parent[yroot] = xroot;
            else {
                parent[yroot] = xroot;
                rank[xroot]++;
            }
        }
    }
}
