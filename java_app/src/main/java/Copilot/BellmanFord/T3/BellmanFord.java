package Copilot.BellmanFord.T3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(source, 0);

        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (map.containsKey(edge.source)) {
                    int newDistance = map.get(edge.source) + edge.weight;
                    if (map.containsKey(edge.dest)) {
                        if (map.get(edge.dest) > newDistance) {
                            map.put(edge.dest, newDistance);
                        }
                    } else {
                        map.put(edge.dest, newDistance);
                    }
                }
            }
        }

        for (Edge edge : edges) {
            if (map.containsKey(edge.source)) {
                int newDistance = map.get(edge.source) + edge.weight;
                if (map.containsKey(edge.dest)) {
                    if (map.get(edge.dest) > newDistance) {
                        return null;
                    }
                }
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