package ChatGPT.BellmanFord.T13;

import java.util.*;

public class BellmanFord {

    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, Integer> prevNode = new HashMap<>();

        // Initialize distances with infinity and the source node with 0.
        for (int i = 1; i <= n; i++) {
            distances.put(i, Integer.MAX_VALUE);
            prevNode.put(i, null);
        }
        distances.put(source, 0);

        // Relax edges repeatedly (n-1 times).
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.dest;
                int weight = edge.weight;

                if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                    distances.put(v, distances.get(u) + weight);
                    prevNode.put(v, u);
                }
            }
        }

        // Check for negative cycles.
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int weight = edge.weight;
            if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                return null; // Negative cycle detected
            }
        }

        // Remove unreachable nodes from the result.
        distances.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

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
