package ChatGPT.BreadthFirstSearch.T14;

import java.util.LinkedList;
import java.util.Queue;

class Graph {
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
    }

    public int[] bfs(int sourceVertex) {
        int[] parentNodes = new int[vertices];
        boolean[] visited = new boolean[vertices];

        // Initialize parent nodes with -1 and mark all vertices as unvisited
        for (int i = 0; i < vertices; i++) {
            parentNodes[i] = -1;
            visited[i] = false;
        }

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            // Iterate through all adjacent vertices of the current vertex
            for (Integer neighbor : adjacencyList[currentVertex]) {
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
