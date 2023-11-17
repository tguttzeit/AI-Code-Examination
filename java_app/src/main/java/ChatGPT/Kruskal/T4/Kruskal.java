package ChatGPT.Kruskal.T4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        // Sort the edges in ascending order based on their weights
        Collections.sort(edges);

        // Initialize a DisjointSet to keep track of connected components
        DisjointSet disjointSet = new DisjointSet(n);

        List<Edge> minimumSpanningTree = new ArrayList<>();
        int edgeCount = 0;

        // Iterate through the sorted edges and add them to the minimum spanning tree
        for (Edge edge : edges) {
            if (edgeCount >= n - 1) {
                // We have already added enough edges to form a spanning tree
                break;
            }

            int srcRoot = disjointSet.find(edge.src);
            int destRoot = disjointSet.find(edge.dest);

            if (srcRoot != destRoot) {
                // Adding this edge doesn't create a cycle, so we add it to the MST
                minimumSpanningTree.add(edge);
                disjointSet.union(srcRoot, destRoot);
                edgeCount++;
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
