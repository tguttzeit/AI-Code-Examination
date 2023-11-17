package ChatGPT.BellmanFord.T48;

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
        distance.put(source, 0);

        // Initialize distances to infinity except for the source node
        for (int i = 0; i < n; i++) {
            if (i != source) {
                distance.put(i, Integer.MAX_VALUE);
            }
        }

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

        // Remove nodes with no path
        distance.values().removeIf(val -> val == Integer.MAX_VALUE);

        return distance;
    }
}
