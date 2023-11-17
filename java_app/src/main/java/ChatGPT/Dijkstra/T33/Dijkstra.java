package ChatGPT.Dijkstra.T33;

import java.util.*;

public class Dijkstra {
    private final List<Edge> edges;
    private final int n;
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

        minHeap.offer(new Node(source, 0));
        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            if (shortestPaths.containsKey(currentVertex)) {
                continue; // Skip if this vertex has already been processed
            }

            shortestPaths.put(currentVertex, currentWeight);

            List<Edge> neighbors = adjacencyList.getOrDefault(currentVertex, Collections.emptyList());
            for (Edge neighbor : neighbors) {
                int neighborVertex = neighbor.dest;
                int neighborWeight = neighbor.weight;
                if (!shortestPaths.containsKey(neighborVertex)) {
                    minHeap.offer(new Node(neighborVertex, currentWeight + neighborWeight));
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