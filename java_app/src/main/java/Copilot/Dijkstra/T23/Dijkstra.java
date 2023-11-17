package Copilot.Dijkstra.T23;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;
    private Map<Integer, List<Node>> graph;
    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.graph = new HashMap<>();
        for (Edge edge : edges) {
            if (!graph.containsKey(edge.source)) {
                graph.put(edge.source, new ArrayList<>());
            }
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
    }
    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> res = new HashMap<>();
        Map<Integer, Integer> distance = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        pq.offer(new Node(source, 0));
        distance.put(source, 0);
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (res.containsKey(cur.vertex)) {
                continue;
            }
            res.put(cur.vertex, cur.weight);
            if (!graph.containsKey(cur.vertex)) {
                continue;
            }
            for (Node nei : graph.get(cur.vertex)) {
                if (!distance.containsKey(nei.vertex) || distance.get(nei.vertex) > cur.weight + nei.weight) {
                    distance.put(nei.vertex, cur.weight + nei.weight);
                    pq.offer(new Node(nei.vertex, cur.weight + nei.weight));
                }
            }
        }
        return res;
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