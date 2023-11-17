package ChatGPT.BellmanFord.T10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distances, initially set to infinity for all nodes except the source.
        Map<Integer, Integer> distances = new HashMap<>();
        for (int i = 0; i < n; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        // Relax edges repeatedly
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.getSource();
                int v = edge.getDest();
                int weight = edge.getWeight();
                if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                    distances.put(v, distances.get(u) + weight);
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            int u = edge.getSource();
            int v = edge.getDest();
            int weight = edge.getWeight();
            if (distances.get(u) != Integer.MAX_VALUE && distances.get(u) + weight < distances.get(v)) {
                // Negative cycle detected
                return null;
            }
        }

        // Remove nodes with no path from the result
        List<Integer> nodesToRemove = new ArrayList<>();
        for (int node : distances.keySet()) {
            if (distances.get(node) == Integer.MAX_VALUE) {
                nodesToRemove.add(node);
            }
        }
        for (int node : nodesToRemove) {
            distances.remove(node);
        }

        return distances;
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
