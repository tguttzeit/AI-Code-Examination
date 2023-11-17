package ChatGPT.BellmanFord.T11;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        // Initialize distances
        for (int i = 0; i < n; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
        distance.put(source, 0);

        // Relax edges repeatedly
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.dest;
                int w = edge.weight;
                if (distance.get(u) != Integer.MAX_VALUE && distance.get(u) + w < distance.get(v)) {
                    distance.put(v, distance.get(u) + w);
                    parent.put(v, u);
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int w = edge.weight;
            if (distance.get(u) != Integer.MAX_VALUE && distance.get(u) + w < distance.get(v)) {
                // Negative cycle detected
                return null;
            }
        }

        // Create a result map containing the shortest paths
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        for (int node : distance.keySet()) {
            if (distance.get(node) != Integer.MAX_VALUE) {
                shortestPaths.put(node, distance.get(node));
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
