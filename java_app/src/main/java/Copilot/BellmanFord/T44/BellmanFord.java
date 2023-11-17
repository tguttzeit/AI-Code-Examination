package Copilot.BellmanFord.T44;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {

    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> dist = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }
        dist.put(source, 0);
        for (int i = 0; i < n - 1; i++) {
            for (Edge e : edges) {
                if (dist.get(e.source) != Integer.MAX_VALUE && dist.get(e.source) + e.weight < dist.get(e.dest)) {
                    dist.put(e.dest, dist.get(e.source) + e.weight);
                }
            }
        }
        for (Edge e : edges) {
            if (dist.get(e.source) != Integer.MAX_VALUE && dist.get(e.source) + e.weight < dist.get(e.dest)) {
                return null;
            }
        }
        return dist;
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