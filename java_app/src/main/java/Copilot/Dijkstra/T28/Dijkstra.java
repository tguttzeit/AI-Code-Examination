package Copilot.Dijkstra.T28;

import java.util.*;

public class Dijkstra {
    private final List<Edge> edges;
    private final int n;
    private final Map<Integer, List<Node>> graph;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (Edge e : edges) {
            graph.get(e.source).add(new Node(e.dest, e.weight));
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        Set<Integer> visited = new HashSet<>();
        minHeap.offer(new Node(source, 0));
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if (visited.contains(cur.vertex)) {
                continue;
            }
            visited.add(cur.vertex);
            distances.put(cur.vertex, cur.weight);
            for (Node nei : graph.get(cur.vertex)) {
                if (!visited.contains(nei.vertex)) {
                    minHeap.offer(new Node(nei.vertex, cur.weight + nei.weight));
                }
            }
        }
        return distances;
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