package Copilot.Dijkstra.T25;

import java.util.*;

public class Dijkstra {

    List<Edge> edges;
    int n;
    public Dijkstra(List<Edge> edges, int n){
        this.edges = edges;
        this.n = n;
    }
    public Map<Integer, Integer> findShortestPaths(int source){
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Node>> graph = new HashMap<>();
        // build graph
        for (Edge e : edges) {
            if (!graph.containsKey(e.source)) {
                graph.put(e.source, new ArrayList<>());
            }
            graph.get(e.source).add(new Node(e.dest, e.weight));
        }
        // dijkstra
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        pq.offer(new Node(source, 0));
        Set<Integer> visited = new HashSet<>();
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited.contains(cur.vertex)) {
                continue;
            }
            visited.add(cur.vertex);
            map.put(cur.vertex, cur.weight);
            if (graph.containsKey(cur.vertex)) {
                for (Node nei : graph.get(cur.vertex)) {
                    if (!visited.contains(nei.vertex)) {
                        pq.offer(new Node(nei.vertex, cur.weight + nei.weight));
                    }
                }
            }
        }
        return map;
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