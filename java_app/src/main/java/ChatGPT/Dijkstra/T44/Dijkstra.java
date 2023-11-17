package ChatGPT.Dijkstra.T44;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Initialize the distance array with infinity values
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Create a priority queue to store nodes based on their distance
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        // Create a map to store the shortest path distances
        Map<Integer, Integer> shortestPaths = new HashMap<>();

        // Add the source node to the priority queue and set its distance to 0
        minHeap.offer(new Node(source, 0));
        distance[source] = 0;

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            // If the current weight is greater than the known distance, skip this node
            if (currentWeight > distance[currentVertex]) {
                continue;
            }

            // Update the shortest path distances for neighboring nodes
            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighbor = edge.dest;
                    int newWeight = currentWeight + edge.weight;

                    if (newWeight < distance[neighbor]) {
                        distance[neighbor] = newWeight;
                        minHeap.offer(new Node(neighbor, newWeight));
                    }
                }
            }
        }

        // Populate the shortestPaths map with valid shortest path distances
        for (int i = 0; i < n; i++) {
            if (distance[i] != Integer.MAX_VALUE) {
                shortestPaths.put(i, distance[i]);
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
