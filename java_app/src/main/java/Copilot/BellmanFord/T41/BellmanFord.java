package Copilot.BellmanFord.T41;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        for (int i = 0; i < n; i++) {
            for (Edge edge : edges) {
                if (dist[edge.source] != Integer.MAX_VALUE && dist[edge.dest] > dist[edge.source] + edge.weight) {
                    dist[edge.dest] = dist[edge.source] + edge.weight;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            map.put(i, dist[i]);
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