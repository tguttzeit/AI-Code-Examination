package ChatGPT.BellmanFord.T39;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> distanceMap = new HashMap<>();
        Map<Integer, Integer> previousNode = new HashMap<>();

        // Initialize distances to infinity, except for the source node.
        for (int i = 0; i < n; i++) {
            distanceMap.put(i, Integer.MAX_VALUE);
            previousNode.put(i, null);
        }
        distanceMap.put(source, 0);

        // Relax edges repeatedly for n-1 iterations.
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.getSource();
                int v = edge.getDest();
                int weight = edge.getWeight();
                if (distanceMap.get(u) != Integer.MAX_VALUE && distanceMap.get(u) + weight < distanceMap.get(v)) {
                    distanceMap.put(v, distanceMap.get(u) + weight);
                    previousNode.put(v, u);
                }
            }
        }

        // Check for negative cycles.
        for (Edge edge : edges) {
            int u = edge.getSource();
            int v = edge.getDest();
            int weight = edge.getWeight();
            if (distanceMap.get(u) != Integer.MAX_VALUE && distanceMap.get(u) + weight < distanceMap.get(v)) {
                // Negative cycle found, return null.
                return null;
            }
        }

        // Create a result map with only reachable nodes.
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (distanceMap.get(i) != Integer.MAX_VALUE) {
                result.put(i, distanceMap.get(i));
            }
        }

        return result;
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
