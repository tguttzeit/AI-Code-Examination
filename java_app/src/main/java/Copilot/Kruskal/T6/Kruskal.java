package Copilot.Kruskal.T6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges, (e1, e2) -> e1.weight - e2.weight);
        DisjointSet ds = new DisjointSet(n);
        for (Edge e : edges) {
            if (ds.union(e.src, e.dest)) {
                mst.add(e);
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
        int[] parents;
        public DisjointSet(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }
        public int find(int x) {
            if (parents[x] == x) {
                return x;
            }
            parents[x] = find(parents[x]);
            return parents[x];
        }
        public boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return false;
            }
            parents[px] = py;
            return true;
        }
    }
}
