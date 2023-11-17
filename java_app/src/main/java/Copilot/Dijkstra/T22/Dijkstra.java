package Copilot.Dijkstra.T22;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;
    private Map<Integer, List<Node>> graph;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (Edge edge : edges) {
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> result = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Node(source, 0));
        Set<Integer> visited = new HashSet<>();
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if (visited.contains(cur.vertex)) {
                continue;
            }
            visited.add(cur.vertex);
            result.put(cur.vertex, cur.weight);
            for (Node neighbor : graph.get(cur.vertex)) {
                if (!visited.contains(neighbor.vertex)) {
                    minHeap.offer(new Node(neighbor.vertex, neighbor.weight + cur.weight));
                }
            }
        }
        return result;
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