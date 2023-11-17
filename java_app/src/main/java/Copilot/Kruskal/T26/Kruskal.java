package Copilot.Kruskal.T26;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {       public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
    Collections.sort(edges);
    DisjointSet set = new DisjointSet(n);
    List<Edge> result = new ArrayList<>();
    for (Edge edge : edges) {
        if (!set.isConnected(edge.src, edge.dest)) {
            set.union(edge.src, edge.dest);
            result.add(edge);
        }
    }
    return result;
}
    public static class Edge implements Comparable<Edge> {
        public int src, dest, weight;
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
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }
            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[px] > rank[py]) {
                parent[py] = px;
            } else {
                parent[py] = px;
                rank[px]++;
            }
        }
    }
}
