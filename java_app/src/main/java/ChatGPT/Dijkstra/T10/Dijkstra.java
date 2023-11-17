package ChatGPT.Dijkstra.T10;

import java.util.*;

public class Dijkstra {
    private final List<Edge> edges;
    private final int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        // Initialize distances with infinity and the source with 0
        for (int i = 0; i < n; i++) {
            shortestPaths.put(i, Integer.MAX_VALUE);
        }
        shortestPaths.put(source, 0);

        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            // Skip this node if its distance is greater than the known shortest distance
            if (currentWeight > shortestPaths.get(currentVertex)) {
                continue;
            }

            // Relaxation step
            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighbor = edge.dest;
                    int newDistance = currentWeight + edge.weight;

                    if (newDistance < shortestPaths.get(neighbor)) {
                        shortestPaths.put(neighbor, newDistance);
                        minHeap.offer(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        // Remove unreachable nodes
        shortestPaths.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

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
