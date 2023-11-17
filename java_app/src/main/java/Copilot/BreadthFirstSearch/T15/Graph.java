package Copilot.BreadthFirstSearch.T15;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjList;
    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int source, int destination) {
        adjList[source].addFirst(destination);
        adjList[destination].addFirst(source);
    }
    public int[] bfs(int sourceVertex) {
        int[] parents = new int[vertices];
        Arrays.fill(parents, -1);
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);
        visited[sourceVertex] = true;
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbor : adjList[currentVertex]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    parents[neighbor] = currentVertex;
                }
            }
        }
        return parents;
    }
}