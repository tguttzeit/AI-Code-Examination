package Copilot.BreadthFirstSearch.T23;

import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;
  
    public Graph(int vertices) {
      this.vertices = vertices;
      this.adjacencyList = new LinkedList[vertices];
      for (int i = 0; i < vertices; i++) {
        this.adjacencyList[i] = new LinkedList<Integer>();
      }
    }
  
    public void addEdge(int source, int destination) {
      this.adjacencyList[source].add(destination);
    }
  
    public int[] bfs(int sourceVertex) {
      int[] parent = new int[this.vertices];
      for (int i = 0; i < this.vertices; i++) {
        parent[i] = -1;
      }
      Queue<Integer> queue = new LinkedList<Integer>();
      queue.add(sourceVertex);
      parent[sourceVertex] = sourceVertex;
      while (!queue.isEmpty()) {
        int currentVertex = queue.remove();
        Iterator<Integer> iterator = this.adjacencyList[currentVertex].iterator();
        while (iterator.hasNext()) {
          int adjacent = iterator.next();
          if (parent[adjacent] == -1) {
            queue.add(adjacent);
            parent[adjacent] = currentVertex;
          }
        }
      }
      return parent;
    }
}