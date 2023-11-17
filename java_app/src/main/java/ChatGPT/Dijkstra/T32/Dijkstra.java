package ChatGPT.Dijkstra.T32;

import java.util.*;

public class Dijkstra {
    private final int n;
    private final List<Edge> edges;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Create a map to store the shortest distances to each node
        Map<Integer, Integer> shortestDistances = new HashMap<>();

        // Initialize distances with infinity and the source node with 0
        for (int i = 1; i <= n; i++) {
            shortestDistances.put(i, Integer.MAX_VALUE);
        }
        shortestDistances.put(source, 0);

        // Create a priority queue to keep track of nodes to explore
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        priorityQueue.offer(new Node(source, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            // Skip this node if we have already found a shorter path to it
            if (currentWeight > shortestDistances.get(currentVertex)) {
                continue;
            }

            // Explore neighboring nodes
            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighborVertex = edge.dest;
                    int edgeWeight = edge.weight;
                    int totalWeight = currentWeight + edgeWeight;

                    // Update the distance if we found a shorter path
                    if (totalWeight < shortestDistances.get(neighborVertex)) {
                        shortestDistances.put(neighborVertex, totalWeight);
                        priorityQueue.offer(new Node(neighborVertex, totalWeight));
                    }
                }
            }
        }

        // Remove nodes with unreachable paths (infinite distance)
        shortestDistances.values().removeIf(dist -> dist == Integer.MAX_VALUE);

        return shortestDistances;
    }

    // Inner class for Edge
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

    // Inner class for Node
    private static class Node {
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
