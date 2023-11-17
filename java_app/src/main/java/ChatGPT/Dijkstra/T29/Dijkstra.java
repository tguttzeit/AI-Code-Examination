package ChatGPT.Dijkstra.T29;

import java.util.*;

public class Dijkstra {
    private final List<Edge> edges;
    private final int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Initialize the distance map with maximum values and set the distance to the source node as 0.
        Map<Integer, Integer> distanceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            distanceMap.put(i, Integer.MAX_VALUE);
        }
        distanceMap.put(source, 0);

        // Create a priority queue to hold nodes with their distances.
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.offer(new Node(source, 0));

        // Dijkstra's algorithm
        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            // Skip nodes that have already been processed with a shorter distance.
            if (currentWeight > distanceMap.get(currentVertex)) {
                continue;
            }

            // Explore neighbors
            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighbor = edge.dest;
                    int newWeight = currentWeight + edge.weight;

                    // Update the distance if a shorter path is found.
                    if (newWeight < distanceMap.get(neighbor)) {
                        distanceMap.put(neighbor, newWeight);
                        minHeap.offer(new Node(neighbor, newWeight));
                    }
                }
            }
        }

        // Remove nodes with unreachable paths (infinite distance).
        distanceMap.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

        return distanceMap;
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