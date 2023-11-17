package ChatGPT.Kruskal.T44;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        // Sort the edges in ascending order based on their weights
        Collections.sort(edges);

        // Create a disjoint set data structure to track connected components
        DisjointSet disjointSet = new DisjointSet(n);

        List<Edge> minimumSpanningTree = new ArrayList<>();

        for (Edge edge : edges) {
            if (minimumSpanningTree.size() == n - 1) {
                // We've found enough edges to form the minimum spanning tree
                break;
            }

            int srcRoot = disjointSet.find(edge.src);
            int destRoot = disjointSet.find(edge.dest);

            if (srcRoot != destRoot) {
                // The edge does not form a cycle, add it to the minimum spanning tree
                minimumSpanningTree.add(edge);
                disjointSet.union(srcRoot, destRoot);
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
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
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