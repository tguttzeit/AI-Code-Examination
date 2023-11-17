package Copilot.BreadthFirstSearch.T28;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adjacencyList[];

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
        adjacencyList[i] = new LinkedList<>();
        }
    }

    public int[] bfs(int sourceVertex) {
        int[] parents = new int[vertices];
        for (int i = 0; i < vertices; i++) {
        parents[i] = -1;
        }

        boolean[] visited = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[sourceVertex] = true;
        queue.add(sourceVertex);

        while (queue.size() != 0) {
        sourceVertex = queue.poll();
        Iterator<Integer> i = adjacencyList[sourceVertex].listIterator();

        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
            visited[n] = true;
            parents[n] = sourceVertex;
            queue.add(n);
            }
        }
        }
        return parents;
    }

    public void addEdge(int sourceVertex, int destinationVertex) {
        adjacencyList[sourceVertex].add(destinationVertex);
    }
}