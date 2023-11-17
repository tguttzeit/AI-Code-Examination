package ChatGPT.BreadthFirstSearch.T22;

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
        // Add an edge between source and destination
        adjacencyList[source].add(destination);
        // For an undirected graph, you can add the reverse edge as well
        // adjacencyList[destination].add(source);
    }

    public int[] bfs(int sourceVertex) {
        int[] parentNodes = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parentNodes[i] = -1; // Initialize all parent nodes to -1
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];

        visited[sourceVertex] = true;
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int adjacentVertex : adjacencyList[currentVertex]) {
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    queue.add(adjacentVertex);
                    parentNodes[adjacentVertex] = currentVertex;
                }
            }
        }

        return parentNodes;
    }

}
