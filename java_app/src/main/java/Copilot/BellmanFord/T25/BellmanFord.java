package Copilot.BellmanFord.T25;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {

    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> result = new HashMap<>();
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.source] == Integer.MAX_VALUE) {
                    continue;
                }
                if (distance[edge.source] + edge.weight < distance[edge.dest]) {
                    distance[edge.dest] = distance[edge.source] + edge.weight;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                result.put(i, distance[i]);
            }
        }
        for (Edge edge : edges) {
            if (distance[edge.source] == Integer.MAX_VALUE) {
                continue;
            }
            if (distance[edge.source] + edge.weight < distance[edge.dest]) {
                return null;
            }
        }
        return result;
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