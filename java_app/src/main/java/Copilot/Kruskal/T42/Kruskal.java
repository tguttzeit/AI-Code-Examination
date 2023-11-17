package Copilot.Kruskal.T42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge e1, Edge e2) {
                return e1.weight - e2.weight;
            }
        });
        DisjointSet ds = new DisjointSet(n);
        List<Edge> res = new ArrayList<>();
        for (Edge edge : edges) {
            int src = edge.src;
            int dest = edge.dest;
            if (ds.find(src) != ds.find(dest)) {
                res.add(edge);
                ds.union(src, dest);
            }
        }
        return res;
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
        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
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
            if (px != py) {
                parent[px] = py;
            }
        }
    }

}
