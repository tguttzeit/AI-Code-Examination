package Copilot.Dijkstra.T31;

import java.util.*;

public class Dijkstra {
    int n;
    List<Edge> edges;
    List<Node> nodes;
    public Dijkstra(List<Edge> edges, int n) {
        this.n = n;
        this.edges = edges;
        nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i, Integer.MAX_VALUE));
        }
    }
    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> res = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        nodes.get(source).weight = 0;
        pq.offer(nodes.get(source));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            res.put(cur.vertex, cur.weight);
            for (Edge e : edges) {
                if (e.source == cur.vertex && nodes.get(e.dest).weight > cur.weight + e.weight) {
                    nodes.get(e.dest).weight = cur.weight + e.weight;
                    pq.offer(nodes.get(e.dest));
                }
            }
        }
        return res;
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