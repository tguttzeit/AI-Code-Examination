package Copilot.Dijkstra.T30;

import java.util.*;

public class Dijkstra {
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
    public List<Edge>[] edges;
    public int n;
    public int[] distance;
    public Set<Integer> visited;
    public PriorityQueue<Node> minHeap;
    public Map<Integer, Integer> shortestPath;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            this.edges[i] = new ArrayList<>();
        }
        this.n = n;
        this.distance = new int[n];
        this.visited = new HashSet<>();
        this.minHeap = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        this.shortestPath = new HashMap<>();
        for (Edge edge : edges) {
            this.edges[edge.source].add(edge);
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        minHeap.offer(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if (visited.contains(cur.vertex)) {
                continue;
            }
            visited.add(cur.vertex);
            shortestPath.put(cur.vertex, cur.weight);
            for (Edge edge : edges[cur.vertex]) {
                if (!visited.contains(edge.dest) && cur.weight + edge.weight < distance[edge.dest]) {
                    distance[edge.dest] = cur.weight + edge.weight;
                    minHeap.offer(new Node(edge.dest, distance[edge.dest]));
                }
            }
        }
        return shortestPath;
    }


}