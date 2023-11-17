package Copilot.Dijkstra.T42;

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
        Queue<Node> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        queue.offer(new Node(source, 0));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (map.containsKey(cur.vertex)) {
                continue;
            }
            map.put(cur.vertex, cur.weight);
            for (Edge e : edges) {
                if (e.source == cur.vertex && !map.containsKey(e.dest)) {
                    queue.offer(new Node(e.dest, cur.weight + e.weight));
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