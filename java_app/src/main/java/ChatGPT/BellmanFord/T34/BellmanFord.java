package ChatGPT.BellmanFord.T34;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();

        // Initialize distances with infinity and set the source distance to 0
        for (int i = 0; i < n; i++) {
            distances.put(i, Integer.MAX_VALUE);
            parent.put(i, null);
        }
        distances.put(source, 0);

        // Relax edges repeatedly
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.getSource();
                int v = edge.getDest();
                int w = edge.getWeight();
                if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + w < distances.get(v)) {
                    distances.put(v, distances.get(u) + w);
                    parent.put(v, u);
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            int u = edge.getSource();
            int v = edge.getDest();
            int w = edge.getWeight();
            if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + w < distances.get(v)) {
                return null; // Negative cycle detected
            }
        }

        // Create a result map with only reachable nodes
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (distances.get(i) != Integer.MAX_VALUE) {
                shortestPaths.put(i, distances.get(i));
            }
        }

        return shortestPaths;
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
