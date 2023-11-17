package Copilot.Dijkstra.T35;

import java.util.*;

public class Dijkstra {
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

    public List<Edge> edges;
    public int n;
    public Map<Integer, List<Node>> graph;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.graph = new HashMap<>();
        for (Edge edge : edges) {
            if (!this.graph.containsKey(edge.source)) {
                this.graph.put(edge.source, new ArrayList<>());
            }
            this.graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> distance = new HashMap<>();
        for (int i = 0; i < this.n; i++) {
            distance.put(i, Integer.MAX_VALUE);
        }
        distance.put(source, 0);
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Node(source, 0));
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            int vertex = node.vertex;
            int weight = node.weight;
            if (visited.contains(vertex)) {
                continue;
            }
            visited.add(vertex);
            distance.put(vertex, weight);
            if (this.graph.containsKey(vertex)) {
                for (Node neighbor : this.graph.get(vertex)) {
                    if (visited.contains(neighbor.vertex)) {
                        continue;
                    }
                    minHeap.offer(new Node(neighbor.vertex, weight + neighbor.weight));
                }
            }
        }
        return distance;
    }


}