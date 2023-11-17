package Copilot.BreadthFirstSearch.T10;

import java.util.*;

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
    
    public void addEdge(int source, int destination) {
        adjacencyList[source].addFirst(destination);
        adjacencyList[destination].addFirst(source);
    }
    
    public int[] bfs(int sourceVertex) {
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            visited[i] = false;
            parent[i] = -1;
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        
        while (queue.size() != 0) {
            int current = queue.poll();
            
            for (int i = 0; i < adjacencyList[current].size(); i++) {
                int next = adjacencyList[current].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = current;
                    queue.add(next);
                }
            }
        }
        
        return parent;
    }

}