package Copilot.BreadthFirstSearch.T46;


import java.util.*;

public class Graph{
    private int vertices;
    private LinkedList<Integer> adjacencyList[];
    
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
        queue.add(sourceVertex);
        visited[sourceVertex] = true;
        parent[sourceVertex] = -1;
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int i = 0; i < adjacencyList[currentVertex].size(); i++) {
                int adjacentVertex = adjacencyList[currentVertex].get(i);
                if (!visited[adjacentVertex]) {
                    queue.add(adjacentVertex);
                    visited[adjacentVertex] = true;
                    parent[adjacentVertex] = currentVertex;
                }
            }
        }
        return parent;
    }
}