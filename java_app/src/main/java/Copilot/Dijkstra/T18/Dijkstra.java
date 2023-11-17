package Copilot.Dijkstra.T18;

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

    private int n;
    private List<Edge>[] edges;

    public Dijkstra(List<Edge> edges, int n){
        this.n = n;
        this.edges = new List[n];
        for(int i = 0; i < n; i++){
            this.edges[i] = new ArrayList<>();
        }
        for(Edge edge : edges){
            this.edges[edge.source].add(edge);
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source){
        Map<Integer, Integer> result = new HashMap<>();
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.offer(new Node(source, 0));
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(visited[node.vertex]){
                continue;
            }
            visited[node.vertex] = true;
            result.put(node.vertex, node.weight);
            for(Edge edge : edges[node.vertex]){
                if(!visited[edge.dest]){
                    pq.offer(new Node(edge.dest, node.weight + edge.weight));
                }
            }
        }
        return result;
    }


}