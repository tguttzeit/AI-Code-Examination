package ChatGPT.BreadthFirstSearch.T16;

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

    public void addEdge(int source, int destination) {
        if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
            adjList[source].add(destination);
        } else {
            throw new IllegalArgumentException("Invalid vertices");
        }
    }

    public int[] bfs(int sourceVertex) {
        int[] parent = new int[vertices];
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = -1; // Initialize parent array with -1
            visited[i] = false; // Mark all vertices as not visited
        }

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

}
