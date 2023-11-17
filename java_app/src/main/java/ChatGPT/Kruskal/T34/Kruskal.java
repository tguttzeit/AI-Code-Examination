package ChatGPT.Kruskal.T34;

import java.util.*;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        // Sort the edges in ascending order of weights
        Collections.sort(edges);

        List<Edge> minimumSpanningTree = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet(n);

        for (Edge edge : edges) {
            if (!disjointSet.areConnected(edge.src, edge.dest)) {
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
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static class DisjointSet {
        private int[] parent;

        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public boolean areConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }

}
