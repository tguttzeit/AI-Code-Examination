package Copilot.Dijkstra.T34;

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
        PriorityQueue<Node> minHeap = new PriorityQueue<>(n, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.weight - n2.weight;
            }
        });
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Node>> graph = buildGraph();
        minHeap.offer(new Node(source, 0));
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            if (visited.contains(cur.vertex)) {
                continue;
            }
            visited.add(cur.vertex);
            result.put(cur.vertex, cur.weight);
            for (Node nei : graph.get(cur.vertex)) {
                if (!visited.contains(nei.vertex)) {
                    minHeap.offer(new Node(nei.vertex, nei.weight + cur.weight));
                }
            }
        }
        return result;
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