package ChatGPT.BellmanFord.T19;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> distance = new HashMap<>();
        distance.put(source, 0);

        // Relax edges n-1 times
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (distance.containsKey(edge.source)) {
                    int newDistance = distance.get(edge.source) + edge.weight;
                    if (!distance.containsKey(edge.dest) || newDistance < distance.get(edge.dest)) {
                        distance.put(edge.dest, newDistance);
                    }
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (distance.containsKey(edge.source)) {
                int newDistance = distance.get(edge.source) + edge.weight;
                if (distance.containsKey(edge.dest) && newDistance < distance.get(edge.dest)) {
                    // Negative cycle detected
                    return null;
                }
            }
        }

        // Remove nodes with no path from the result
        distance.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

        return distance;
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