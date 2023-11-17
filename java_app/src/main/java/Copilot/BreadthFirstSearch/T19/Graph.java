package Copilot.BreadthFirstSearch.T19;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adjListArray[];
    public Graph(int vertices) {
        this.vertices = vertices;
        adjListArray = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }
    public void addEdge(int src, int dest) {
        adjListArray[src].add(dest);
    }
    public int[] bfs(int sourceVertex) {
        int[] parents = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parents[i] = -1;
        }
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            LinkedList<Integer> adjList = adjListArray[currentVertex];
            for (int adjVertex : adjList) {
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    queue.add(adjVertex);
                    parents[adjVertex] = currentVertex;
                }
            }
        }
        return parents;
    }
}