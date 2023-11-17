package ChatGPT.BellmanFord.T8;

import java.util.*;

public class BellmanFord {
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

    public Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distance array with a large value as infinity
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Relax edges repeatedly
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (distances[edge.source] != Integer.MAX_VALUE && distances[edge.source] + edge.weight < distances[edge.dest]) {
                    distances[edge.dest] = distances[edge.source] + edge.weight;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (distances[edge.source] != Integer.MAX_VALUE && distances[edge.source] + edge.weight < distances[edge.dest]) {
                // Negative cycle detected
                return null;
            }
        }

        // Create the result map
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (distances[i] != Integer.MAX_VALUE) {
                shortestPaths.put(i, distances[i]);
            }
        }

        return shortestPaths;
    }
}