package ChatGPT.BreadthFirstSearch.T45;

import java.util.*;

public class Graph {
    private int vertices;
    private List<List<Integer>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        if (source >= 0 && source < vertices && destination >= 0 && destination < vertices) {
            adjacencyList.get(source).add(destination);
            // For an undirected graph, you can add the reverse edge as well.
            // adjacencyList.get(destination).add(source);
        } else {
            throw new IllegalArgumentException("Invalid vertex values");
        }
    }

    public int[] bfs(int sourceVertex) {
        if (sourceVertex < 0 || sourceVertex >= vertices) {
            throw new IllegalArgumentException("Invalid source vertex");
        }

        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sourceVertex);
        parent[sourceVertex] = sourceVertex; // The source has no parent, so set it to itself.

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (parent[neighbor] == -1) {
                    parent[neighbor] = currentVertex;
                    queue.offer(neighbor);
                }
            }
        }

        return parent;
    }
}
