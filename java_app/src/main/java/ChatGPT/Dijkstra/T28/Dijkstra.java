package ChatGPT.Dijkstra.T28;

import java.util.*;

public class Dijkstra {
    private final int n;
    private final List<Edge> edges;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        // Initialize distances to infinity and add the source node to the heap
        for (int i = 1; i <= n; i++) {
            shortestPaths.put(i, Integer.MAX_VALUE);
        }
        shortestPaths.put(source, 0);
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            // Skip if we've already found a shorter path to this node
            if (currentWeight > shortestPaths.get(currentVertex)) {
                continue;
            }

            // Explore neighbors
            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighbor = edge.dest;
                    int weight = edge.weight;

                    int newDistance = currentWeight + weight;
                    if (newDistance < shortestPaths.get(neighbor)) {
                        shortestPaths.put(neighbor, newDistance);
                        minHeap.offer(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        // Remove nodes with infinite distance (no path)
        shortestPaths.values().removeIf(distance -> distance == Integer.MAX_VALUE);

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