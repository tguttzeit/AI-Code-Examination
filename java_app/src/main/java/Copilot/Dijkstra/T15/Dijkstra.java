package Copilot.Dijkstra.T15;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> distance = new HashMap<>();
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (Edge edge : edges) {
            graph.putIfAbsent(edge.source, new ArrayList<>());
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Node(source, 0));
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if (distance.containsKey(cur.vertex)) {
                continue;
            }
            distance.put(cur.vertex, cur.weight);
            if (!graph.containsKey(cur.vertex)) {
                continue;
            }
            for (Node nei : graph.get(cur.vertex)) {
                if (distance.containsKey(nei.vertex)) {
                    continue;
                }
                minHeap.offer(new Node(nei.vertex, cur.weight + nei.weight));
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