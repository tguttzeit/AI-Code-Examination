package ChatGPT.Kruskal.T10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> minimumSpanningTree = new ArrayList<>();
        Collections.sort(edges); // Sort edges in ascending order of weights

        DisjointSet disjointSet = new DisjointSet(n);

        for (Edge edge : edges) {
            int src = edge.src;
            int dest = edge.dest;

            if (!disjointSet.isConnected(src, dest)) {
                minimumSpanningTree.add(edge);
                disjointSet.union(src, dest);
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

        public boolean isConnected(int x, int y) {
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
