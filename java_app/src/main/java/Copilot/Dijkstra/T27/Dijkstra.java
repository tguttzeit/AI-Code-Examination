package Copilot.Dijkstra.T27;

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

    private List<Edge>[] graph;
    private int n;
    private int[] distance;
    private int[] prev;
    private PriorityQueue<Node> pq;

    public Dijkstra(List<Edge> edges, int n){
        this.graph = new ArrayList[n];
        this.n = n;
        for(int i = 0; i < n; i++){
            this.graph[i] = new ArrayList<>();
        }
        for(Edge edge : edges){
            this.graph[edge.source].add(edge);
        }
    }

    public Map<Integer, Integer> findShortestPaths(int source){
        this.distance = new int[n];
        this.prev = new int[n];
        this.pq = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        Map<Integer, Integer> result = new HashMap<>();

        for(int i = 0; i < n; i++){
            this.distance[i] = Integer.MAX_VALUE;
            this.prev[i] = -1;
        }
        this.distance[source] = 0;
        this.pq.offer(new Node(source, 0));

        while(!this.pq.isEmpty()){
            Node node = this.pq.poll();
            int vertex = node.vertex;
            int weight = node.weight;

            if(weight > this.distance[vertex]){
                continue;
            }

            for(Edge edge : this.graph[vertex]){
                int newWeight = weight + edge.weight;
                if(newWeight < this.distance[edge.dest]){
                    this.distance[edge.dest] = newWeight;
                    this.prev[edge.dest] = vertex;
                    this.pq.offer(new Node(edge.dest, newWeight));
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(this.distance[i] == Integer.MAX_VALUE){
                continue;
            }
            result.put(i, this.distance[i]);
        }
        return result;
    }


}