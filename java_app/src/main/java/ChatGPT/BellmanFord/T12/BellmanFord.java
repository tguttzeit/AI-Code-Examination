package ChatGPT.BellmanFord.T12;

import java.util.*;

public class BellmanFord {

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

    public static Map<Integer, Integer> bellmanFord(List<Edge> edges, int source, int n) {
        // Initialize distance map with infinity values
        Map<Integer, Integer> distanceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            distanceMap.put(i, Integer.MAX_VALUE);
        }
        distanceMap.put(source, 0);

        // Relax edges repeatedly for n-1 times
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.dest;
                int w = edge.weight;
                if (distanceMap.get(u) != Integer.MAX_VALUE && distanceMap.get(u) + w < distanceMap.get(v)) {
                    distanceMap.put(v, distanceMap.get(u) + w);
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.dest;
            int w = edge.weight;
            if (distanceMap.get(u) != Integer.MAX_VALUE && distanceMap.get(u) + w < distanceMap.get(v)) {
                // Negative cycle detected
                return null;
            }
        }

        // Remove nodes with unreachable paths
        Iterator<Map.Entry<Integer, Integer>> iterator = distanceMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() == Integer.MAX_VALUE) {
                iterator.remove();
            }
        }

        return distanceMap;
    }

}
