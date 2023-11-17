package Copilot.FloydWarshall.T17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FloydWarshall {
    int nodes;
    int[][] dist;
    int[][] next;
    int[][] graph;
    int inf = Integer.MAX_VALUE;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];
        graph = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                graph[i][j] = inf;
                dist[i][j] = inf;
                next[i][j] = -1;
            }
            graph[i][i] = 0;
            dist[i][i] = 0;
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
                    if (dist[i][k] != inf && dist[k][j] != inf && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    public List<Integer> path(int source, int dest) {
        if (dist[source][dest] == inf) {
            return null;
        }
        List<Integer> path = new ArrayList<>();
        int cur = source;
        while (cur != dest) {
            path.add(cur);
            cur = next[cur][dest];
        }
        path.add(dest);
        return path;
    }
}
