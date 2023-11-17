package Copilot.BreadthFirstSearch.T37;

import java.util.*;

public class Graph{
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int source, int destination) {
        adjacencyList[source].addFirst(destination);
        adjacencyList[destination].addFirst(source);
    }
    
    public int[] bfs(int sourceVertex) {
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        Queue<Integer> queue = new LinkedList<Integer>();
        
        visited[sourceVertex] = true;
        queue.offer(sourceVertex);
        parent[sourceVertex] = -1;
        
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            
            for (int i = 0; i < adjacencyList[currentVertex].size(); i++) {
                int adjacentVertex = adjacencyList[currentVertex].get(i);
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    queue.offer(adjacentVertex);
                    parent[adjacentVertex] = currentVertex;
                }
            }
        }
        return parent;
    }
}