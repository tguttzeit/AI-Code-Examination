package Copilot.BellmanFord.T46;

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
            for (Edge e : edges) {
                if (map.get(e.source) != Integer.MAX_VALUE && map.get(e.dest) > map.get(e.source) + e.weight) {
                    map.put(e.dest, map.get(e.source) + e.weight);
                }
            }
        }
        for (Edge e : edges) {
            if (map.get(e.source) != Integer.MAX_VALUE && map.get(e.dest) > map.get(e.source) + e.weight) {
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