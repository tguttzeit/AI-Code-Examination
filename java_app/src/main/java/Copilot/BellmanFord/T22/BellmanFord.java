package Copilot.BellmanFord.T22;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(source, 0);
        for (int i = 0; i < n; i++) {
            for (Edge edge : edges) {
                if (dist[edge.source] == Integer.MAX_VALUE) {
                    continue;
                }
                if (dist[edge.dest] > dist[edge.source] + edge.weight) {
                    dist[edge.dest] = dist[edge.source] + edge.weight;
                    map.put(edge.dest, dist[edge.dest]);
                }
            }
        }
        for (Edge edge : edges) {
            if (dist[edge.source] == Integer.MAX_VALUE) {
                continue;
            }
            if (dist[edge.dest] > dist[edge.source] + edge.weight) {
                return null;
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