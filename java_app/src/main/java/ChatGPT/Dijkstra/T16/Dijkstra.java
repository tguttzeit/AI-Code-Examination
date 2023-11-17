package ChatGPT.Dijkstra.T16;

import java.util.*;

public class Dijkstra {
    private final int n;
    private final List<Edge> edges;
    private final Map<Integer, List<Edge>> graph;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.graph = new HashMap<>();

        for (Edge edge : edges) {
            graph.putIfAbsent(edge.source, new ArrayList<>());
            graph.get(edge.source).add(edge);
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            int currentVertex = current.vertex;
            int currentWeight = current.weight;

            if (shortestPaths.containsKey(currentVertex)) {
                continue; // Skip nodes that have already been processed.
            }

            shortestPaths.put(currentVertex, currentWeight);

            if (graph.containsKey(currentVertex)) {
                for (Edge edge : graph.get(currentVertex)) {
                    int neighbor = edge.dest;
                    int edgeWeight = edge.weight;
                    if (!shortestPaths.containsKey(neighbor)) {
                        minHeap.add(new Node(neighbor, currentWeight + edgeWeight));
                    }
                }
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
