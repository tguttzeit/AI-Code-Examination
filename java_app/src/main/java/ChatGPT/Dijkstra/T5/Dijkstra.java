package ChatGPT.Dijkstra.T5;

import java.util.*;

public class Dijkstra {
    private final List<Edge> edges;
    private final int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Initialize the distance map to store the shortest distance from the source
        Map<Integer, Integer> distanceMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            distanceMap.put(i, Integer.MAX_VALUE);
        }
        distanceMap.put(source, 0);

        // Create a priority queue to track nodes with the shortest distance
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();

            // If the current node's distance is greater than the recorded distance, skip it
            if (currentNode.weight > distanceMap.get(currentNode.vertex)) {
                continue;
            }

            // Relaxation step: Update distances to neighbors if shorter path is found
            for (Edge edge : edges) {
                if (edge.source == currentNode.vertex) {
                    int newDistance = distanceMap.get(currentNode.vertex) + edge.weight;
                    if (newDistance < distanceMap.get(edge.dest)) {
                        distanceMap.put(edge.dest, newDistance);
                        minHeap.add(new Node(edge.dest, newDistance));
                    }
                }
            }
        }

        // Remove unreachable nodes from the distance map
        distanceMap.values().removeIf(d -> d == Integer.MAX_VALUE);

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
