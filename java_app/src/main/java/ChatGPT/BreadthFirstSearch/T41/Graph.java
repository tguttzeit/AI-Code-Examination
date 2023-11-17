package ChatGPT.BreadthFirstSearch.T41;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
            adjacencyList[source].add(destination);
            adjacencyList[destination].add(source); // For undirected graph
        } else {
            throw new IllegalArgumentException("Invalid vertex index");
        }
    }

    public int[] bfs(int sourceVertex) {
        if (sourceVertex < 0 || sourceVertex >= vertices) {
            throw new IllegalArgumentException("Invalid source vertex");
        }

        int[] parentNodes = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parentNodes[i] = -1;
        }

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[sourceVertex] = true;
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    parentNodes[neighbor] = currentVertex;
                }
            }
        }

        return parentNodes;
    }
}
