package ChatGPT.BellmanFord.T31;

import java.util.*;

public class BellmanFord {

    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distances to all nodes as infinity, except the source node.
        Map<Integer, Integer> distanceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i == source) {
                distanceMap.put(i, 0);
            } else {
                distanceMap.put(i, Integer.MAX_VALUE);
            }
        }

        // Relax edges repeatedly to find the shortest paths.
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.dest;
                int weight = edge.weight;
                if (distanceMap.get(u) != Integer.MAX_VALUE && distanceMap.get(u) + weight < distanceMap.get(v)) {
                    distanceMap.put(v, distanceMap.get(u) + weight);
                }
            }
        }

        // Check for negative cycles.
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int weight = edge.weight;
            if (distanceMap.get(u) != Integer.MAX_VALUE && distanceMap.get(u) + weight < distanceMap.get(v)) {
                return null; // Negative cycle detected.
            }
        }

        // Remove nodes with unreachable paths (distance remains at Integer.MAX_VALUE).
        distanceMap.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

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
