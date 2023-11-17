package ChatGPT.BreadthFirstSearch.T19;

import java.util.*;

class Graph {
    private int vertices;
    private List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public int[] bfs(int sourceVertex) {
        int[] parentNodes = new int[vertices];
        Arrays.fill(parentNodes, -1);

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[sourceVertex] = true;
        queue.offer(sourceVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();

            for (int neighbor : adjList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parentNodes[neighbor] = currentVertex;
                    queue.offer(neighbor);
                }
            }
        }

        return parentNodes;
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination);
        adjList.get(destination).add(source); // For undirected graph
    }

}
