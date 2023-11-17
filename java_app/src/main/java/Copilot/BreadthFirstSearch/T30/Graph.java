package Copilot.BreadthFirstSearch.T30;

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

    public void bfs(int sourceVertex) {
        int[] parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }

        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        while (queue.size() != 0) {
            int vertex = queue.poll();
            for (int i = 0; i < adjacencyList[vertex].size(); i++) {
                if (!visited[adjacencyList[vertex].get(i)]) {
                    visited[adjacencyList[vertex].get(i)] = true;
                    parent[adjacencyList[vertex].get(i)] = vertex;
                    queue.add(adjacencyList[vertex].get(i));
                }
            }
        }
    }

    public void addEdge(int v1, int v2) {
        adjacencyList[v1].add(v2);
    }
}