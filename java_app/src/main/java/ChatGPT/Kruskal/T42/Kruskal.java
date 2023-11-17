package ChatGPT.Kruskal.T42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> minimumSpanningTree = new ArrayList<>();

        // Sort the edges in ascending order by weight
        Collections.sort(edges, Comparator.comparingInt(e -> e.weight));

        // Initialize disjoint set data structure
        DisjointSet disjointSet = new DisjointSet(n);

        for (Edge edge : edges) {
            int src = edge.src;
            int dest = edge.dest;

            // Check if adding this edge creates a cycle
            if (!disjointSet.isSameSet(src, dest)) {
                minimumSpanningTree.add(edge);
                disjointSet.union(src, dest);
            }
        }

        return minimumSpanningTree;
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