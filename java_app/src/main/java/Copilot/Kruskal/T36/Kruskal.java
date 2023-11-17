package Copilot.Kruskal.T36;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> result = new ArrayList<>();
        if (edges == null || edges.size() == 0) {
            return result;
        }
        DisjointSet ds = new DisjointSet(n);
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge a, Edge b) {
                return a.weight - b.weight;
            }
        });
        for (Edge edge : edges) {
            if (ds.find(edge.src) != ds.find(edge.dest)) {
                ds.union(edge.src, edge.dest);
                result.add(edge);
            }
        }
        return result;
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
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
}
