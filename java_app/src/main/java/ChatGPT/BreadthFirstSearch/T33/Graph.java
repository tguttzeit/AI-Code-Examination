package ChatGPT.BreadthFirstSearch.T33;

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
            adjacencyList[destination].add(source); // If the graph is undirected
        } else {
            throw new IllegalArgumentException("Invalid vertex index");
        }
    }

    public int[] bfs(int sourceVertex) {
        int[] parentNodes = new int[vertices];
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        // Initialize parentNodes to -1 and mark all vertices as unvisited
        for (int i = 0; i < vertices; i++) {
            parentNodes[i] = -1;
            visited[i] = false;
        }

        visited[sourceVertex] = true;
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parentNodes[neighbor] = currentVertex;
                    queue.add(neighbor);
                }
            }
        }

        return parentNodes;
    }
}
