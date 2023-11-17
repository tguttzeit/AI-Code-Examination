package Copilot.Dijkstra.T26;

import java.util.*;

public class Dijkstra {

    private List<Edge> edges;
    private int n;
    private Map<Integer, List<Node>> graph;
    private Map<Integer, Integer> dist;
    private Map<Integer, Integer> prev;
    private Set<Integer> visited;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.graph = new HashMap<>();
        this.dist = new HashMap<>();
        this.prev = new HashMap<>();
        this.visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            this.graph.put(i, new ArrayList<>());
            this.dist.put(i, Integer.MAX_VALUE);
            this.prev.put(i, null);
        }
        for (Edge e : edges) {
            this.graph.get(e.source).add(new Node(e.dest, e.weight));
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        this.dist.put(source, 0);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(source, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            visited.add(cur.vertex);
            if (dist.get(cur.vertex) < cur.weight) continue;
            for (Node nei : graph.get(cur.vertex)) {
                if (visited.contains(nei.vertex)) continue;
                int newDist = dist.get(cur.vertex) + nei.weight;
                if (newDist < dist.get(nei.vertex)) {
                    dist.put(nei.vertex, newDist);
                    prev.put(nei.vertex, cur.vertex);
                    pq.offer(new Node(nei.vertex, newDist));
                }
            }
        }
        return prev;
    }

    public class Edge {
        public int source;
        public int dest;
        public int weight;

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public class Node {
        public int vertex;
        public int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

}