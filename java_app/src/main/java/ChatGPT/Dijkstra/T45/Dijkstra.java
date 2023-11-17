package ChatGPT.Dijkstra.T45;

import java.util.*;

public class Dijkstra {
    private final int n;
    private final List<Edge> edges;
    private final Map<Integer, List<Edge>> graph;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.graph = new HashMap<>();
        buildGraph();
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            if (shortestPaths.containsKey(currentVertex)) {
                continue; // Skip already processed nodes
            }

            shortestPaths.put(currentVertex, currentWeight);

            if (graph.containsKey(currentVertex)) {
                for (Edge edge : graph.get(currentVertex)) {
                    int neighborVertex = edge.dest;
                    int neighborWeight = edge.weight;

                    if (!shortestPaths.containsKey(neighborVertex)) {
                        minHeap.offer(new Node(neighborVertex, currentWeight + neighborWeight));
                    }
                }
            }
        }

        return shortestPaths;
    }

    private void buildGraph() {
        for (Edge edge : edges) {
            graph.putIfAbsent(edge.source, new ArrayList<>());
            graph.get(edge.source).add(edge);
        }
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
