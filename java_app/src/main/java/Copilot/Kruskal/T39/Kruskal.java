package Copilot.Kruskal.T39;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> result = new ArrayList<>();
        if (edges == null || edges.size() == 0 || n <= 0) {
            return result;
        }
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                if (e1.weight == e2.weight) {
                    return 0;
                }
                return e1.weight < e2.weight ? -1 : 1;
            }
        });
        DisjointSet ds = new DisjointSet(n);
        for (Edge edge : edges) {
            if (ds.find(edge.src) != ds.find(edge.dest)) {
                result.add(edge);
                ds.union(edge.src, edge.dest);
            }
        }
        return result;
    }

    static class Edge {
        int src;
        int dest;
        int weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class DisjointSet {
        int[] parent;
        int[] rank;
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
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[px] < rank[py]) {
                parent[px] = py;
            } else {
                parent[px] = py;
                rank[py]++;
            }
        }
    }

}
