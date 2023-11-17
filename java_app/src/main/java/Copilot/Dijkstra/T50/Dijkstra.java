package Copilot.Dijkstra.T50;

import java.util.*;

public class Dijkstra {
    public class Edge {
        public int source;
        public int dest;
        public int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public class Node {
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    private List<Edge> edges;
    private int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (Edge edge : edges) {
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
        Map<Integer, Integer> res = new HashMap<>();
        Queue<Node> queue = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        queue.offer(new Node(source, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (res.containsKey(cur.vertex)) {
                continue;
            }
            res.put(cur.vertex, cur.weight);
            for (Node neighbor : graph.get(cur.vertex)) {
                if (!res.containsKey(neighbor.vertex)) {
                    queue.offer(new Node(neighbor.vertex, cur.weight + neighbor.weight));
                }
            }
        }
        return res;
    }

}