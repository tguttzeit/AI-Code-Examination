package Copilot.Dijkstra.T45;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;
    private int source;

    public Dijkstra(List<Edge> edges, int n, int source) {
        this.edges = edges;
        this.n = n;
        this.source = source;
    }

    public Map<Integer, Integer> findShortestPaths() {
        Map<Integer, Integer> result = new HashMap<>();
        // initialize graph
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (Edge edge : edges) {
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }

        // initialize distance
        Queue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Node(source, 0));
        Set<Integer> visited = new HashSet<>();
        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            if (visited.contains(curr.vertex)) {
                continue;
            }
            visited.add(curr.vertex);
            result.put(curr.vertex, curr.weight);
            for (Node neighbor : graph.get(curr.vertex)) {
                if (!visited.contains(neighbor.vertex)) {
                    minHeap.offer(new Node(neighbor.vertex, curr.weight + neighbor.weight));
                }
            }
        }
        return result;
    }

    static class Edge {
        int source;
        int dest;
        int weight;
        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Node {
        int vertex;
        int weight;
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }


}