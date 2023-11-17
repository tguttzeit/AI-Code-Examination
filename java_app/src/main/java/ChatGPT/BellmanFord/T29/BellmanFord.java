package ChatGPT.BellmanFord.T29;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distances map with infinity for all nodes except the source
        Map<Integer, Integer> distances = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i == source) {
                distances.put(i, 0);
            } else {
                distances.put(i, Integer.MAX_VALUE);
            }
        }

        // Relax edges repeatedly (n-1 times)
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.dest;
                int weight = edge.weight;
                if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                    distances.put(v, distances.get(u) + weight);
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int weight = edge.weight;
            if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                // Negative cycle detected
                return null;
            }
        }

        // Remove nodes with no path from the result map
        Iterator<Map.Entry<Integer, Integer>> iterator = distances.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == Integer.MAX_VALUE) {
                iterator.remove();
            }
        }

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
