package Copilot.BreadthFirstSearch.T18;

import java.util.*;

public class Graph {
    private int vertices;
  private int[][] adjacencyMatrix;
  private int[] parent;

  public Graph(int vertices) {
    this.vertices = vertices;
    this.adjacencyMatrix = new int[vertices][vertices];
    this.parent = new int[vertices];
    for (int i = 0; i < vertices; i++) {
      parent[i] = -1;
    }
  }

  public void addEdge(int sourceVertex, int targetVertex) {
    this.adjacencyMatrix[sourceVertex][targetVertex] = 1;
    this.adjacencyMatrix[targetVertex][sourceVertex] = 1;
  }

  public int[] bfs(int sourceVertex) {
    boolean[] visited = new boolean[vertices];
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(sourceVertex);
    visited[sourceVertex] = true;

    while (!queue.isEmpty()) {
      int currentVertex = queue.remove();
      for (int i = 0; i < vertices; i++) {
        if (adjacencyMatrix[currentVertex][i] == 1 && !visited[i]) {
          queue.add(i);
          visited[i] = true;
          parent[i] = currentVertex;
        }
      }
    }

    return parent;
  }
}