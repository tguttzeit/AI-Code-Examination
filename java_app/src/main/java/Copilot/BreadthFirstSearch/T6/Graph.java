package Copilot.BreadthFirstSearch.T6;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public int[] bfs(int sourceVertex) {
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[sourceVertex] = true;
        queue.offer(sourceVertex);
        parent[sourceVertex] = -1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < adjacencyList[current].size(); i++) {
                int neighbor = adjacencyList[current].get(i);
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    parent[neighbor] = current;
                }
            }
        }
        return parent;
    }
}