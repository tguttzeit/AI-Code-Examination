package Copilot.Dijkstra.T6;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;
    private int source;
    private Map<Integer, Integer> output;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.output = new HashMap<>();
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        this.source = source;
        PriorityQueue<Node> pq = new PriorityQueue<>(n, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.weight - n2.weight;
            }
        });
        pq.offer(new Node(source, 0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int vertex = node.vertex;
            int weight = node.weight;
            if (output.containsKey(vertex)) {
                continue;
            }
            output.put(vertex, weight);
            for (Edge edge : edges) {
                if (edge.source == vertex && !output.containsKey(edge.dest)) {
                    pq.offer(new Node(edge.dest, weight + edge.weight));
                }
            }
        }
        return output;
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