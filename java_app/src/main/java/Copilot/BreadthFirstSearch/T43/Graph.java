package Copilot.BreadthFirstSearch.T43;

import java.util.*;

public class Graph{
    private int vertices;
    private LinkedList<Integer>[] adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
        this.adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination) {
        this.adjList[source].addFirst(destination);
        this.adjList[destination].addFirst(source);
    }

    public int[] bfs(int sourceVertex) {
        int[] parent = new int[this.vertices];
        for (int i = 0; i < this.vertices; i++) {
        parent[i] = -1;
        }

        boolean[] visited = new boolean[this.vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);

        while (queue.size() != 0) {
        int currentVertex = queue.remove();
        Iterator<Integer> iter = this.adjList[currentVertex].listIterator();
        while (iter.hasNext()) {
            int adjVertex = iter.next();
            if (!visited[adjVertex]) {
            visited[adjVertex] = true;
            parent[adjVertex] = currentVertex;
            queue.add(adjVertex);
            }
        }
        }

        return parent;
    }
}