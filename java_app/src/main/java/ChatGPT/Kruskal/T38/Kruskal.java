package ChatGPT.Kruskal.T38;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        // Sort edges in ascending order based on weight
        Collections.sort(edges, Comparator.comparingInt(Edge::getWeight));

        // Create a disjoint set to manage the graph
        DisjointSet disjointSet = new DisjointSet(n);

        List<Edge> minimumSpanningTree = new ArrayList<>();

        for (Edge edge : edges) {
            int src = edge.getSrc();
            int dest = edge.getDest();

            // Check if adding this edge creates a cycle
            if (!disjointSet.areInSameSet(src, dest)) {
                // Add the edge to the minimum spanning tree
                minimumSpanningTree.add(edge);

                // Union the two sets
                disjointSet.union(src, dest);
            }
        }

        return minimumSpanningTree;
    }

    public static class Edge {
        private final int src;
        private final int dest;
        private final int weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int getSrc() {
            return src;
        }

        public int getDest() {
            return dest;
        }

        public int getWeight() {
            return weight;
        }
    }

    public static class DisjointSet {
        private final int[] parent;

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

        public boolean areInSameSet(int x, int y) {
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
