package ChatGPT.BreadthFirstSearch.T17;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int vertices;
    private int[][] adjacencyMatrix;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }
    
    public int[] bfs(int sourceVertex) {
        int[] parentNodes = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parentNodes[i] = -1; // Initialize parent nodes to -1
        }

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[sourceVertex] = true;
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbor = 0; neighbor < vertices; neighbor++) {
                if (adjacencyMatrix[currentVertex][neighbor] == 1 && !visited[neighbor]) {
                    visited[neighbor] = true;
                    parentNodes[neighbor] = currentVertex;
                    queue.add(neighbor);
                }
            }
        }

        return parentNodes;
    }
    
    public void addEdge(int fromVertex, int toVertex) {
        if (fromVertex >= 0 && fromVertex < vertices && toVertex >= 0 && toVertex < vertices) {
            adjacencyMatrix[fromVertex][toVertex] = 1;
            adjacencyMatrix[toVertex][fromVertex] = 1; // Assuming an undirected graph
        }
    }
    
    
}
