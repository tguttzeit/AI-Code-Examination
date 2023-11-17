package Copilot.BreadthFirstSearch.T25;

import java.util.*;

public class Graph {
    private int vertices;
    private int[][] adjMatrix;
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
        for (int i = 0; i < vertices; i++) {
            parents[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        queue.add(sourceVertex);
        visited[sourceVertex] = true;
        while (!queue.isEmpty()) {
            int current = queue.remove();
            for (int i = 0; i < vertices; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    queue.add(i);
                    parents[i] = current;
                    visited[i] = true;
                }
            }
        }
        return parents;
    }
}