package ChatGPT.Kruskal.T39;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        // Sort the edges by weight in ascending order
        Collections.sort(edges);

        // Create disjoint sets for each vertex
        DisjointSet disjointSet = new DisjointSet(n);

        // Initialize the result list
        List<Edge> result = new ArrayList<>();

        // Iterate through sorted edges and add them to the result if they don't create a cycle
        for (Edge edge : edges) {
            if (!disjointSet.isSameSet(edge.src, edge.dest)) {
                result.add(edge);
                disjointSet.union(edge.src, edge.dest);
            }
        }

        return result;
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
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }

        public boolean isSameSet(int x, int y) {
            return find(x) == find(y);
        }
    }
}
