package Copilot.BellmanFord.T39;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        int[] dist = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[source] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.source] != Integer.MAX_VALUE && dist[e.source] + e.weight < dist[e.dest]) {
                    dist[e.dest] = dist[e.source] + e.weight;
                    prev[e.dest] = e.source;
                }
            }
        }
        for (Edge e : edges) {
            if (dist[e.source] != Integer.MAX_VALUE && dist[e.source] + e.weight < dist[e.dest]) {
                return null;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i == source) {
                continue;
            }
            if (dist[i] != Integer.MAX_VALUE) {
                map.put(i, dist[i]);
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