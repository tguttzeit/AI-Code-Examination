package ChatGPT.Dijkstra.T31;

import java.util.*;

public class Dijkstra {
    private final List<Edge> edges;
    private final int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Initialize distance map with infinity for all nodes except the source.
        Map<Integer, Integer> distances = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        // Priority queue to process nodes in ascending order of distance.
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.offer(new Node(source, 0));

        // While the priority queue is not empty, keep processing nodes.
        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();

            // Skip nodes whose distance is still infinity (unreachable).
            if (distances.get(currentNode.vertex) == Integer.MAX_VALUE) {
                continue;
            }

            // Explore neighbors of the current node and update distances if shorter path found.
            for (Edge edge : edges) {
                if (edge.source == currentNode.vertex) {
                    int newDist = distances.get(currentNode.vertex) + edge.weight;
                    if (newDist < distances.get(edge.dest)) {
                        distances.put(edge.dest, newDist);
                        minHeap.offer(new Node(edge.dest, newDist));
                    }
                }
            }
        }

        // Remove nodes with infinite distance (unreachable) from the result.
        distances.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

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
