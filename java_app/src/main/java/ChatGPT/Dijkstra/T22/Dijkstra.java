package ChatGPT.Dijkstra.T22;

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
            if (!graph.containsKey(edge.source)) {
                graph.put(edge.source, new ArrayList<>());
            }
            graph.get(edge.source).add(edge);
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        minHeap.offer(new Node(source, 0));
        shortestPaths.put(source, 0);

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();

            if (!graph.containsKey(currentNode.vertex)) {
                continue;
            }

            for (Edge edge : graph.get(currentNode.vertex)) {
                int neighbor = edge.dest;
                int newDistance = currentNode.weight + edge.weight;

                if (!shortestPaths.containsKey(neighbor) || newDistance < shortestPaths.get(neighbor)) {
                    shortestPaths.put(neighbor, newDistance);
                    minHeap.offer(new Node(neighbor, newDistance));
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
