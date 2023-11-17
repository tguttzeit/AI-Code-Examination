package Copilot.Dijkstra.T49;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;
    private List<Node>[] graph;
    private boolean[] visited;
    private int[] dist;
    private int[] prev;
    private PriorityQueue<Node> pq;
    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.graph = new List[n];
        this.visited = new boolean[n];
        this.dist = new int[n];
        this.prev = new int[n];
        this.pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        for (int i = 0; i < n; i++) {
            this.graph[i] = new ArrayList<>();
            this.dist[i] = Integer.MAX_VALUE;
            this.prev[i] = -1;
        }
        for (Edge edge : edges) {
            this.graph[edge.source].add(new Node(edge.dest, edge.weight));
        }
    }
    public Map<Integer, Integer> findShortestPaths(int source) {
        Map<Integer, Integer> res = new HashMap<>();
        pq.offer(new Node(source, 0));
        dist[source] = 0;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curNode = cur.vertex;
            if (visited[curNode]) {
                continue;
            }
            visited[curNode] = true;
            res.put(curNode, dist[curNode]);
            for (Node next : graph[curNode]) {
                if (visited[next.vertex]) {
                    continue;
                }
                if (dist[curNode] + next.weight < dist[next.vertex]) {
                    dist[next.vertex] = dist[curNode] + next.weight;
                    prev[next.vertex] = curNode;
                    pq.offer(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
        return res;
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