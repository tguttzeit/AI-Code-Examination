package ChatGPT.BellmanFord.T6;

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
        // Initialize distances to all nodes as infinity, except for the source node
        Map<Integer, Integer> distances = new HashMap<>();
        for (int i = 0; i < n; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        // Relax edges for n-1 times
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (distances.get(edge.source) != Integer.MAX_VALUE &&
                        distances.get(edge.source) + edge.weight < distances.get(edge.dest)) {
                    distances.put(edge.dest, distances.get(edge.source) + edge.weight);
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (distances.get(edge.source) != Integer.MAX_VALUE &&
                    distances.get(edge.source) + edge.weight < distances.get(edge.dest)) {
                // Negative cycle detected, return null
                return null;
            }
        }

        // Remove unreachable nodes from the result
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (distances.get(i) != Integer.MAX_VALUE) {
                shortestPaths.put(i, distances.get(i));
            }
        }

        return shortestPaths;
    }
}