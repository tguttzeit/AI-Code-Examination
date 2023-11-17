package ChatGPT.BellmanFord.T7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distances with infinity and source distance as 0
        Map<Integer, Integer> distances = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        // Relax edges repeatedly for n-1 times
        for (int i = 1; i <= n - 1; i++) {
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

        // Remove nodes with no paths to other nodes
        List<Integer> nodesToRemove = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (distances.get(i) == Integer.MAX_VALUE) {
                nodesToRemove.add(i);
            }
        }
        for (int node : nodesToRemove) {
            distances.remove(node);
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