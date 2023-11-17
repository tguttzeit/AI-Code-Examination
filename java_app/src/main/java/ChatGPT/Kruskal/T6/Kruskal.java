package ChatGPT.Kruskal.T6;

import java.util.*;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges); // Sort the edges by weight in ascending order

        DisjointSet disjointSet = new DisjointSet(n);

        for (Edge edge : edges) {
            if (disjointSet.union(edge.src, edge.dest)) {
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

        public DisjointSet(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false; // x and y are already in the same set
            }

            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }

            return true;
        }
    }
}