package ChatGPT.BellmanFord.T9;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distance map with infinity values and set source node distance to 0
        Map<Integer, Integer> distanceMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            distanceMap.put(i, Integer.MAX_VALUE);
        }
        distanceMap.put(source, 0);

        // Relax edges for (n-1) times
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.getSource();
                int v = edge.getDest();
                int weight = edge.getWeight();
                if (distanceMap.get(u) != Integer.MAX_VALUE && distanceMap.get(u) + weight < distanceMap.get(v)) {
                    distanceMap.put(v, distanceMap.get(u) + weight);
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            int u = edge.getSource();
            int v = edge.getDest();
            int weight = edge.getWeight();
            if (distanceMap.get(u) != Integer.MAX_VALUE && distanceMap.get(u) + weight < distanceMap.get(v)) {
                return null; // Negative cycle detected
            }
        }

        // Remove unreachable nodes from the result
        distanceMap.values().removeIf(d -> d == Integer.MAX_VALUE);
        return distanceMap;
    }

    public static class Edge {
        private int source;
        private int dest;
        private int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }

        public int getSource() {
            return source;
        }

        public int getDest() {
            return dest;
        }

        public int getWeight() {
            return weight;
        }
    }

}
