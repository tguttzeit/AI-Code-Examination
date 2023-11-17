package Copilot.BreadthFirstSearch.T50;

import java.util.*;

public class Graph{
    private int vertices;
    private int[][] adjacencyMatrix;
    private int[] parent;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
        this.parent = new int[vertices];
    }
    
    public int[] bfs(int sourceVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);
        visited[sourceVertex] = true;
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                    queue.add(i);
                    parent[i] = vertex;
                    visited[i] = true;
                }
            }
        }
        return parent;
    }
    
    public void addEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }
}