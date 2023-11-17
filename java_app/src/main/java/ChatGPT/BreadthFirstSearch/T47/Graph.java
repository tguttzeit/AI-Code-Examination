package ChatGPT.BreadthFirstSearch.T47;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public int[] bfs(int sourceVertex) {
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1; // Initialize all parent nodes to -1
        }

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbor : adjList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = currentVertex;
                    queue.add(neighbor);
                }
            }
        }
        
        return parent;
    }

    public void addEdge(int vertex1, int vertex2) {
        adjList[vertex1].add(vertex2);
        adjList[vertex2].add(vertex1); // If it's an undirected graph
    }
}
