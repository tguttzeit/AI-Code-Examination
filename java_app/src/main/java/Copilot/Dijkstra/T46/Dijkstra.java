package Copilot.Dijkstra.T46;

import java.util.*;

public class Dijkstra {

    private final List<Edge> edges;
    private final int n;
    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }
    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Node(source, 0));
        Set<Integer> visited = new HashSet<>();
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if (visited.contains(cur.vertex)) {
                continue;
            }
            visited.add(cur.vertex);
            for (Edge edge : edges) {
                if (edge.source == cur.vertex) {
                    if (distances.get(edge.dest) > distances.get(cur.vertex) + edge.weight) {
                        distances.put(edge.dest, distances.get(cur.vertex) + edge.weight);
                        minHeap.offer(new Node(edge.dest, distances.get(edge.dest)));
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (distances.get(i) == Integer.MAX_VALUE) {
                distances.remove(i);
            }
        }
        return distances;
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