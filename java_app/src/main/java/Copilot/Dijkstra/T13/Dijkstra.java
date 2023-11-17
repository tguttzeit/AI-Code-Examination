package Copilot.Dijkstra.T13;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(n, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.weight - n2.weight;
            }
        });
        pq.offer(new Node(source, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (map.containsKey(cur.vertex)) {
                continue;
            }
            map.put(cur.vertex, cur.weight);
            for (Edge edge : edges) {
                if (edge.source == cur.vertex && !map.containsKey(edge.dest)) {
                    pq.offer(new Node(edge.dest, cur.weight + edge.weight));
                }
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