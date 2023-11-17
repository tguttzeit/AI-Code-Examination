package ChatGPT.Kruskal.T12;

import java.util.*;

public class Kruskal {

    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        // Initialize a list to store the minimum spanning tree edges
        List<Edge> minimumSpanningTree = new ArrayList<>();

        // Sort the edges in ascending order based on their weights
        Collections.sort(edges);

        // Initialize DisjointSet to keep track of connected components
        DisjointSet disjointSet = new DisjointSet(n);

        // Iterate through sorted edges
        for (Edge edge : edges) {
            int src = edge.src;
            int dest = edge.dest;

            // Check if adding this edge creates a cycle in the minimum spanning tree
            if (!disjointSet.isSameSet(src, dest)) {
                // Add the edge to the minimum spanning tree
                minimumSpanningTree.add(edge);

                // Union the sets of src and dest vertices
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
            // Compare edges based on their weights
            return Integer.compare(this.weight, other.weight);
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
            if (x != parent[x]) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public boolean isSameSet(int x, int y) {
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

