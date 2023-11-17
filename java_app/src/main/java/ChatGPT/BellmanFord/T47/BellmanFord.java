package ChatGPT.BellmanFord.T47;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distance map with infinity except for the source node.
        Map<Integer, Integer> distances = new HashMap<>();
        for (int i = 0; i < n; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        // Relax edges repeatedly to find the shortest paths.
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.dest;
                int weight = edge.weight;

                if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                    distances.put(v, distances.get(u) + weight);
                }
            }
        }

        // Check for negative cycles.
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int weight = edge.weight;

            if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                // Negative cycle detected.
                return null;
            }
        }

        // Remove nodes with no path and return the shortest distances.
        Map<Integer, Integer> shortestDistances = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (distances.get(i) != Integer.MAX_VALUE) {
                shortestDistances.put(i, distances.get(i));
            }
        }

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
