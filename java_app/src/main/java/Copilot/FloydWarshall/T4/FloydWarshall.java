package Copilot.FloydWarshall.T4;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    public int[][] graph;
    public int[][] path;
    public int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        graph = new int[nodes][nodes];
        path = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++)
                if (i == j) {
                    graph[i][j] = 0;
                    path[i][j] = j;
                } else {
                    graph[i][j] = Integer.MAX_VALUE;
                    path[i][j] = -1;
                }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        graph[source][dest] = weight;
    }

    public List<Integer> path(int source, int dest) {
        List<Integer> res = new ArrayList<>();
        int i = source;
        while (i != dest) {
            if (i == -1) {
                return null;
            }
            res.add(i);
            i = path[i][dest];
        }
        res.add(dest);
        return res;
    }

    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        path[i][j] = path[i][k];
                    }
                }
            }
        }
    }
}
