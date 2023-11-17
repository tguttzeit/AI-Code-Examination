package ChatGPT.Dijkstra.T26;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Initialize distances and visited nodes
        Map<Integer, Integer> distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        // Create a priority queue to store nodes with their distances
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            // Skip this node if we've already processed it
            if (visited.contains(currentVertex)) {
                continue;
            }

            // Mark the current node as visited
            visited.add(currentVertex);

            // Update distances to adjacent nodes
            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighbor = edge.dest;
                    int newDistance = currentWeight + edge.weight;
                    if (newDistance < distances.get(neighbor)) {
                        distances.put(neighbor, newDistance);
                        minHeap.add(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        // Remove nodes with unreachable paths
        distances.values().removeIf(d -> d == Integer.MAX_VALUE);

        return distances;
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