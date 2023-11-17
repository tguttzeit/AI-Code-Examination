package ChatGPT.BellmanFord.T46;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int[] distances = new int[n];
        int[] predecessors = new int[n];

        // Initialize distances to infinity and predecessors to -1
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
            predecessors[i] = -1;
        }

        distances[source] = 0;

        // Relax edges |V| - 1 times
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (distances[edge.source] != Integer.MAX_VALUE && distances[edge.source] + edge.weight < distances[edge.dest]) {
                    distances[edge.dest] = distances[edge.source] + edge.weight;
                    predecessors[edge.dest] = edge.source;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (distances[edge.source] != Integer.MAX_VALUE && distances[edge.source] + edge.weight < distances[edge.dest]) {
                // Negative cycle found
                return null;
            }
        }

        // Create the result map, skipping nodes with no path
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (distances[i] != Integer.MAX_VALUE) {
                shortestPaths.put(i, distances[i]);
            }
        }

        return shortestPaths;
    }

}
