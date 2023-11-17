package Copilot.Dijkstra.T39;

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
    private List<Edge> edges;
    private int n;
    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
    }
    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, List<Node>> graph = new HashMap<>();
        for (Edge edge : edges) {
            if (!graph.containsKey(edge.source)) {
                graph.put(edge.source, new ArrayList<Node>());
            }
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }
        Map<Integer, Integer> distance = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.weight == n2.weight) {
                    return 0;
                }
                return n1.weight < n2.weight ? -1 : 1;
            }
        });
        pq.offer(new Node(source, 0));
        distance.put(source, 0);
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            for (Node nei : graph.get(cur.vertex)) {
                if (!distance.containsKey(nei.vertex) || distance.get(nei.vertex) > cur.weight + nei.weight) {
                    distance.put(nei.vertex, cur.weight + nei.weight);
                    pq.offer(new Node(nei.vertex, cur.weight + nei.weight));
                }
            }
        }
        return distance;
    }

}