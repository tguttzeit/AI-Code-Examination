package Copilot.BreadthFirstSearch.T2;

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
        LinkedList<Integer> queue = new LinkedList<>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        while (queue.size() != 0) {
            sourceVertex = queue.poll();
            Iterator<Integer> i = adjListArray[sourceVertex].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    parents[n] = sourceVertex;
                    queue.add(n);
                }
            }
        }
        return parents;
    }
}

