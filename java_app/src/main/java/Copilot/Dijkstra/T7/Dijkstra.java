package Copilot.Dijkstra.T7;

import java.util.*;

public class Dijkstra {

    public List<Edge> edges;
    public int n;
    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }
    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (Edge edge : edges) {
            if (!graph.containsKey(edge.source)) {
                graph.put(edge.source, new ArrayList<>());
            }
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(source, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (map.containsKey(cur.vertex)) {
                continue;
            }
            map.put(cur.vertex, cur.weight);
            if (!graph.containsKey(cur.vertex)) {
                continue;
            }
            for (Node nei : graph.get(cur.vertex)) {
                if (!map.containsKey(nei.vertex)) {
                    pq.offer(new Node(nei.vertex, cur.weight + nei.weight));
                }
            }
        }
        return map;
    }
    class Edge {
        public int source;
        public int dest;
        public int weight;
        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }
    class Node {
        public int vertex;
        public int weight;
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

}