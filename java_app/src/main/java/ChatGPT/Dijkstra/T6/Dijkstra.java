package ChatGPT.Dijkstra.T6;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Create a priority queue to store nodes with their weights
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        // Initialize distance array to store the shortest distances from the source node
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Create a map to store the shortest paths
        Map<Integer, Integer> shortestPaths = new HashMap<>();

        // Add the source node to the priority queue and set its distance to 0
        minHeap.offer(new Node(source, 0));
        distance[source] = 0;

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();

            // If the current node's weight is greater than the stored distance, skip it
            if (currentNode.weight > distance[currentNode.vertex]) {
                continue;
            }

            // Update shortest paths to neighboring nodes
            for (Edge edge : edges) {
                if (edge.source == currentNode.vertex) {
                    int newDistance = distance[currentNode.vertex] + edge.weight;
                    if (newDistance < distance[edge.dest]) {
                        distance[edge.dest] = newDistance;
                        minHeap.offer(new Node(edge.dest, newDistance));
                        shortestPaths.put(edge.dest, newDistance);
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
