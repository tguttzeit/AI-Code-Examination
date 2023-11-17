package ChatGPT.BellmanFord.T3;

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
        Map<Integer, Integer> distance = new HashMap<>();

        // Initialize distance map with maximum values and set the source node distance to 0
        for (int i = 0; i < n; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
        distance.put(source, 0);

        // Relax edges repeatedly
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (distance.get(edge.source) != Integer.MAX_VALUE &&
                        distance.get(edge.source) + edge.weight < distance.get(edge.dest)) {
                    distance.put(edge.dest, distance.get(edge.source) + edge.weight);
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (distance.get(edge.source) != Integer.MAX_VALUE &&
                    distance.get(edge.source) + edge.weight < distance.get(edge.dest)) {
                return null; // Negative cycle detected
            }
        }

        // Remove nodes with unreachable paths
        distance.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE && entry.getKey() != source);

        return distance;
    }

}
