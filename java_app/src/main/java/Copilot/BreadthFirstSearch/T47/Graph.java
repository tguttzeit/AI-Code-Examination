package Copilot.BreadthFirstSearch.T47;

import java.util.*;

public class Graph{
    private int vertices;
    private LinkedList<Integer> adjacencyList[];
    
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        
        for(int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<Integer>();
        }
    }
    
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }
    
    public int[] bfs(int sourceVertex) {
        int[] parents = new int[vertices];
        for(int i = 0; i < vertices; i++) {
            parents[i] = -1;
        }
        
        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        
        while(queue.size() != 0) {
            sourceVertex = queue.poll();
            Iterator<Integer> i = adjacencyList[sourceVertex].listIterator();
            while(i.hasNext()) {
                int nextVertex = i.next();
                if(!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                    parents[nextVertex] = sourceVertex;
                }
            }
        }
        return parents;
    }
}