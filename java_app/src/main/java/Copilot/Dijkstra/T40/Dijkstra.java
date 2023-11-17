package Copilot.Dijkstra.T40;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;
    private Map<Integer, List<Node>> graph;
    private Map<Integer, Integer> dist;
    private Map<Integer, Integer> prev;
    private PriorityQueue<Node> pq;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.graph = new HashMap<>();
        this.dist = new HashMap<>();
        this.prev = new HashMap<>();
        this.pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (Edge edge : edges) {
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }

        for (int i = 0; i < n; i++) {
            dist.put(i, Integer.MAX_VALUE);
            prev.put(i, -1);
        }

        dist.put(source, 0);
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            for (Node next : graph.get(curr.vertex)) {
                int newDist = dist.get(curr.vertex) + next.weight;
                if (newDist < dist.get(next.vertex)) {
                    dist.put(next.vertex, newDist);
                    prev.put(next.vertex, curr.vertex);
                    pq.offer(new Node(next.vertex, newDist));
                }
            }
        }
        return dist;
    }

    private static class Edge {
        public int source;
        public int dest;
        public int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static class Node {
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }


}