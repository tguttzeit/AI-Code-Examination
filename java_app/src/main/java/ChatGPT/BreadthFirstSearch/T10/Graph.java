package ChatGPT.BreadthFirstSearch.T10;

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
        adjList[source].add(destination);
        adjList[destination].add(source); // If it's an undirected graph
    }

    public int[] bfs(int sourceVertex) {
        int[] parent = new int[vertices];
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = -1; // Initialize parent array with -1
            visited[i] = false;
        }

        Queue<Integer> queue = new LinkedList<>();
        visited[sourceVertex] = true;
        queue.offer(sourceVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            LinkedList<Integer> neighbors = adjList[currentVertex];

            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = currentVertex;
                    queue.offer(neighbor);
                }
            }
        }

        return parent;
    }
}
