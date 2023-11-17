package Copilot.BreadthFirstSearch.T39;


import java.util.*;

public class Graph{
    private int vertices;
    private int[][] adjMatrix;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjMatrix = new int[vertices][vertices];
    }
    
    public void addEdge(int vertex1, int vertex2) {
        adjMatrix[vertex1][vertex2] = 1;
        adjMatrix[vertex2][vertex1] = 1;
    }
    
    public int[] bfs(int sourceVertex) {
        int[] parent = new int[vertices];
        int[] visited = new int[vertices];
        Queue<Integer> q = new LinkedList<>();
        q.offer(sourceVertex);
        visited[sourceVertex] = 1;
        parent[sourceVertex] = -1;
        while(!q.isEmpty()) {
            int vertex = q.poll();
            for(int i = 0; i < vertices; i++) {
                if(adjMatrix[vertex][i] == 1 && visited[i] == 0) {
                    q.offer(i);
                    visited[i] = 1;
                    parent[i] = vertex;
                }
            }
        }
        return parent;
    }
}