package Copilot.Dijkstra.T10;

import java.util.*;

public class Dijkstra {
    public class Edge {
        public int source;
        public int dest;
        public int weight;
        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }
    public class Node {
        public int vertex;
        public int weight;
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    private List<Edge> edges;
    private Map<Integer, List<Node>> graph;
    private int n;
    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (Edge edge : edges) {
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
            graph.get(edge.dest).add(new Node(edge.source, edge.weight));
        }
    }
    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> result = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Node(source, 0));
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if (visited.contains(cur.vertex)) {
                continue;
            }
            visited.add(cur.vertex);
            result.put(cur.vertex, cur.weight);
            for (Node nei : graph.get(cur.vertex)) {
                if (!visited.contains(nei.vertex)) {
                    minHeap.offer(new Node(nei.vertex, cur.weight + nei.weight));
                }
            }
        }
        return result;
    }

}