package Copilot.BreadthFirstSearch.T8;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adjacencyListArray[];

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyListArray = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adjacencyListArray[sourceVertex].add(destinationVertex);
    }

    public int[] bfs(int sourceVertex) {
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }

        boolean[] visited = new boolean[vertices];
        visited[sourceVertex] = true;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int adjacentVertex : adjacencyListArray[currentVertex]) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    parent[adjacentVertex] = currentVertex;
                    queue.add(adjacentVertex);
                }
            }
        }

        return parent;
    }
}