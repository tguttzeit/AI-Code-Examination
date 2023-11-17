package Copilot.Dijkstra.T41;

import java.util.*;

public class Dijkstra {
    public static class Edge{
        public int source;
        public int dest;
        public int weight;

        public Edge(int source, int dest, int weight){
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static class Node{
        public int vertex;
        public int weight;
        public Node(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    private final List<Edge> edges;
    private final int n;
    private final Map<Integer, List<Node>> graph;
    public Dijkstra(List<Edge> edges, int n){
        this.edges = edges;
        this.n = n;
        graph = new HashMap<>();
        for(Edge e : edges){
            if(!graph.containsKey(e.source)){
                graph.put(e.source, new ArrayList<>());
            }
            graph.get(e.source).add(new Node(e.dest, e.weight));
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source){
        Map<Integer, Integer> result = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(source, 0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(result.containsKey(cur.vertex)){
                continue;
            }
            result.put(cur.vertex, cur.weight);
            if(!graph.containsKey(cur.vertex)){
                continue;
            }
            for(Node nei : graph.get(cur.vertex)){
                if(!result.containsKey(nei.vertex)){
                    pq.offer(new Node(nei.vertex, nei.weight + cur.weight));
                }
            }
        }
        return result;
    }



}