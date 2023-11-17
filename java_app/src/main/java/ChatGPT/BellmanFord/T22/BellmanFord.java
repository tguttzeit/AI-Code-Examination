package ChatGPT.BellmanFord.T22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        // Initialize distances to all nodes as infinity
        Map<Integer, Integer> distance = new HashMap<>();
        for (int i = 0; i < n; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
        distance.put(source, 0);

        // Relax edges repeatedly for 'n-1' times
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
                // Negative cycle detected
                return null;
            }
        }

        // Remove nodes with infinite distance (no path to them)
        distance.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

        return distance;
    }

}
