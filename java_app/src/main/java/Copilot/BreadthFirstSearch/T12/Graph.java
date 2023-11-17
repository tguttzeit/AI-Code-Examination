package Copilot.BreadthFirstSearch.T12;

import java.util.*;

public class Graph {
    private int vertices;
    private int[][] adjacencyMatrix;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }
    
    public int[] bfs(int sourceVertex) {
        int[] parents = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parents[i] = -1;
        }
        parents[sourceVertex] = sourceVertex;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && parents[i] == -1) {
                    parents[i] = vertex;
                    queue.add(i);
                }
            }
        }
        return parents;
    }
    
    public void addEdge(int sourceVertex, int destinationVertex) {
        adjacencyMatrix[sourceVertex][destinationVertex] = 1;
        adjacencyMatrix[destinationVertex][sourceVertex] = 1;
    }
}