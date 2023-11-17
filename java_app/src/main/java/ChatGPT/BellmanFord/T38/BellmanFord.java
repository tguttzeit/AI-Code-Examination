package ChatGPT.BellmanFord.T38;

import java.util.*;

public class BellmanFord {
    public static class Edge {
        public int source, dest, weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> shortestDistances = new HashMap<>();

        // Initialize distances
        for (int i = 0; i < n; i++) {
            shortestDistances.put(i, Integer.MAX_VALUE);
        }
        shortestDistances.put(source, 0);

        // Relax edges repeatedly
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (shortestDistances.get(edge.source) != Integer.MAX_VALUE &&
                        shortestDistances.get(edge.source) + edge.weight < shortestDistances.get(edge.dest)) {
                    shortestDistances.put(edge.dest, shortestDistances.get(edge.source) + edge.weight);
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (shortestDistances.get(edge.source) != Integer.MAX_VALUE &&
                    shortestDistances.get(edge.source) + edge.weight < shortestDistances.get(edge.dest)) {
                return null; // Negative cycle detected
            }
        }

        // Remove nodes with no path
        shortestDistances.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

        return shortestDistances;
    }

}
