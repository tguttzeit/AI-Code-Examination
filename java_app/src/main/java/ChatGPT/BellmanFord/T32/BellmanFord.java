package ChatGPT.BellmanFord.T32;

import java.util.*;

public class BellmanFord {

    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> distanceMap = new HashMap<>();

        // Initialize distances with infinity
        for (int i = 0; i < n; i++) {
            distanceMap.put(i, Integer.MAX_VALUE);
        }

        // Set the distance of the source node to 0
        distanceMap.put(source, 0);

        // Relax edges for (n-1) times
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

        // Check for negative cycles
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int weight = edge.weight;
            if (distanceMap.get(u) != Integer.MAX_VALUE && distanceMap.get(u) + weight < distanceMap.get(v)) {
                return null; // Negative cycle detected
            }
        }

        // Remove nodes with unreachable paths
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
