package Copilot.Dijkstra.T4;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> result = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        Map<Integer, Integer> weightMap = new HashMap<>();
        Map<Integer, List<Edge>> graph = buildGraph(edges, n);
        minHeap.offer(new Node(source, 0));
        weightMap.put(source, 0);
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            int curWeight = cur.weight;
            int curVertex = cur.vertex;
            if (weightMap.containsKey(curVertex)) {
                continue;
            }
            weightMap.put(curVertex, curWeight);
            result.put(curVertex, curWeight);
            List<Edge> nextEdges = graph.get(curVertex);
            for (Edge edge : nextEdges) {
                if (!weightMap.containsKey(edge.dest)) {
                    minHeap.offer(new Node(edge.dest, curWeight + edge.weight));
                }
            }
        }
        return result;
    }

    private Map<Integer, List<Edge>> buildGraph(List<Edge> edges, int n) {
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (Edge edge : edges) {
            int source = edge.source;
            int dest = edge.dest;
            int weight = edge.weight;
            graph.get(source).add(new Edge(source, dest, weight));
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