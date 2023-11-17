package Copilot.BreadthFirstSearch.T31;

import java.util.*;

public class Graph{
    private int vertices;
    private LinkedList<Integer> adjacencyListArray[];
    
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyListArray = new LinkedList[vertices];
        
        for (int i = 0; i < vertices; i++) {
            this.adjacencyListArray[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int source, int destination) {
        this.adjacencyListArray[source].add(destination);
        this.adjacencyListArray[destination].add(source);
    }
    
    public int[] bfs(int sourceVertex) {
        int[] parent = new int[this.vertices];
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[this.vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sourceVertex);
        visited[sourceVertex] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : this.adjacencyListArray[node]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                    parent[neighbor] = node;
                }
            }
        }
        return parent;
    }
}