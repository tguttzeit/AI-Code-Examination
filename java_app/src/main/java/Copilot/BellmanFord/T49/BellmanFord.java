package Copilot.BellmanFord.T49;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> result = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();
        Map<Integer, Integer> cur = new HashMap<>();
        for (int i = 0; i < n; i++) {
            prev.put(i, Integer.MAX_VALUE);
            cur.put(i, Integer.MAX_VALUE);
        }
        prev.put(source, 0);
        cur.put(source, 0);
        for (int i = 1; i < n; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.dest;
                int weight = edge.weight;
                if (prev.get(u) != Integer.MAX_VALUE && prev.get(u) + weight < cur.get(v)) {
                    cur.put(v, prev.get(u) + weight);
                }
            }
            prev.putAll(cur);
        }
        result.putAll(cur);
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int weight = edge.weight;
            if (result.get(u) != Integer.MAX_VALUE && result.get(u) + weight < result.get(v)) {
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