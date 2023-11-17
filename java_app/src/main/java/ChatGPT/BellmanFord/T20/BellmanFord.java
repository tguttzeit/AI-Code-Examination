package ChatGPT.BellmanFord.T20;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distances with infinity for all nodes except the source node.
        Map<Integer, Integer> distances = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            distances.put(i, i == source ? 0 : Integer.MAX_VALUE);
        }

        // Relax edges repeatedly to find the shortest path.
        for (int i = 1; i <= n - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.dest;
                int weight = edge.weight;

                if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                    distances.put(v, distances.get(u) + weight);
                }
            }
        }

        // Check for negative cycles.
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int weight = edge.weight;
            if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                // Negative cycle detected, return null.
                return null;
            }
        }

        // Remove nodes with infinite distance (no path to them).
        distances.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

        return distances;
    }

    public static class Edge {
        public int source;
        public int dest;
        public int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

}
