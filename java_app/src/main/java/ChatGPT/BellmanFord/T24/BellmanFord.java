package ChatGPT.BellmanFord.T24;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distances and predecessors
        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, Integer> predecessors = new HashMap<>();
        for (int i = 0; i < n; i++) {
            distances.put(i, Integer.MAX_VALUE);
            predecessors.put(i, null);
        }
        distances.put(source, 0);

        // Relax edges repeatedly
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (distances.get(edge.source) != Integer.MAX_VALUE && distances.get(edge.source) + edge.weight < distances.get(edge.dest)) {
                    distances.put(edge.dest, distances.get(edge.source) + edge.weight);
                    predecessors.put(edge.dest, edge.source);
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (distances.get(edge.source) != Integer.MAX_VALUE && distances.get(edge.source) + edge.weight < distances.get(edge.dest)) {
                // Negative cycle found
                return null;
            }
        }

        // Remove nodes with no path
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (distances.get(i) != Integer.MAX_VALUE) {
                shortestPaths.put(i, distances.get(i));
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
