package Copilot.Dijkstra.T37;

import java.util.*;

public class Dijkstra {
    private final List<Edge> edges;
    private final int n;
    private Map<Integer, Integer> shortestPaths;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        shortestPaths = new HashMap<>();
        shortestPaths.put(source, 0);
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        pq.offer(new Node(source, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (visited.contains(curr.vertex)) {
                continue;
            }
            visited.add(curr.vertex);
            for (Edge edge : edges) {
                if (edge.source == curr.vertex && !visited.contains(edge.dest)) {
                    int newWeight = curr.weight + edge.weight;
                    if (!shortestPaths.containsKey(edge.dest) || newWeight < shortestPaths.get(edge.dest)) {
                        shortestPaths.put(edge.dest, newWeight);
                        pq.offer(new Node(edge.dest, newWeight));
                    }
                }
            }
        }
        return shortestPaths;
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