package ChatGPT.BellmanFord.T16;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distances with infinity, except for the source node which has distance 0.
        Map<Integer, Integer> distances = new HashMap<>();
        for (int i = 0; i < n; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        // Relax edges repeatedly for 'n-1' times.
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (distances.get(edge.source) != Integer.MAX_VALUE &&
                        distances.get(edge.source) + edge.weight < distances.get(edge.dest)) {
                    distances.put(edge.dest, distances.get(edge.source) + edge.weight);
                }
            }
        }

        // Check for negative cycles.
        for (Edge edge : edges) {
            if (distances.get(edge.source) != Integer.MAX_VALUE &&
                    distances.get(edge.source) + edge.weight < distances.get(edge.dest)) {
                // Negative cycle detected, return null.
                return null;
            }
        }

        // Remove nodes with unreachable paths from the result map.
        Iterator<Map.Entry<Integer, Integer>> iterator = distances.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == Integer.MAX_VALUE) {
                iterator.remove();
            }
        }

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