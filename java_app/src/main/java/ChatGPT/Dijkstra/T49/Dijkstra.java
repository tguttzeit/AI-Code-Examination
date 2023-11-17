package ChatGPT.Dijkstra.T49;

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

        // Initialize distances to infinity and add the source node to the heap
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            if (currentWeight > distances[currentVertex]) {
                continue; // Skip outdated nodes
            }

            shortestPaths.put(currentVertex, currentWeight);

            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighbor = edge.dest;
                    int newWeight = currentWeight + edge.weight;

                    if (newWeight < distances[neighbor]) {
                        distances[neighbor] = newWeight;
                        minHeap.add(new Node(neighbor, newWeight));
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