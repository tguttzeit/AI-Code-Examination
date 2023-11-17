package ChatGPT.Kruskal.T36;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> minimumSpanningTree = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet(n);

        // Sort the edges by weight in ascending order
        Collections.sort(edges, Comparator.comparingInt(edge -> edge.weight));

        for (Edge edge : edges) {
            int srcRoot = disjointSet.find(edge.src);
            int destRoot = disjointSet.find(edge.dest);

            // If including this edge does not create a cycle, add it to the minimum spanning tree
            if (srcRoot != destRoot) {
                minimumSpanningTree.add(edge);
                disjointSet.union(srcRoot, destRoot);
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

        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        public void union(int node1, int node2) {
            int root1 = find(node1);
            int root2 = find(node2);

            if (root1 != root2) {
                parent[root1] = root2;
            }
        }
    }

}
