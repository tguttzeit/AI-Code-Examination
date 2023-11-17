package Copilot.BreadthFirstSearch.T13;

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
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }
        
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            Iterator<Integer> iterator = adjListArray[vertex].listIterator();
            while (iterator.hasNext()) {
                int nextVertex = iterator.next();
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    parent[nextVertex] = vertex;
                    queue.add(nextVertex);
                }
            }
        }
        return parent;
    }
}