package Copilot.BellmanFord.T35;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        // initialize all the nodes to be Integer.MAX_VALUE except the source node
        for (int i = 0; i < n; i++) {
            if (i == source) {
                map.put(i, 0);
            } else {
                map.put(i, Integer.MAX_VALUE);
            }
        }
        // relax all the edges n - 1 times
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                if (map.get(edge.source) != Integer.MAX_VALUE && map.get(edge.source) + edge.weight < map.get(edge.dest)) {
                    map.put(edge.dest, map.get(edge.source) + edge.weight);
                }
            }
        }
        // check if there is a negative cycle
        for (Edge edge : edges) {
            if (map.get(edge.source) != Integer.MAX_VALUE && map.get(edge.source) + edge.weight < map.get(edge.dest)) {
                return null;
            }
        }
        // remove the nodes that don't have a path from the source node
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == Integer.MAX_VALUE) {
                iterator.remove();
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