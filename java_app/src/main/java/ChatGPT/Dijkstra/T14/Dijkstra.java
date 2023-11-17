package ChatGPT.Dijkstra.T14;

import java.util.*;

public class Dijkstra {
    private final int n;
    private final List<Edge> edges;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        boolean[] visited = new boolean[n];

        // Initialize distances to infinity and the source node to 0.
        for (int i = 0; i < n; i++) {
            shortestPaths.put(i, Integer.MAX_VALUE);
        }
        shortestPaths.put(source, 0);

        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;

            // Skip nodes that have already been visited.
            if (visited[currentVertex]) {
                continue;
            }

            visited[currentVertex] = true;

            for (Edge edge : edges) {
                if (edge.source == currentVertex) {
                    int neighborVertex = edge.dest;
                    int neighborWeight = edge.weight;

                    // Relaxation step: Update the shortest distance if a shorter path is found.
                    if (!visited[neighborVertex] && shortestPaths.get(currentVertex) != Integer.MAX_VALUE &&
                            shortestPaths.get(currentVertex) + neighborWeight < shortestPaths.get(neighborVertex)) {
                        shortestPaths.put(neighborVertex, shortestPaths.get(currentVertex) + neighborWeight);
                        minHeap.offer(new Node(neighborVertex, shortestPaths.get(neighborVertex)));
                    }
                }
            }
        }

        // Remove unreachable nodes from the result.
        shortestPaths.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

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
