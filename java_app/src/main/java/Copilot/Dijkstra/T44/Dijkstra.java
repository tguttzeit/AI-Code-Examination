package Copilot.Dijkstra.T44;

import java.util.*;

public class Dijkstra {
    private final List<Edge> edges;
    private final int n;
    private final Map<Integer, List<Node>> graph;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            this.graph.put(i, new ArrayList<>());
        }
        for (Edge edge : edges) {
            this.graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 0; i < n; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }
        dist.put(source, 0);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Node(source, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Node neighbor : graph.get(node.vertex)) {
                int newDist = dist.get(node.vertex) + neighbor.weight;
                if (newDist < dist.get(neighbor.vertex)) {
                    dist.put(neighbor.vertex, newDist);
                    pq.add(new Node(neighbor.vertex, newDist));
                }
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

    public static class Node {
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

}