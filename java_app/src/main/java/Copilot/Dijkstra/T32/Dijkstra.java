package Copilot.Dijkstra.T32;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;
    private List<Node> nodes;
    private Map<Integer, Integer> shortestPaths;
    private int source;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.nodes = new ArrayList<>();
        this.shortestPaths = new HashMap<>();
        this.source = 0;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        this.source = source;
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i, Integer.MAX_VALUE));
        }
        nodes.get(source).weight = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(nodes.get(source));
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            shortestPaths.put(cur.vertex, cur.weight);
            for (Edge edge : edges) {
                if (edge.source == cur.vertex) {
                    Node next = nodes.get(edge.dest);
                    if (cur.weight + edge.weight < next.weight) {
                        next.weight = cur.weight + edge.weight;
                        minHeap.offer(next);
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