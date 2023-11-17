package ChatGPT.BellmanFord.T40;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distance array to store the shortest distance from the source to each node
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Relax edges repeatedly for n-1 times
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
                // There is a negative cycle in the graph
                return null;
            }
        }

        // Create a map to store the shortest distances to each node
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                shortestPaths.put(i, distance[i]);
            }
        }

        return shortestPaths;
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