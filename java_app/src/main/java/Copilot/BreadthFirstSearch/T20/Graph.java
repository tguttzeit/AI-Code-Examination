package Copilot.BreadthFirstSearch.T20;

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

  public int[] bfs(int sourceVertex) {
      int[] parents = new int[vertices];
      for (int i = 0; i < vertices; i++) {
          parents[i] = -1;
      }
      boolean[] visited = new boolean[vertices];
      LinkedList<Integer> queue = new LinkedList<Integer>();
      visited[sourceVertex] = true;
      queue.add(sourceVertex);
      while (queue.size() != 0) {
          int current = queue.poll();
          LinkedList<Integer> neighbours = adjacencyList[current];
          for (int i = 0; i < neighbours.size(); i++) {
              int neighbour = neighbours.get(i);
              if (!visited[neighbour]) {
                  visited[neighbour] = true;
                  queue.add(neighbour);
                  parents[neighbour] = current;
              }
          }
      }
      return parents;
  }

  public void addEdge(int source, int destination) {
      adjacencyList[source].add(destination);
  }
}