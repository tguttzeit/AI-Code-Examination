package ChatGPT.Dijkstra.T46;

import java.util.*;

public class Dijkstra {
    private final int n;
    private final List<Edge> edges;
    private final Map<Integer, List<Edge>> graph;

    public Dijkstra(List<Edge> edges, int n) {
        this.n = n;
        this.edges = edges;
        this.graph = new HashMap<>();
        buildGraph();
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> shortestPaths = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        boolean[] visited = new boolean[n];

        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;
            int currentWeight = currentNode.weight;

            if (visited[currentVertex]) {
                continue;
            }

            visited[currentVertex] = true;
            shortestPaths.put(currentVertex, currentWeight);

            List<Edge> neighbors = graph.getOrDefault(currentVertex, new ArrayList<>());
            for (Edge neighbor : neighbors) {
                if (!visited[neighbor.dest]) {
                    int newWeight = currentWeight + neighbor.weight;
                    minHeap.offer(new Node(neighbor.dest, newWeight));
                }
            }
        }

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
