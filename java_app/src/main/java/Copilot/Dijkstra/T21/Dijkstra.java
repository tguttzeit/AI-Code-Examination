package Copilot.Dijkstra.T21;

import java.util.*;

public class Dijkstra {

    private final List<Edge> edges;
    private final int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> distanceTo = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            distanceTo.put(i, Integer.MAX_VALUE);
        }
        distanceTo.put(source, 0);

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.weight > distanceTo.get(node.vertex)) {
                continue;
            }

            for (Edge edge : edges) {
                if (edge.source == node.vertex) {
                    int newWeight = node.weight + edge.weight;
                    if (newWeight < distanceTo.get(edge.dest)) {
                        distanceTo.put(edge.dest, newWeight);
                        pq.offer(new Node(edge.dest, newWeight));
                    }
                }
            }
        }

        distanceTo.remove(source);
        return distanceTo;
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