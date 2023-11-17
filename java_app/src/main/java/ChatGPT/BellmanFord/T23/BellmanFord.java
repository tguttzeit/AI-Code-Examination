package ChatGPT.BellmanFord.T23;

import java.util.*;

public class BellmanFord {

    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> shortestDistances = new HashMap<>();
        shortestDistances.put(source, 0);

        for (int i = 1; i < n; i++) {
            for (Edge edge : edges) {
                if (shortestDistances.containsKey(edge.source)) {
                    int newDistance = shortestDistances.get(edge.source) + edge.weight;
                    if (!shortestDistances.containsKey(edge.dest) || newDistance < shortestDistances.get(edge.dest)) {
                        shortestDistances.put(edge.dest, newDistance);
                    }
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (shortestDistances.containsKey(edge.source)) {
                int newDistance = shortestDistances.get(edge.source) + edge.weight;
                if (shortestDistances.containsKey(edge.dest) && newDistance < shortestDistances.get(edge.dest)) {
                    return null; // Negative cycle detected
                }
            }
        }

        // Remove nodes with no path from the result
        shortestDistances.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

        return shortestDistances;
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
