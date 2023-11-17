package ChatGPT.Dijkstra.T7;

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

        // Initialize distances to all nodes as infinity and the source as 0.
        for (int i = 0; i < n; i++) {
            shortestPaths.put(i, Integer.MAX_VALUE);
        }
        shortestPaths.put(source, 0);

        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();

            // Skip if we have already found a shorter path to this node.
            if (currentNode.weight > shortestPaths.get(currentNode.vertex)) {
                continue;
            }

            // Explore neighbors of the current node.
            for (Edge edge : edges) {
                if (edge.source == currentNode.vertex) {
                    int newDistance = shortestPaths.get(currentNode.vertex) + edge.weight;
                    if (newDistance < shortestPaths.get(edge.dest)) {
                        shortestPaths.put(edge.dest, newDistance);
                        minHeap.add(new Node(edge.dest, newDistance));
                    }
                }
            }
        }

        // Remove nodes with infinite distance (no path).
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
