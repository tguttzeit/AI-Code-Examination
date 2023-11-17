package Copilot.Dijkstra.T8;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;
    private Map<Integer, Integer> shortestPaths;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        shortestPaths = new HashMap<>();
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(n, (a, b) -> a.weight - b.weight);
        boolean[] visited = new boolean[n + 1];
        int[] prev = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            prev[i] = -1;
        }
        minHeap.offer(new Node(source, 0));
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if (visited[cur.vertex]) {
                continue;
            }
            visited[cur.vertex] = true;
            shortestPaths.put(cur.vertex, cur.weight);
            for (Edge e : edges) {
                if (e.source == cur.vertex && !visited[e.dest]) {
                    if (cur.weight + e.weight < shortestPaths.getOrDefault(e.dest, Integer.MAX_VALUE)) {
                        shortestPaths.put(e.dest, cur.weight + e.weight);
                        prev[e.dest] = cur.vertex;
                        minHeap.offer(new Node(e.dest, cur.weight + e.weight));
                    }
                }
            }
        }
        return shortestPaths;
    }

    private static class Edge {
        public int source;
        public int dest;
        public int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    private static class Node {
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

}