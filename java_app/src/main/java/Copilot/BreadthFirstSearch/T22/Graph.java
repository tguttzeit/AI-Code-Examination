package Copilot.BreadthFirstSearch.T22;

import java.util.*;

public class Graph {
    private int vertices;
    private int[][] adjacencyMatrix;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adjacencyMatrix[sourceVertex][destinationVertex] = 1;
        adjacencyMatrix[destinationVertex][sourceVertex] = 1;
    }

    public int[] bfs(int sourceVertex) {
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(sourceVertex);
        visited[sourceVertex] = true;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[current][i] == 1 && !visited[i]) {
                    parent[i] = current;
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        return parent;
    }
}