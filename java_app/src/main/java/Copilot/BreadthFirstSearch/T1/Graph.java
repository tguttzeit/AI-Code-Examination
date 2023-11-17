package Copilot.BreadthFirstSearch.T1;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adjacencyList[];
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }
    public int[] bfs(int sourceVertex) {
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        parent[sourceVertex] = -1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < adjacencyList[current].size(); i++) {
                int neighbour = adjacencyList[current].get(i);
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                    parent[neighbour] = current;
                }
            }
        }
        return parent;
    }
}
