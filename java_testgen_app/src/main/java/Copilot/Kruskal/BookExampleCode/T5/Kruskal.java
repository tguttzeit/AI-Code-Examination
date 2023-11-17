package Copilot.Kruskal.BookExampleCode.T5;

// Source: https://www.techiedelight.com/kruskals-algorithm-for-finding-minimum-spanning-tree/

import java.util.*;

// CHANGES FOR EXPERIMENT: Moved the outer classes to inner static classes

public class Kruskal {
    // Function to construct MST using Kruskal’s algorithm
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        // stores the edges present in MST
        List<Edge> MST = new ArrayList<>();

        // Initialize `DisjointSet` class.
        // create a singleton set for each element of the universe.
        DisjointSet ds = new DisjointSet();
        ds.makeSet(n);

        int index = 0;

        // sort edges by increasing weight
        Collections.sort(edges, Comparator.comparingInt(e -> e.weight));

        // MST contains exactly `V-1` edges
        while (MST.size() != n - 1) {
            // consider the next edge with minimum weight from the graph
            Edge next_edge = edges.get(index++);

            // find the root of the sets to which two endpoints
            // vertices of the next edge belongs
            int x = ds.find(next_edge.src);
            int y = ds.find(next_edge.dest);

            // if both endpoints have different parents, they belong to
            // different connected components and can be included in MST
            if (x != y) {
                MST.add(next_edge);
                ds.union(x, y);
            }
        }

        return MST;
    }

    // A class to store a graph edge
    public static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + src + ", " + dest + ", " + weight + ")";
        }
    }

    // A class to represent a disjoint set
    public static class DisjointSet {
        Map<Integer, Integer> parent = new HashMap<>();

        // perform MakeSet operation
        protected void makeSet(int n) {
            // create `n` disjoint sets (one for each vertex)
            for (int i = 0; i < n; i++) {
                parent.put(i, i);
            }
        }

        // Find the root of the set in which element `k` belongs
        protected int find(int k) {
            // if `k` is root
            if (parent.get(k) == k) {
                return k;
            }

            // recur for the parent until we find the root
            return find(parent.get(k));
        }

        // Perform Union of two subsets
        protected void union(int a, int b) {
            // find the root of the sets in which elements `x` and `y` belongs
            int x = find(a);
            int y = find(b);

            parent.put(x, y);
        }
    }

}