package ChatGPT.Dijkstra.T9;

import java.util.*;

public class Dijkstra {
    private final List<Edge> edges;
    private final int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        // Initialize a map to store the shortest distances to each node.
        Map<Integer, Integer> shortestDistances = new HashMap<>();

        // Initialize a priority queue to hold nodes to explore, ordered by their distances.
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        // Initialize the distance to the source node as 0.
        shortestDistances.put(source, 0);
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            // If we have already found a shorter path to this node, skip it.
            if (currentWeight > shortestDistances.get(currentVertex)) {
                continue;
            }

            // Explore neighbors of the current node.
            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighborVertex = edge.dest;
                    int neighborWeight = edge.weight;
                    int newDistance = currentWeight + neighborWeight;

                    // If we found a shorter path to the neighbor, update the distance.
                    if (newDistance < shortestDistances.getOrDefault(neighborVertex, Integer.MAX_VALUE)) {
                        shortestDistances.put(neighborVertex, newDistance);
                        minHeap.offer(new Node(neighborVertex, newDistance));
                    }
                }
            }
        }

        // Remove nodes with no path from the result.
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
