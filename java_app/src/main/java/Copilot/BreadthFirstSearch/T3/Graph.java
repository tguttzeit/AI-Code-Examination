package Copilot.BreadthFirstSearch.T3;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
        adjacencyList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
        adjacencyList[destination].add(source);
    }

    public int[] bfs(int sourceVertex) {
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[sourceVertex] = true;
        queue.offer(sourceVertex);

        while (!queue.isEmpty()) {
        int currentVertex = queue.poll();

        Iterator<Integer> iterator = adjacencyList[currentVertex].iterator();
        while (iterator.hasNext()) {
            int adjacentVertex = iterator.next();
            if (!visited[adjacentVertex]) {
            visited[adjacentVertex] = true;
            parent[adjacentVertex] = currentVertex;
            queue.offer(adjacentVertex);
            }
        }
        }
        return parent;
    }
}