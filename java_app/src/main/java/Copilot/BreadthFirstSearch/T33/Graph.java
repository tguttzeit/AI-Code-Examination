package Copilot.BreadthFirstSearch.T33;

import java.util.*;

public class Graph {
    private int vertices;
    private int[][] adjacencyMatrix;
    private int[] parents;
    private Queue<Integer> queue;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
        parents = new int[vertices];
        queue = new LinkedList<>();
    }

    public int[] bfs(int sourceVertex) {
        for (int i = 0; i < vertices; i++) {
            parents[i] = -1;
        }
        queue.add(sourceVertex);
        parents[sourceVertex] = sourceVertex;
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[currentVertex][i] == 1 && parents[i] == -1) {
                    parents[i] = currentVertex;
                    queue.add(i);
                }
            }
        }
        return parents;
    }

    public void addEdge(int i, int j) {
        if (i >= 0 && i < vertices && j >= 0 && j < vertices) {
            adjacencyMatrix[i][j] = 1;
            adjacencyMatrix[j][i] = 1;
        }
    }
}