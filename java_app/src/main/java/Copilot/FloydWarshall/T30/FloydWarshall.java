package Copilot.FloydWarshall.T30;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] distance;
    private int[][] next;
    private int nodes;
    private boolean ran = false;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        distance = new int[nodes][nodes];
        next = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                distance[i][j] = Integer.MAX_VALUE;
                next[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        distance[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (!ran) {
            run();
        }
        if (distance[source][dest] == Integer.MAX_VALUE) {
            return null;
        }
        List<Integer> path = new ArrayList<>();
        int i = source;
        for (; i != dest; i = next[i][dest]) {
            if (i == -1) {
                return null;
            }
            path.add(i);
        }
        if (next[i][dest] == -1) {
            return null;
        }
        path.add(dest);
        return path;
    }

    public void run() {
        for (int i = 0; i < nodes; i++) {
            distance[i][i] = 0;
        }
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (distance[i][k] == Integer.MAX_VALUE || distance[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        ran = true;
    }
}
