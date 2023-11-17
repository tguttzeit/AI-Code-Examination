package ChatGPT.BreadthFirstSearch.T15;

import java.util.*;

public class Graph {
    private int vertices;
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            this.adjList.add(new ArrayList<>());
        }
    }

    public int[] bfs(int sourceVertex) {
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];

        queue.add(sourceVertex);
        visited[sourceVertex] = true;

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int neighbor : adjList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    parent[neighbor] = currentVertex;
                }
            }
        }

        return parent;
    }

    public void addEdge(int vertex1, int vertex2) {
        adjList.get(vertex1).add(vertex2);
        adjList.get(vertex2).add(vertex1);
    }

}
