package ChatGPT.Dijkstra.T17;

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

        for (int i = 0; i < n; i++) {
            shortestPaths.put(i, Integer.MAX_VALUE);
        }

        shortestPaths.put(source, 0);
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
                    int neighborVertex = edge.dest;
                    int newWeight = shortestPaths.get(currentVertex) + edge.weight;

                    if (newWeight < shortestPaths.get(neighborVertex)) {
                        shortestPaths.put(neighborVertex, newWeight);
                        minHeap.offer(new Node(neighborVertex, newWeight));
                    }
                }
            }
        }

        shortestPaths.remove(source); // Remove the source vertex from the result
        shortestPaths.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE); // Remove unreachable nodes
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
