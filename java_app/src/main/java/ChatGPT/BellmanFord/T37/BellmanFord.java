package ChatGPT.BellmanFord.T37;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> distance = new HashMap<>();

        // Initialize distance to all nodes as infinity, except the source node as 0.
        for (int i = 0; i < n; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
        distance.put(source, 0);

        // Relax edges repeatedly for (n-1) iterations.
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.dest;
                int w = edge.weight;
                if (distance.get(u) != Integer.MAX_VALUE && distance.get(u) + w < distance.get(v)) {
                    distance.put(v, distance.get(u) + w);
                }
            }
        }

        // Check for negative cycles.
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int w = edge.weight;
            if (distance.get(u) != Integer.MAX_VALUE && distance.get(u) + w < distance.get(v)) {
                return null; // Negative cycle detected.
            }
        }

        // Remove unreachable nodes from the result.
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
