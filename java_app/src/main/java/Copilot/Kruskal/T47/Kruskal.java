package Copilot.Kruskal.T47;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n){
        List<Edge> mst = new ArrayList<Edge>();
        Collections.sort(edges, new EdgeComparator());
        DisjointSet ds = new DisjointSet(n);
        for (Edge e: edges) {
            if (!ds.find(e.src, e.dest)) {
                ds.union(e.src, e.dest);
                mst.add(e);
            }
        }
        return mst;
    }
    public static class EdgeComparator implements Comparator<Edge> {
        public int compare(Edge e1, Edge e2) {
            return e1.weight - e2.weight;
        }
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
        int[] parent;
        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        public boolean find(int x, int y) {
            return find(x) == find(y);
        }
        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            parent[xRoot] = yRoot;
        }
    }
}
