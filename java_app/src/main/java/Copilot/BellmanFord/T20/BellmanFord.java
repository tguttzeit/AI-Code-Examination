package Copilot.BellmanFord.T20;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFord {

    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> output = new HashMap<>();
        for (int i = 0; i < n; i++) {
            output.put(i, Integer.MAX_VALUE);
        }
        output.put(source, 0);
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (output.get(edge.source) != Integer.MAX_VALUE && output.get(edge.source) + edge.weight < output.get(edge.dest)) {
                    output.put(edge.dest, output.get(edge.source) + edge.weight);
                }
            }
        }
        for (Edge edge : edges) {
            if (output.get(edge.source) != Integer.MAX_VALUE && output.get(edge.source) + edge.weight < output.get(edge.dest)) {
                return null;
            }
        }
        return output;
    }
    public static class Edge {
        public int source;
        public int dest;
        public int weight;
    }

};