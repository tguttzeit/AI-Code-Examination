package ChatGPT.Dijkstra.T8;

import java.util.*;

public class Dijkstra {
    private final List<Edge> edges;
    private final int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Create a map to store the shortest distances to each node from the source node.
        Map<Integer, Integer> shortestDistances = new HashMap<>();

        // Initialize distances to infinity and mark all nodes as unvisited.
        for (int i = 0; i < n; i++) {
            shortestDistances.put(i, Integer.MAX_VALUE);
        }
        shortestDistances.put(source, 0);

        // Create a priority queue to store nodes to be processed.
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();

            // If the current node's distance is greater than the stored distance, skip it.
            if (currentNode.weight > shortestDistances.get(currentNode.vertex)) {
                continue;
            }

            // Update the distances to the neighboring nodes.
            for (Edge edge : edges) {
                if (edge.source == currentNode.vertex) {
                    int newDistance = shortestDistances.get(currentNode.vertex) + edge.weight;
                    if (newDistance < shortestDistances.get(edge.dest)) {
                        shortestDistances.put(edge.dest, newDistance);
                        minHeap.offer(new Node(edge.dest, newDistance));
                    }
                }
            }
        }

        // Remove nodes with unreachable paths (distance still set to infinity).
        shortestDistances.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

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
