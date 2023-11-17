package Copilot.BreadthFirstSearch.T38;


import java.util.*;

public class Graph{
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
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }
    
    public int[] bfs(int sourceVertex) {
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[sourceVertex] = true;
        parent[sourceVertex] = -1;
        queue.add(sourceVertex);
        
        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();
            LinkedList<Integer> adjacents = adjacencyList[currentVertex];
            
            for (int i = 0; i < adjacents.size(); i++) {
                int adjacent = adjacents.get(i);
                
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    parent[adjacent] = currentVertex;
                    queue.add(adjacent);
                }
            }
        }
        
        return parent;
    }
}