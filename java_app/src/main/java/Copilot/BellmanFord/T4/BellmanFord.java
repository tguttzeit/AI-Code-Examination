package Copilot.BellmanFord.T4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // TODO Auto-generated method stub
        Map<Integer, Integer> map = new HashMap<>();
        if (source < 0) {
            return null;
        }
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
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
        for (int i = 0; i < n; i++) {
            map.put(i, distance[i]);
        }
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int w = edge.weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                return null;
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