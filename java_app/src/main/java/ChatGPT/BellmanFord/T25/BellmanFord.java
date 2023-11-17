package ChatGPT.BellmanFord.T25;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
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

    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize the distance array to store the shortest distance to each node.
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        // Relax edges repeatedly (n-1 times) to find the shortest paths.
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] != Integer.MAX_VALUE &&
                        distance[edge.source] + edge.weight < distance[edge.dest]) {
                    distance[edge.dest] = distance[edge.source] + edge.weight;
                }
            }
        }

        // Check for negative cycles.
        for (Edge edge : edges) {
            if (distance[edge.source] != Integer.MAX_VALUE &&
                    distance[edge.source] + edge.weight < distance[edge.dest]) {
                // Negative cycle detected.
                return null;
            }
        }

        // Create a map to store the shortest path distances.
        Map<Integer, Integer> shortestDistances = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i != source && distance[i] != Integer.MAX_VALUE) {
                shortestDistances.put(i, distance[i]);
            }
        }

        return shortestDistances;
    }

}
