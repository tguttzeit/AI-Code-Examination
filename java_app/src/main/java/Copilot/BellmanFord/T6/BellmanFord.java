package Copilot.BellmanFord.T6;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(source, 0);
        for (int i = 1; i < n; i++) {
            for (Edge edge : edges) {
                if (map.containsKey(edge.source)) {
                    if (!map.containsKey(edge.dest)) {
                        map.put(edge.dest, map.get(edge.source) + edge.weight);
                    } else {
                        map.put(edge.dest, Math.min(map.get(edge.dest), map.get(edge.source) + edge.weight));
                    }
                }
            }
        }
        for (Edge edge : edges) {
            if (map.containsKey(edge.source) && map.get(edge.source) + edge.weight < map.get(edge.dest)) {
                return null;
            }
        }
        return map;
    }
}

class Edge {
    public int source;
    public int dest;
    public int weight;
    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
};