package Copilot.BellmanFord.T34;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] dist = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[source] = 0;
        for (int i = 0; i < n; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.dest;
                int w = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    prev[v] = u;
                }
            }
        }
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int w = edge.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                return null;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != source && dist[i] != Integer.MAX_VALUE) {
                map.put(i, dist[i]);
            }
        }
        return map;
    }
    public static class Edge {
        public int source;
        public int dest;
        public int weight;
    }
};