package ChatGPT.Dijkstra.T3;

import java.util.*;

public class Dijkstra {
    private final int n;
    private final List<Edge> edges;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Create a map to store the shortest distances from the source to all other nodes.
        Map<Integer, Integer> shortestDistances = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            shortestDistances.put(i, Integer.MAX_VALUE);
        }

        // Create a priority queue to process nodes in the order of their distances from the source.
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new Node(source, 0));
        shortestDistances.put(source, 0);

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();

            // Skip nodes that have already been processed with a shorter distance.
            if (currentNode.weight > shortestDistances.get(currentNode.vertex)) {
                continue;
            }

            // Explore neighbors of the current node.
            for (Edge edge : edges) {
                if (edge.source == currentNode.vertex) {
                    int neighbor = edge.dest;
                    int newDistance = currentNode.weight + edge.weight;

                    // Update the distance if it's shorter.
                    if (newDistance < shortestDistances.get(neighbor)) {
                        shortestDistances.put(neighbor, newDistance);
                        minHeap.add(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        // Remove nodes with unreachable paths (still set to Integer.MAX_VALUE).
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

    private static class Node {
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
