package Copilot.FloydWarshall.T49;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    int[][] graph;
    int[][] dist;
    int[][] next;
    int nodes;
    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        graph = new int[nodes][nodes];
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                graph[i][j] = Integer.MAX_VALUE;
                dist[i][j] = Integer.MAX_VALUE;
                next[i][j] = -1;
            }
        }
    }
    public void addEdge(int source, int dest, int weight) {
        graph[source][dest] = weight;
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }
    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
    public List<Integer> path(int source, int dest) {
        List<Integer> path = new ArrayList<>();
        if (dist[source][dest] == Integer.MAX_VALUE) {
            return path;
        }
        path.add(source);
        while (source != dest) {
            source = next[source][dest];
            path.add(source);
        }
        return path;
    }
}
