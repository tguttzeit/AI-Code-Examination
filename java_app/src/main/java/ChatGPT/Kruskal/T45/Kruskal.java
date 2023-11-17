package ChatGPT.Kruskal.T45;

import java.util.*;

public class Kruskal {

    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> minimumSpanningTree = new ArrayList<>();

        // Sort the edges by weight in ascending order
        Collections.sort(edges, Comparator.comparingInt(edge -> edge.weight));

        DisjointSet disjointSet = new DisjointSet(n);

        for (Edge edge : edges) {
            if (!disjointSet.isConnected(edge.src, edge.dest)) {
                minimumSpanningTree.add(edge);
                disjointSet.union(edge.src, edge.dest);
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
