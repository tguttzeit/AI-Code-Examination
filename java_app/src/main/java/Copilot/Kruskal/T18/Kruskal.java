package Copilot.Kruskal.T18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> mst = new ArrayList<Edge>();
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(n);
        for (Edge e : edges) {
            if (ds.find(e.src) != ds.find(e.dest)) {
                mst.add(e);
                ds.union(e.src, e.dest);
            }
        }
        return mst;
    }

    public static class Edge implements Comparable<Edge> {
        public int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    public static class DisjointSet {
        private int[] parent;
        private int[] rank;
        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) {
                return;
            }
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
