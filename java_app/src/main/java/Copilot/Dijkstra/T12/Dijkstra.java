package Copilot.Dijkstra.T12;

import java.util.*;

public class Dijkstra {
    List<Edge> edges;
    int n;
    public Dijkstra(List<Edge> edges, int n){
        this.edges = edges;
        this.n = n;
    }
    public Map<Integer, Integer> findShortestPaths(int source){
        Map<Integer, Integer> res = new HashMap<>();
        if (n <= 0) {
            return res;
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(n, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return Integer.compare(a.weight, b.weight);
            }
        });
        minHeap.offer(new Node(source, 0));
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            for (Edge edge : edges) {
                if (edge.source == cur.vertex) {
                    if (cur.weight + edge.weight < dist[edge.dest]) {
                        dist[edge.dest] = cur.weight + edge.weight;
                        minHeap.offer(new Node(edge.dest, dist[edge.dest]));
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                res.put(i, dist[i]);
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