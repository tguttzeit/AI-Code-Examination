package Copilot.BreadthFirstSearch.T14;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adjacencyListArray[];
    
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyListArray = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyListArray[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int sourceVertex, int destinationVertex) {
        adjacencyListArray[sourceVertex].add(destinationVertex);
    }
    
    public int[] bfs(int sourceVertex) {
        int[] parentNodes = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parentNodes[i] = -1;
        }
        
        boolean[] visited = new boolean[vertices];
        visited[sourceVertex] = true;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);
        
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            Iterator<Integer> iterator = adjacencyListArray[currentVertex].listIterator();
            while (iterator.hasNext()) {
                int vertex = iterator.next();
                if (!visited[vertex]) {
                    visited[vertex] = true;
                    parentNodes[vertex] = currentVertex;
                    queue.add(vertex);
                }
            }
        }
        
        return parentNodes;
    }
}