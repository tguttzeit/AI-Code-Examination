package Copilot.BreadthFirstSearch.T35;

import java.util.*;

public class Graph {
    private int vertices;
    private int[][] adjMatrix;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }
    
    public int[] bfs(int sourceVertex) {
        int[] parents = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parents[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(sourceVertex);
        parents[sourceVertex] = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[vertex][i] == 1 && parents[i] == -1) {
                    queue.add(i);
                    parents[i] = vertex;
                }
            }
        }
        return parents;
    }
    
    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }
}