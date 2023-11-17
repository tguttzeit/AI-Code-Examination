package Copilot.Dijkstra.T16;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;
    private Map<Integer, List<Node>> graph;
    private Map<Integer, Integer> shortestPaths;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.graph = new HashMap<>();
        this.shortestPaths = new HashMap<>();
        buildGraph();
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Queue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Node(source, 0));
        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            if (shortestPaths.containsKey(curr.vertex)) {
                continue;
            }
            shortestPaths.put(curr.vertex, curr.weight);
            for (Node neighbor : graph.get(curr.vertex)) {
                if (!shortestPaths.containsKey(neighbor.vertex)) {
                    minHeap.offer(new Node(neighbor.vertex, curr.weight + neighbor.weight));
                }
            }
        }
        return shortestPaths;
    }

    private void buildGraph() {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (Edge edge : edges) {
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
    }

    private class Node {
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    private class Edge {
        public int source;
        public int dest;
        public int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

}