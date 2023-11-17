package ChatGPT.BellmanFord.T2;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distances to all nodes as infinity, except for the source node
        Map<Integer, Integer> distance = new HashMap<>();
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
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int w = edge.weight;
            if (distance.get(u) != Integer.MAX_VALUE && distance.get(u) + w < distance.get(v)) {
                return null; // Negative cycle found
            }
        }

        // Remove nodes with unreachable paths from the result
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
