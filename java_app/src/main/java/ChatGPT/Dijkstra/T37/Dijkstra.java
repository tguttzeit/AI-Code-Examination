package ChatGPT.Dijkstra.T37;

import java.util.*;

public class Dijkstra {
    private final int n;
    private final List<Edge> edges;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Initialize distance array and set all distances to infinity
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Create a map to store the shortest paths
        Map<Integer, Integer> shortestPaths = new HashMap<>();

        // Create a priority queue to hold nodes to visit
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        distance[source] = 0; // Distance to the source node is 0
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            // Skip this node if we have already found a shorter path to it
            if (currentWeight > distance[currentVertex]) {
                continue;
            }

            // Update the shortest path to all neighboring nodes
            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighbor = edge.dest;
                    int newWeight = currentWeight + edge.weight;

                    // If the new path is shorter, update the distance and add it to the priority queue
                    if (newWeight < distance[neighbor]) {
                        distance[neighbor] = newWeight;
                        minHeap.add(new Node(neighbor, newWeight));
                        shortestPaths.put(neighbor, newWeight);
                    }
                }
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
