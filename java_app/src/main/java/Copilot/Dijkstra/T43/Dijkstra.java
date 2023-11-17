package Copilot.Dijkstra.T43;

import java.util.*;

public class Dijkstra {
    public static int INF = Integer.MAX_VALUE;
    private List<Edge> edges;
    private int n;
    private List<Node> nodes;
    private int[] dist;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i, INF));
        }
        dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = INF;
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        nodes.get(source).weight = 0;
        pq.offer(nodes.get(source));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;
            for (int i = 0; i < edges.size(); i++) {
                Edge edge = edges.get(i);
                if (edge.source == u) {
                    int v = edge.dest;
                    int weight = edge.weight;
                    if (nodes.get(v).weight > nodes.get(u).weight + weight) {
                        nodes.get(v).weight = nodes.get(u).weight + weight;
                        pq.offer(nodes.get(v));
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != source && nodes.get(i).weight != INF) {
                map.put(i, nodes.get(i).weight);
            }
        }
        return map;
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