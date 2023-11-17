package ChatGPT.Kruskal.T32;

import java.util.*;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        Collections.sort(edges); // Sort edges by weight in ascending order
        List<Edge> minimumSpanningTree = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet(n);

        for (Edge edge : edges) {
            if (!disjointSet.areVerticesConnected(edge.src, edge.dest)) {
                disjointSet.union(edge.src, edge.dest);
                minimumSpanningTree.add(edge);
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

        public DisjointSet(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
        }

        public int find(int vertex) {
            if (parent[vertex] < 0) {
                return vertex;
            } else {
                int root = find(parent[vertex]);
                parent[vertex] = root; // Path compression
                return root;
            }
        }

        public boolean areVerticesConnected(int u, int v) {
            return find(u) == find(v);
        }

        public void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU != rootV) {
                if (parent[rootU] < parent[rootV]) {
                    parent[rootU] += parent[rootV];
                    parent[rootV] = rootU;
                } else {
                    parent[rootV] += parent[rootU];
                    parent[rootU] = rootV;
                }
            }
        }
    }
}