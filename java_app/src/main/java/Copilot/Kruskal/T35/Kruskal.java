package Copilot.Kruskal.T35;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        DisjointSet graph = new DisjointSet(n);
        List<Edge> result = new ArrayList<Edge>();
        Collections.sort(edges);
        for (Edge edge : edges) {
            if (graph.find(edge.src) != graph.find(edge.dest)) {
                result.add(edge);
                graph.union(edge.src, edge.dest);
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

        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }

    public static class DisjointSet {
        private int[] parents;
        private int[] ranks;

        public DisjointSet(int n) {
            parents = new int[n];
            ranks = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            if (parents[x] == x) {
                return x;
            }
            return parents[x] = find(parents[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (ranks[rootX] < ranks[rootY]) {
                    parents[rootX] = rootY;
                } else if (ranks[rootX] > ranks[rootY]) {
                    parents[rootY] = rootX;
                } else {
                    parents[rootY] = rootX;
                    ranks[rootX]++;
                }
            }
        }
    }

}
