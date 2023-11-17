package Copilot.Dijkstra.T20;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;
    private Map<Integer, List<Node>> graph;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (Edge edge : edges) {
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> distance = new HashMap<>();
        for (int i = 0; i < n; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
        distance.put(source, 0);

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            for (Node neighbor : graph.get(curr.vertex)) {
                if (distance.get(neighbor.vertex) > distance.get(curr.vertex) + neighbor.weight) {
                    distance.put(neighbor.vertex, distance.get(curr.vertex) + neighbor.weight);
                    minHeap.offer(new Node(neighbor.vertex, distance.get(neighbor.vertex)));
                }
            }
        }
        return distance;
    }

    static class Edge {
        public int source;
        public int dest;
        public int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Node {
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

}