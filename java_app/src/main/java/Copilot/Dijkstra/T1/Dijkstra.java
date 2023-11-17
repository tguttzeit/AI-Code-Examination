package Copilot.Dijkstra.T1;

import java.util.*;

public class Dijkstra {
    public List<Edge> edges;
    public int n;
    public Map<Integer, Integer> shortestPaths;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.shortestPaths = new HashMap<>();
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, List<Node>> graph = buildGraph();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.offer(new Node(source, 0));
        boolean[] visited = new boolean[n];
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if (visited[cur.vertex]) {
                continue;
            }
            visited[cur.vertex] = true;
            shortestPaths.put(cur.vertex, cur.weight);
            for (Node nei : graph.get(cur.vertex)) {
                if (!visited[nei.vertex]) {
                    minHeap.offer(new Node(nei.vertex, cur.weight + nei.weight));
                }
            }
        }
        return shortestPaths;
    }

    private Map<Integer, List<Node>> buildGraph() {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (Edge edge : edges) {
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
        return graph;
    }

    static class Edge {
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