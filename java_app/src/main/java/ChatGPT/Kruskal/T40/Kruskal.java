package ChatGPT.Kruskal.T40;

import java.util.*;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        // Sort the edges in ascending order of weight
        Collections.sort(edges);

        // Initialize a disjoint set to track connected components
        DisjointSet disjointSet = new DisjointSet(n);

        List<Edge> minimumSpanningTree = new ArrayList<>();

        for (Edge edge : edges) {
            int src = edge.src;
            int dest = edge.dest;

            // Check if including this edge forms a cycle
            if (!disjointSet.isConnected(src, dest)) {
                // Include the edge in the minimum spanning tree
                minimumSpanningTree.add(edge);

                // Union the two components
                disjointSet.union(src, dest);
            }
        }

        return minimumSpanningTree;
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
            return Integer.compare(this.weight, other.weight);
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

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}