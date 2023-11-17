package ChatGPT.BreadthFirstSearch.T27;

import java.util.*;

public class Graph {
    private int vertices;
    private List<List<Integer>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            this.adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source); // If it's an undirected graph
        } else {
            throw new IllegalArgumentException("Invalid vertex");
        }
    }

    public int[] bfs(int sourceVertex) {
        if (sourceVertex < 0 || sourceVertex >= vertices) {
            throw new IllegalArgumentException("Invalid source vertex");
        }

        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(sourceVertex);
        parent[sourceVertex] = sourceVertex;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (parent[neighbor] == -1) {
                    queue.add(neighbor);
                    parent[neighbor] = currentVertex;
                }
            }
        }

        return parent;
    }
}
