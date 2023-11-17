package ChatGPT.Dijkstra.T34;

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

        // Initialize distances to infinity, except for the source node.
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int u = currentNode.vertex;
            int currentDistance = currentNode.weight;

            // Skip if we've already found a shorter path to this node.
            if (currentDistance > distances[u])
                continue;

            // Relax edges
            for (Edge edge : edges) {
                if (edge.source == u) {
                    int v = edge.dest;
                    int weightUV = edge.weight;
                    int newDistance = currentDistance + weightUV;

                    // Update the distance if a shorter path is found
                    if (newDistance < distances[v]) {
                        distances[v] = newDistance;
                        minHeap.offer(new Node(v, newDistance));
                    }
                }
            }
        }

        // Populate the shortestPaths map
        for (int i = 0; i < n; i++) {
            if (distances[i] != Integer.MAX_VALUE) {
                shortestPaths.put(i, distances[i]);
            }
        }

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
