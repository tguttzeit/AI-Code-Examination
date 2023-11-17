package Copilot.FloydWarshall.T15;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    int[][] dist;
  int[][] next;
  int nodes;
  public FloydWarshall(int nodes) {
    this.nodes = nodes;
    dist = new int[nodes][nodes];
    next = new int[nodes][nodes];
    for (int i = 0; i < nodes; i++) {
      for (int j = 0; j < nodes; j++) {
        dist[i][j] = Integer.MAX_VALUE;
        next[i][j] = -1;
      }
    }
  }
  public void addEdge(int source, int dest, int weight) {
    dist[source][dest] = weight;
    next[source][dest] = dest;
  }
  public List<Integer> path(int source, int dest) {
    if (dist[source][dest] == Integer.MAX_VALUE) {
      return null;
    }
    List<Integer> result = new ArrayList<>();
    result.add(source);
    while (source != dest) {
      source = next[source][dest];
      result.add(source);
    }
    return result;
  }
  public void run() {
    for (int k = 0; k < nodes; k++) {
      for (int i = 0; i < nodes; i++) {
        for (int j = 0; j < nodes; j++) {
          if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k] + dist[k][j] < dist[i][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
            next[i][j] = next[i][k];
          }
        }
      }
    }
  }
}
