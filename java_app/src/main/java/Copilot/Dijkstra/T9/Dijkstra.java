package Copilot.Dijkstra.T9;

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
        Map<Integer, List<Node>> graph = buildGraph(edges, n);
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.weight < n2.weight) {
                    return -1;
                } else if (n1.weight > n2.weight) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        minHeap.offer(new Node(source, 0));
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if (result.containsKey(cur.vertex)) {
                continue;
            }
            result.put(cur.vertex, cur.weight);
            List<Node> neighbors = graph.get(cur.vertex);
            for (Node neighbor : neighbors) {
                if (!result.containsKey(neighbor.vertex)) {
                    minHeap.offer(new Node(neighbor.vertex, cur.weight + neighbor.weight));
                }
            }
        }
        return result;
    }

    private Map<Integer, List<Node>> buildGraph(List<Edge> edges, int n) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (Edge edge : edges) {
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
        return graph;
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