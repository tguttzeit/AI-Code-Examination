package ChatGPT.Dijkstra.T47;

import java.util.*;

public class Dijkstra {
    private final int n;
    private final List<Edge> edges;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Initialize the distance map with maximum values for all nodes except the source.
        Map<Integer, Integer> distanceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            distanceMap.put(i, Integer.MAX_VALUE);
        }
        distanceMap.put(source, 0);

        // Create a priority queue for Dijkstra's algorithm.
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            // Skip if we've already found a shorter path to this node.
            if (currentWeight > distanceMap.get(currentVertex)) {
                continue;
            }

            // Explore neighbors of the current node.
            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighborVertex = edge.dest;
                    int neighborWeight = edge.weight;
                    int newDistance = currentWeight + neighborWeight;

                    // Update the distance if a shorter path is found.
                    if (newDistance < distanceMap.get(neighborVertex)) {
                        distanceMap.put(neighborVertex, newDistance);
                        minHeap.offer(new Node(neighborVertex, newDistance));
                    }
                }
            }
        }

        // Remove unreachable nodes from the result.
        distanceMap.values().removeIf(val -> val == Integer.MAX_VALUE);

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