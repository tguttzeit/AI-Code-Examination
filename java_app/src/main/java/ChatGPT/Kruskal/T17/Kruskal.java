package ChatGPT.Kruskal.T17;

import java.util.*;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        // Sort the edges in ascending order of their weights
        Collections.sort(edges);

        // Initialize a DisjointSet for n nodes
        DisjointSet disjointSet = new DisjointSet(n);

        List<Edge> minimumSpanningTree = new ArrayList<>();

        for (Edge edge : edges) {
            int srcRoot = disjointSet.find(edge.src);
            int destRoot = disjointSet.find(edge.dest);

            // If including this edge does not create a cycle, add it to the MST
            if (srcRoot != destRoot) {
                minimumSpanningTree.add(edge);
                disjointSet.union(srcRoot, destRoot);
            }
        }

        return minimumSpanningTree;
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
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
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
