package ChatGPT.Dijkstra.T18;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            int u = current.vertex;

            if (current.weight > dist[u]) {
                continue;
            }

            for (Edge edge : edges) {
                if (edge.source == u) {
                    int v = edge.dest;
                    int alt = dist[u] + edge.weight;
                    if (alt < dist[v]) {
                        dist[v] = alt;
                        minHeap.add(new Node(v, alt));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                shortestPaths.put(i, dist[i]);
            }
        }

        return shortestPaths;
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

    public static class Node {
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
