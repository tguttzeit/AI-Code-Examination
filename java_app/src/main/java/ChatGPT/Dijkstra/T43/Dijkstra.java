package ChatGPT.Dijkstra.T43;

import java.util.*;

public class Dijkstra {
    private final List<Edge> edges;
    private final int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Create a map to store the shortest distances from the source to each node
        Map<Integer, Integer> shortestDistances = new HashMap<>();

        // Create a priority queue to prioritize nodes with the smallest distance
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        // Initialize the distances, set the source distance to 0 and others to infinity
        for (int i = 0; i < n; i++) {
            shortestDistances.put(i, Integer.MAX_VALUE);
        }
        shortestDistances.put(source, 0);

        // Add the source node to the priority queue
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            // Skip nodes with outdated distances
            if (currentWeight > shortestDistances.get(currentVertex)) {
                continue;
            }

            // Update distances for neighboring nodes
            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighborVertex = edge.dest;
                    int neighborWeight = edge.weight;
                    int newDistance = currentWeight + neighborWeight;

                    if (newDistance < shortestDistances.get(neighborVertex)) {
                        shortestDistances.put(neighborVertex, newDistance);
                        minHeap.add(new Node(neighborVertex, newDistance));
                    }
                }
            }
        }

        // Remove unreachable nodes from the result
        shortestDistances.values().removeIf(distance -> distance == Integer.MAX_VALUE);

        return shortestDistances;
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
