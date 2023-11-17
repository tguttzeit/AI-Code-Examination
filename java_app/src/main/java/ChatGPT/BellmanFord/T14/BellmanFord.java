package ChatGPT.BellmanFord.T14;

import java.util.*;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> shortestDistances = new HashMap<>();
        shortestDistances.put(source, 0);

        // Relax edges for (n-1) times
        for (int i = 1; i < n; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.dest;
                int weight = edge.weight;
                if (shortestDistances.containsKey(u)) {
                    if (!shortestDistances.containsKey(v) || shortestDistances.get(u) + weight < shortestDistances.get(v)) {
                        shortestDistances.put(v, shortestDistances.get(u) + weight);
                    }
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int weight = edge.weight;
            if (shortestDistances.containsKey(u) && shortestDistances.get(u) + weight < shortestDistances.get(v)) {
                return null; // Negative cycle detected
            }
        }

        // Remove nodes with no path
        List<Integer> nodesToRemove = new ArrayList<>();
        for (int node : shortestDistances.keySet()) {
            if (shortestDistances.get(node) == Integer.MAX_VALUE) {
                nodesToRemove.add(node);
            }
        }
        for (int node : nodesToRemove) {
            shortestDistances.remove(node);
        }

        return shortestDistances;
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
