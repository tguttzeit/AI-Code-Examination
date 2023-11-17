package Copilot.Kruskal.T10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> result = new ArrayList<Edge>();
        Collections.sort(edges);
        DisjointSet disjointSet = new DisjointSet(n);
        for (Edge edge : edges) {
            if (disjointSet.find(edge.src) != disjointSet.find(edge.dest)) {
                disjointSet.union(edge.src, edge.dest);
                result.add(edge);
            }
        }
        return result;
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
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    public static class DisjointSet {
        private int[] parent;
        private int[] rank;

        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = -1;
                rank[i] = -1;
            }
        }

        public int find(int x) {
            if (parent[x] == -1) {
                return x;
            }
            return find(parent[x]);
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[yRoot] < rank[xRoot]) {
                parent[yRoot] = xRoot;
            } else {
                parent[xRoot] = yRoot;
                rank[yRoot]++;
            }
        }
    }
}
