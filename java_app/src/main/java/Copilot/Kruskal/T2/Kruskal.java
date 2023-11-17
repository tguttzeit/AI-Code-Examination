package Copilot.Kruskal.T2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge a, Edge b) {
                return a.weight - b.weight;
            }
        });
        DisjointSet set = new DisjointSet(n);
        for (Edge edge : edges) {
            if (set.find(edge.src) != set.find(edge.dest)) {
                mst.add(edge);
                set.union(edge.src, edge.dest);
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
        int[] parent;
        int[] rank;
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
