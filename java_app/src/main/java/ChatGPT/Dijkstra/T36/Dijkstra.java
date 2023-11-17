package ChatGPT.Dijkstra.T36;

import java.util.*;

public class Dijkstra {
    private final int n;
    private final List<Edge> edges;

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

        // Create a priority queue for Dijkstra's algorithm
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;

            // Skip visited nodes
            if (visited.contains(currentVertex)) {
                continue;
            }

            visited.add(currentVertex);

            // Update distances for neighboring nodes
            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighbor = edge.dest;
                    int newDistance = distances.get(currentVertex) + edge.weight;

                    if (newDistance < distances.get(neighbor)) {
                        distances.put(neighbor, newDistance);
                        minHeap.offer(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        // Remove unreachable nodes from the result
        distances.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);
        distances.remove(source);

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
