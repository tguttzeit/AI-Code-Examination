package Copilot.Dijkstra.T38;

import java.util.*;

public class Dijkstra {
    private List<Edge> edges;
    private int n;
    private int[] dist;
    private boolean[] visited;
    private int[] prev;
    private int s;
    private int e;

    public Dijkstra(List<Edge> edges, int n) {
        this.edges = edges;
        this.n = n;
        this.dist = new int[n];
        this.visited = new boolean[n];
        this.prev = new int[n];
    }

    public Map<Integer, Integer> findShortestPaths(int source) {
        s = source;
        e = source;
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;
        while (e != -1) {
            visited[e] = true;
            for (Edge edge : edges) {
                if (edge.source == e) {
                    if (dist[edge.dest] > dist[e] + edge.weight) {
                        dist[edge.dest] = dist[e] + edge.weight;
                        prev[edge.dest] = e;
                    }
                }
            }
            e = findMin();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                map.put(i, dist[i]);
            }
        }
        return map;
    }

    private int findMin() {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
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