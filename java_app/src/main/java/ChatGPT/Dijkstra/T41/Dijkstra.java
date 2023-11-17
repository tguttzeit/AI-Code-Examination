package ChatGPT.Dijkstra.T41;

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
        boolean[] visited = new boolean[n];

        // Initialize distances to infinity and source to 0.
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;

            // Skip if already visited.
            if (visited[currentVertex]) {
                continue;
            }

            visited[currentVertex] = true;

            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighborVertex = edge.dest;
                    int edgeWeight = edge.weight;

                    // Relaxation step.
                    if (!visited[neighborVertex] && distances[currentVertex] != Integer.MAX_VALUE &&
                            distances[currentVertex] + edgeWeight < distances[neighborVertex]) {
                        distances[neighborVertex] = distances[currentVertex] + edgeWeight;
                        minHeap.add(new Node(neighborVertex, distances[neighborVertex]));
                    }
                }
            }
        }

        // Populate the shortestPaths map with the distances.
        for (int i = 0; i < n; i++) {
            if (i != source && distances[i] != Integer.MAX_VALUE) {
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