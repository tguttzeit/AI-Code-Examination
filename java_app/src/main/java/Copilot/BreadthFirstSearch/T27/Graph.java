package Copilot.BreadthFirstSearch.T27;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for(int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int sourceVertex, int destinationVertex) {
        adjacencyList[sourceVertex].add(destinationVertex);
    }
    
    public int[] bfs(int sourceVertex) {
        int[] parent = new int[vertices];
        for(int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(sourceVertex);
        visited[sourceVertex] = true;
        while(!queue.isEmpty()) {
            int currentVertex = queue.remove();
            Iterator<Integer> i = adjacencyList[currentVertex].listIterator();
            while(i.hasNext()) {
                int adjacentVertex = i.next();
                if(!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    parent[adjacentVertex] = currentVertex;
                    queue.add(adjacentVertex);
                }
            }
        }
        return parent;
    }
}