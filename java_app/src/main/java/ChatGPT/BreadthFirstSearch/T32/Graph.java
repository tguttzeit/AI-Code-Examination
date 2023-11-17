package ChatGPT.BreadthFirstSearch.T32;

import java.util.*;

public class Graph {
    private int vertices;
    private List<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source); // Assuming an undirected graph
    }

    public int[] bfs(int sourceVertex) {
        int[] parentNodes = new int[vertices];
        Arrays.fill(parentNodes, -1);

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];

        queue.add(sourceVertex);
        visited[sourceVertex] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int neighbor : adjacencyList[currentVertex]) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    parentNodes[neighbor] = currentVertex;
                }
            }
        }

        return parentNodes;
    }
}
