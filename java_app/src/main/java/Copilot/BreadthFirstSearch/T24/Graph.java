package Copilot.BreadthFirstSearch.T24;

import java.util.LinkedList;

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
    public void addEdge(int sourceVertex, int targetVertex) {
        adjacencyList[sourceVertex].add(targetVertex);
    }
    public int[] bfs(int sourceVertex) {
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        while (queue.size() != 0) {
            int currentVertex = queue.poll();
            for (int i = 0; i < adjacencyList[currentVertex].size(); i++) {
                int adjacentVertex = adjacencyList[currentVertex].get(i);
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