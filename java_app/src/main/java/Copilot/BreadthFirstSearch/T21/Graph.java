package Copilot.BreadthFirstSearch.T21;

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
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int current = queue.remove();
            for (int i = 0; i < adjMatrix[current].length; i++) {
                if (adjMatrix[current][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    parent[i] = current;
                    queue.add(i);
                }
            }
        }

        return parent;
    }
}