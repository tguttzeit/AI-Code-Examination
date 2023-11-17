package ChatGPT.BellmanFord.T5;

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

    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distance array with a maximum value for all nodes except the source
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax edges |V| - 1 times to find shortest paths
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.dest]) {
                    distance[edge.dest] = distance[edge.source] + edge.weight;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.dest]) {
                // Negative cycle found, return null
                return null;
            }
        }

        // Create a result map for the shortest paths
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                shortestPaths.put(i, distance[i]);
            }
        }

        return shortestPaths;
    }
}
