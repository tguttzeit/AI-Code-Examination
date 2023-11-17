package Copilot.BreadthFirstSearch.T16;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adjListArray[];
    
    Graph(int vertices) {
        this.vertices = vertices;
        adjListArray = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjListArray[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int src, int dest) {
        adjListArray[src].addLast(dest);
    }
    
    public int[] bfs(int sourceVertex) {
        int[] parent = new int[this.vertices];
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[this.vertices];
        visited[sourceVertex] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(sourceVertex);
        while(!queue.isEmpty()) {
            int vertex = queue.poll();
            for (int adjVertex : adjListArray[vertex]) {
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    parent[adjVertex] = vertex;
                    queue.add(adjVertex);
                }
            }
        }
        return parent;
    }
}