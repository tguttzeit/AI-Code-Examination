package ChatGPT.Dijkstra.T25;

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

        // Initialize distances with infinity and mark all nodes as unvisited
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];

        distances[source] = 0;
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;

            if (visited[currentVertex]) {
                continue;
            }

            visited[currentVertex] = true;

            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighbor = edge.dest;
                    int newDistance = distances[currentVertex] + edge.weight;

                    if (newDistance < distances[neighbor]) {
                        distances[neighbor] = newDistance;
                        minHeap.offer(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        // Populate the shortestPaths map with valid shortest distances
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