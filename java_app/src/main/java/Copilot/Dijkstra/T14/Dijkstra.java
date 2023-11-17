package Copilot.Dijkstra.T14;

import java.util.*;

public class Dijkstra {

    private List<Edge> edges;
    private int n;
    private int source;
    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }
    public Map<Integer, Integer> findShortestPaths(int source) {
        this.source = source;
        Map<Integer, Integer> res = new HashMap<>();
        Map<Integer, List<Node>> graph = buildGraph();
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(source, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (res.containsKey(cur.vertex)) {
                continue;
            }
            res.put(cur.vertex, cur.weight);
            for (Node nei : graph.get(cur.vertex)) {
                if (!res.containsKey(nei.vertex)) {
                    pq.offer(new Node(nei.vertex, cur.weight + nei.weight));
                }
            }
        }
        return res;
    }
    private Map<Integer, List<Node>> buildGraph() {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (Edge edge : edges) {
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
        return graph;
    }
    static class Edge {
        public int source;
        public int dest;
        public int weight;
        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }
    static class Node {
        public int vertex;
        public int weight;
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }


}