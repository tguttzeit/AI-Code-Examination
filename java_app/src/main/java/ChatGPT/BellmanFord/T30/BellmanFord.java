package ChatGPT.BellmanFord.T30;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {

    public class Edge {
        public int source;
        public int dest;
        public int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distances
        Map<Integer, Integer> distances = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        // Relax edges repeatedly
        for (int i = 1; i < n; i++) {
            for (Edge edge : edges) {
                if (distances.get(edge.source) != Integer.MAX_VALUE &&
                        distances.get(edge.source) + edge.weight < distances.get(edge.dest)) {
                    distances.put(edge.dest, distances.get(edge.source) + edge.weight);
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (distances.get(edge.source) != Integer.MAX_VALUE &&
                    distances.get(edge.source) + edge.weight < distances.get(edge.dest)) {
                // Negative cycle detected
                return null;
            }
        }

        // Remove unreachable nodes
        distances.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

        return distances;
    }

}
