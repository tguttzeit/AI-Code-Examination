package Copilot.BellmanFord.T26;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(source, 0);
        for (int i = 1; i < n; i++) {
            map.put(i, Integer.MAX_VALUE);
        }
        for (int i = 1; i < n; i++) {
            for (Edge edge : edges) {
                if (map.get(edge.source) == Integer.MAX_VALUE) {
                    continue;
                }
                if (map.get(edge.dest) > map.get(edge.source) + edge.weight) {
                    map.put(edge.dest, map.get(edge.source) + edge.weight);
                }
            }
        }
        for (Edge edge : edges) {
            if (map.get(edge.dest) > map.get(edge.source) + edge.weight) {
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