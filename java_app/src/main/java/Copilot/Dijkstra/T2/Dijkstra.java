package Copilot.Dijkstra.T2;

import java.util.*;

public class Dijkstra {

    private List<Edge> edges;
    private int n;
    private List<Node> nodes;
    private Map<Integer, Integer> shortestPaths;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.nodes = new ArrayList<>();
        this.shortestPaths = new HashMap<>();
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i, Integer.MAX_VALUE));
        }
        nodes.get(source).weight = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(n, (a, b) -> a.weight - b.weight);
        minHeap.addAll(nodes);
        while (!minHeap.isEmpty()) {
            Node curr = minHeap.poll();
            shortestPaths.put(curr.vertex, curr.weight);
            for (Edge edge : edges) {
                if (edge.source == curr.vertex) {
                    int dest = edge.dest;
                    int weight = edge.weight;
                    if (curr.weight + weight < nodes.get(dest).weight) {
                        Node node = nodes.get(dest);
                        minHeap.remove(node);
                        node.weight = curr.weight + weight;
                        minHeap.offer(node);
                    }
                }
            }
        }
        return shortestPaths;
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