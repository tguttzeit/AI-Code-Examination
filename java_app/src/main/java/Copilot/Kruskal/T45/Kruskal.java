package Copilot.Kruskal.T45;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List runKruskalAlgorithm(List edges, int n) {
        List mst = new ArrayList();
        DisjointSet ds = new DisjointSet(n);
        Collections.sort(edges, new Comparator() {
            public int compare(Object a, Object b) {
                return ((Edge) a).weight - ((Edge) b).weight;
            }
        });
        for (int i = 0; i < edges.size(); i++) {
            Edge e = (Edge) edges.get(i);
            if (ds.find(e.src) != ds.find(e.dest)) {
                mst.add(e);
                ds.union(e.src, e.dest);
            }
        }
        return mst;
    }

    public static class Edge {
        public int src;
        public int dest;
        public int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
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
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
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
