package Copilot.Dijkstra.T48;

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
                graph.put(edge.source, new ArrayList<>());
            }
            graph.get(edge.source).add(new Node(edge.dest, edge.weight));
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 0; i < n; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }
        dist.put(source, 0);

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.weight > dist.get(cur.vertex)) {
                continue;
            }
            if (!graph.containsKey(cur.vertex)) {
                continue;
            }
            for (Node nei : graph.get(cur.vertex)) {
                if (cur.weight + nei.weight < dist.get(nei.vertex)) {
                    dist.put(nei.vertex, cur.weight + nei.weight);
                    pq.offer(new Node(nei.vertex, dist.get(nei.vertex)));
                }
            }
        }
        return dist;
    }



}