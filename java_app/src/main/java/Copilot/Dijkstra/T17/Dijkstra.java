package Copilot.Dijkstra.T17;

import java.util.*;

public class Dijkstra {

    List<Edge> edges;
    int n;
    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }
    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (Edge edge : edges) {
            if (!graph.containsKey(edge.source)) {
                graph.put(edge.source, new ArrayList<>());
            }
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
        Map<Integer, Integer> res = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return a.weight - b.weight;
            }
        });
        pq.offer(new Node(source, 0));
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
                if (!res.containsKey(nei.vertex)) {
                    pq.offer(new Node(nei.vertex, nei.weight + cur.weight));
                }
            }
        }
        return res;
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