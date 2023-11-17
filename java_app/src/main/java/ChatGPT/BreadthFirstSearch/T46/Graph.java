package ChatGPT.BreadthFirstSearch.T46;

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
        adjList[destination].add(source); // For an undirected graph
    }

    public int[] bfs(int sourceVertex) {
        int[] parentNodes = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parentNodes[i] = -1; // Initialize all parent nodes to -1
        }

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            LinkedList<Integer> neighbors = adjList[currentVertex];
            for (int neighbor : neighbors) {
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
