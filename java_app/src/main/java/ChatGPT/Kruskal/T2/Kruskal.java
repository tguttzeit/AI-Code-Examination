package ChatGPT.Kruskal.T2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        // Sort the edges in ascending order by weight
        Collections.sort(edges);

        // Initialize the disjoint set to keep track of connected components
        DisjointSet disjointSet = new DisjointSet(n);

        List<Edge> minimumSpanningTree = new ArrayList<>();

        for (Edge edge : edges) {
            if (!disjointSet.isConnected(edge.src, edge.dest)) {
                // If adding this edge doesn't create a cycle, add it to the minimum spanning tree
                minimumSpanningTree.add(edge);
                disjointSet.union(edge.src, edge.dest);
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
            // Compare edges based on their weights
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
            if (x != parent[x]) {
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

            if (rootX == rootY) {
                return;
            }

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
