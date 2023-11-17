package Copilot.BellmanFord.T50;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, Integer.MAX_VALUE);
        }
        map.put(source, 0);

        for (int i = 0; i < n; i++) {
            for (Edge e : edges) {
                int u = e.source;
                int v = e.dest;
                int w = e.weight;
                if (map.get(u) != Integer.MAX_VALUE && map.get(u) + w < map.get(v)) {
                    map.put(v, map.get(u) + w);
                }
            }
        }

        for (Edge e : edges) {
            int u = e.source;
            int v = e.dest;
            int w = e.weight;
            if (map.get(u) != Integer.MAX_VALUE && map.get(u) + w < map.get(v)) {
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