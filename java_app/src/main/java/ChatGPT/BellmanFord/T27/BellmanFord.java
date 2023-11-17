package ChatGPT.BellmanFord.T27;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> distances = new HashMap<>();
        distances.put(source, 0);

        for (int i = 1; i < n; i++) {
            for (Edge edge : edges) {
                if (distances.containsKey(edge.source)) {
                    int newDistance = distances.get(edge.source) + edge.weight;
                    if (!distances.containsKey(edge.dest) || newDistance < distances.get(edge.dest)) {
                        distances.put(edge.dest, newDistance);
                    }
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (distances.containsKey(edge.source)) {
                int newDistance = distances.get(edge.source) + edge.weight;
                if (distances.containsKey(edge.dest) && newDistance < distances.get(edge.dest)) {
                    return null; // Negative cycle detected
                }
            }
        }

        // Remove nodes without a path from the output
        Iterator<Map.Entry<Integer, Integer>> iterator = distances.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getKey() == source || entry.getValue() == Integer.MAX_VALUE) {
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
