package Copilot.Dijkstra.T36;

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
    private List<Edge>[] graph;
    private int n;
    public Dijkstra(List<Edge> edges, int n) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (Edge edge : edges) {
            graph[edge.source].add(edge);
        }
        this.n = n;
    }
    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        pq.offer(new Node(source, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.vertex]) {
                continue;
            }
            visited[cur.vertex] = true;
            map.put(cur.vertex, cur.weight);
            for (Edge edge : graph[cur.vertex]) {
                if (!visited[edge.dest]) {
                    pq.offer(new Node(edge.dest, cur.weight + edge.weight));
                }
            }
        }
        return map;
    }


}