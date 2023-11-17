package ChatGPT.BreadthFirstSearch.T43;

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
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // For undirected graph
    }

    public int[] bfs(int sourceVertex) {
        int[] parentNodes = new int[vertices];
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            parentNodes[i] = -1; // Initialize parent nodes to -1
            visited[i] = false;  // Mark all vertices as not visited
        }

        Queue<Integer> queue = new LinkedList<>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int adjacentVertex : adjacencyList[currentVertex]) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    parentNodes[adjacentVertex] = currentVertex;
                    queue.add(adjacentVertex);
                }
            }
        }

        return parentNodes;
    }
}
