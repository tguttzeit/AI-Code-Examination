package ChatGPT.Kruskal.T9;

import java.util.*;

public class Kruskal {

    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        // Sort the edges in ascending order of their weights
        edges.sort(Comparator.comparingInt(Edge::getWeight));

        List<Edge> minimumSpanningTree = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet(n);

        for (Edge edge : edges) {
            if (!disjointSet.isSameSet(edge.getSrc(), edge.getDest())) {
                minimumSpanningTree.add(edge);
                disjointSet.union(edge.getSrc(), edge.getDest());
            }
        }

        return minimumSpanningTree;
    }

    public static class Edge {
        public int src, dest, weight;

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

        public boolean isSameSet(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }

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
