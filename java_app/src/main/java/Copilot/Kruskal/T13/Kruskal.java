package Copilot.Kruskal.T13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        DisjointSet ds = new DisjointSet(n);
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
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
        public int[] parent;
        public int[] rank;
        public DisjointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i) {
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
            if (px != py) {
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

}
