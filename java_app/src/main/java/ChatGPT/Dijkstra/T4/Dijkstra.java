package ChatGPT.Dijkstra.T4;

import java.util.*;

public class Dijkstra {
    private final List<Edge> edges;
    private final int n;
    private final Map<Integer, List<Edge>> graph;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.graph = new HashMap<>();
        buildGraph();
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        boolean[] visited = new boolean[n];

        // Initialize distances to infinity and add the source node to the min heap
        for (int i = 0; i < n; i++) {
            shortestPaths.put(i, Integer.MAX_VALUE);
        }
        shortestPaths.put(source, 0);
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;

            if (visited[currentVertex]) {
                continue;
            }

            visited[currentVertex] = true;

            if (graph.containsKey(currentVertex)) {
                for (Edge edge : graph.get(currentVertex)) {
                    int neighbor = edge.dest;
                    int newDistance = shortestPaths.get(currentVertex) + edge.weight;

                    if (newDistance < shortestPaths.get(neighbor)) {
                        shortestPaths.put(neighbor, newDistance);
                        minHeap.add(new Node(neighbor, newDistance));
                    }
                }
            }
        }

        // Remove nodes with no path from the result
        shortestPaths.entrySet().removeIf(entry -> entry.getValue() == Integer.MAX_VALUE);

        return shortestPaths;
    }

    private void buildGraph() {
        for (Edge edge : edges) {
            graph.computeIfAbsent(edge.source, k -> new ArrayList<>()).add(edge);
        }
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
