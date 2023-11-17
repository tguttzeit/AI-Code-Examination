package Copilot.BreadthFirstSearch.T44;

import java.util.*;

public class Graph{
    // Instance variables
    int vertices;
    // Adjacency List
    LinkedList<Integer>[] adjList;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        // initialize adjacency lists for all the vertices
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    
    // add edge from u to v
    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }
    
    public int[] bfs(int sourceVertex) {
        // BFS uses Queue data structure
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        int[] parent = new int[vertices];
        // initialize all parent nodes to -1
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }
        // mark current node as visited and enqueue it
        visited[sourceVertex] = true;
        q.offer(sourceVertex);
        while (!q.isEmpty()) {
            // dequeue a vertex from queue and print it
            int currentVertex = q.poll();
            // get all adjacent vertices of current vertex
            // if an adjacent vertex has not been visited, then mark it visited and enqueue it
            Iterator<Integer> it = adjList[currentVertex].listIterator();
            while (it.hasNext()) {
                int adjVertex = it.next();
                if (!visited[adjVertex]) {
                    visited[adjVertex] = true;
                    parent[adjVertex] = currentVertex;
                    q.offer(adjVertex);
                }
            }
        }
        return parent;
    }
}