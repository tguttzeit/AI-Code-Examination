package ChatGPT.BellmanFord.T50;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> distanceMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            distanceMap.put(i, Integer.MAX_VALUE);
        }
        distanceMap.put(source, 0);

        for (int i = 1; i < n; i++) {
            for (Edge edge : edges) {
                if (distanceMap.get(edge.source) != Integer.MAX_VALUE &&
                        distanceMap.get(edge.source) + edge.weight < distanceMap.get(edge.dest)) {
                    distanceMap.put(edge.dest, distanceMap.get(edge.source) + edge.weight);
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            if (distanceMap.get(edge.source) != Integer.MAX_VALUE &&
                    distanceMap.get(edge.source) + edge.weight < distanceMap.get(edge.dest)) {
                return null; // Negative cycle detected
            }
        }

        // Remove unreachable nodes
        distanceMap.values().removeIf(val -> val == Integer.MAX_VALUE);

        return distanceMap;
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
