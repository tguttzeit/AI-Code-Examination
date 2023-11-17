package Copilot.BreadthFirstSearch.T41;

import java.util.*;

public class Graph{
    // Attributes
    private int vertices;
    private int[][] adjMatrix;
    
    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjMatrix = new int[vertices][vertices];
    }
    
    // Adds an edge between two vertices
    public void addEdge(int v1, int v2) {
        adjMatrix[v1][v2] = 1;
        adjMatrix[v2][v1] = 1;
    }
    
    // Performs a breadth first search from the source vertex
    public int[] bfs(int sourceVertex) {
        int[] parents = new int[vertices];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = -1;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        
        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();
            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    parents[i] = currentVertex;
                    queue.add(i);
                }
            }
        }
        
        return parents;
    }
}