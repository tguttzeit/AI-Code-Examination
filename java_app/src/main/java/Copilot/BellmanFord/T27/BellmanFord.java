package Copilot.BellmanFord.T27;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    static class Edge {
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
        Map<Integer, Integer> map = new HashMap<>();
        map.put(source, 0);
        for (int i = 1; i < n; i++) {
            map.put(i, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (map.get(edge.source) != Integer.MAX_VALUE && map.get(edge.dest) > map.get(edge.source) + edge.weight) {
                    map.put(edge.dest, map.get(edge.source) + edge.weight);
                }
            }
        }
        for (Edge edge : edges) {
            if (map.get(edge.source) != Integer.MAX_VALUE && map.get(edge.dest) > map.get(edge.source) + edge.weight) {
                return null;
            }
        }
        return map;
    }
};