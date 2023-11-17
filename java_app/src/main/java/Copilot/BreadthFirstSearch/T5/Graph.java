package Copilot.BreadthFirstSearch.T5;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;
    private int[] parent;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
            parent[i] = -1;
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].addFirst(destination);
        adjacencyList[destination].addFirst(source);
    }

    public int[] bfs(int sourceVertex) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();
            for (int i : adjacencyList[currentVertex]) {
                if (!visited[i]) {
                    visited[i] = true;
                    parent[i] = currentVertex;
                    queue.add(i);
                }
            }
        }
        return parent;
    }
}