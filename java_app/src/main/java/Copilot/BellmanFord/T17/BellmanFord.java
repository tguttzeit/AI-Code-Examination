package Copilot.BellmanFord.T17;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.dest;
                int w = edge.weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int w = edge.weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                return null;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != source && distance[i] != Integer.MAX_VALUE) {
                map.put(i, distance[i]);
            }
        }

        return map;
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
};