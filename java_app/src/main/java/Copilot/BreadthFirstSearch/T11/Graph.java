package Copilot.BreadthFirstSearch.T11;

import java.util.*;

public class Graph {
    int vertices;
    int[][] adjMatrix;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        adjMatrix = new int[vertices][vertices];
    }
    
    public void addEdge(int v1, int v2) {
        adjMatrix[v1][v2] = 1;
        adjMatrix[v2][v1] = 1;
    }
    
    public int[] bfs(int sourceVertex) {
        int[] parents = new int[vertices];
        parents[sourceVertex] = -1;
        Queue<Integer> q = new LinkedList<>();
        q.add(sourceVertex);
        while(!q.isEmpty()) {
            int current = q.remove();
            for(int i = 0; i < vertices; i++) {
                if(adjMatrix[current][i] == 1 && parents[i] == 0) {
                    parents[i] = current;
                    q.add(i);
                }
            }
        }
        return parents;
    }
}