package Copilot.Dijkstra.T11;

import java.util.*;

public class Dijkstra {
    private int n;
    private List<Edge> edges;
    private List<List<Node>> graph;

    public Dijkstra(List<Edge> edges, int n) {
        this.n = n;
        this.edges = edges;
        this.graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (Edge edge : edges) {
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> res = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.weight - n2.weight;
            }
        });
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