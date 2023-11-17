package ChatGPT.BellmanFord.T43;

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
        // Initialize distance array with maximum values
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Set distance from source to itself as 0
        distance[source] = 0;

        // Relax edges for (n-1) iterations
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE &&
                        distance[edge.source] + edge.weight < distance[edge.dest]) {
                    distance[edge.dest] = distance[edge.source] + edge.weight;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (distance[edge.source] != Integer.MAX_VALUE &&
                    distance[edge.source] + edge.weight < distance[edge.dest]) {
                // Negative cycle detected
                return null;
            }
        }

        // Create a map to store the shortest distances
        Map<Integer, Integer> shortestDistances = new HashMap<>();

        // Populate the map with valid shortest distances
        for (int i = 0; i < n; i++) {
            if (distance[i] != Integer.MAX_VALUE && i != source) {
                shortestDistances.put(i, distance[i]);
            }
        }

        return shortestDistances;
    }

}