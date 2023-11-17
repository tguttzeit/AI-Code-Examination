package ChatGPT.Dijkstra.T40;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Initialize a map to store the shortest distances from the source to all other nodes
        Map<Integer, Integer> shortestDistances = new HashMap<>();

        // Initialize a priority queue to hold nodes based on their current distance from the source
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        // Initialize all distances to infinity except for the source node, which is set to 0
        for (int i = 1; i <= n; i++) {
            if (i == source) {
                shortestDistances.put(i, 0);
            } else {
                shortestDistances.put(i, Integer.MAX_VALUE);
            }
        }

        // Add the source node to the priority queue
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            // If the current distance is greater than the stored distance, skip this node
            if (currentWeight > shortestDistances.get(currentVertex)) {
                continue;
            }

            // Explore neighbors of the current node
            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighborVertex = edge.dest;
                    int neighborWeight = edge.weight;
                    int newDistance = currentWeight + neighborWeight;

                    // Update the distance if a shorter path is found
                    if (newDistance < shortestDistances.get(neighborVertex)) {
                        shortestDistances.put(neighborVertex, newDistance);
                        pq.add(new Node(neighborVertex, newDistance));
                    }
                }
            }
        }

        // Remove entries with infinite distances (no path)
        shortestDistances.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

        return shortestDistances;
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
