package Copilot.BreadthFirstSearch.T29;

import java.util.*;

public class Graph {
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
        adjacencyList[source].add(destination);
    }
    
    public int[] bfs(int sourceVertex) {
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
            parent[i] = -1;
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            LinkedList<Integer> adjacentVertices = adjacencyList[currentVertex];
            for (int i = 0; i < adjacentVertices.size(); i++) {
                int adjacentVertex = adjacentVertices.get(i);
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    parent[adjacentVertex] = currentVertex;
                    queue.add(adjacentVertex);
                }
            }
        }
        return parent;
    }
}