package ChatGPT.Kruskal.T27;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    public static List<Edge> runKruskalAlgorithm(List<Edge> edges, int n) {
        List<Edge> result = new ArrayList<>();

        // Sort the edges in ascending order based on their weights
        Collections.sort(edges);

        DisjointSet disjointSet = new DisjointSet(n);

        for (Edge edge : edges) {
            if (disjointSet.union(edge.src, edge.dest)) {
                // If adding this edge doesn't create a cycle, add it to the result
                result.add(edge);
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
            if (parent[x] == x) {
                return x;
            }
            // Path compression: Make the parent of x the root of its set
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                // x and y are already in the same set (they have the same root)
                return false;
            }
            // Union by rank: Attach the smaller rank tree under the root of the larger rank tree
            if (rootX < rootY) {
                parent[rootX] = rootY;
            } else if (rootX > rootY) {
                parent[rootY] = rootX;
            } else {
                // If ranks are equal, attach one to the other and increase the rank
                parent[rootX] = rootY;
            }
            return true;
        }
    }
}
