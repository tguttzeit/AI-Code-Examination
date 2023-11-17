package Copilot.Dijkstra.T47;

import java.util.*;

public class Dijkstra {
    public List<Edge> edges;
    public int n;
    public Dijkstra(List<Edge> edges, int n){
        this.edges = edges;
        this.n = n;
    }
    public Map<Integer, Integer> findShortestPaths(int source){
        Map<Integer, Integer> result = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        minHeap.offer(new Node(source, 0));
        Set<Integer> visited = new HashSet<>();
        while(!minHeap.isEmpty()){
            Node curr = minHeap.poll();
            if(visited.contains(curr.vertex)){
                continue;
            }
            result.put(curr.vertex, curr.weight);
            visited.add(curr.vertex);
            for(Edge edge : edges){
                if(edge.source == curr.vertex && !visited.contains(edge.dest)){
                    minHeap.offer(new Node(edge.dest, curr.weight + edge.weight));
                }
            }
        }
        return result;
    }
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

}