package ChatGPT.Dijkstra.T2;

import java.util.*;

public class Dijkstra {
    private final int n;
    private final List<Edge> edges;
    private final Map<Integer, List<Edge>> adjacencyList;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.adjacencyList = new HashMap<>();

        for (Edge edge : edges) {
            adjacencyList.computeIfAbsent(edge.source, k -> new ArrayList<>()).add(edge);
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        minHeap.add(new Node(source, 0));
        shortestPaths.put(source, 0);

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            if (currentWeight > shortestPaths.get(currentVertex)) {
                continue; // Skip if we have a better path to this node already
            }

            if (adjacencyList.containsKey(currentVertex)) {
                for (Edge edge : adjacencyList.get(currentVertex)) {
                    int neighborVertex = edge.dest;
                    int neighborWeight = currentWeight + edge.weight;

                    if (neighborWeight < shortestPaths.getOrDefault(neighborVertex, Integer.MAX_VALUE)) {
                        shortestPaths.put(neighborVertex, neighborWeight);
                        minHeap.add(new Node(neighborVertex, neighborWeight));
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