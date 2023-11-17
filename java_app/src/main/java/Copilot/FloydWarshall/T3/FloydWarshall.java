package Copilot.FloydWarshall.T3;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
    private int[][] next;
    private int nodes;
    private boolean solved;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++)
                dist[i][j] = Integer.MAX_VALUE / 2;
            dist[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public Integer[] path(int source, int dest) {
        if (!solved)
            run();
        if (dist[source][dest] == Integer.MAX_VALUE / 2)
            return null;
        Integer[] path = new Integer[nodes];
        int at = source;
        int index = 0;
        for (; at != dest; at = next[at][dest])
            path[index++] = at;
        path[index] = dest;
        return path;
    }

    public void run() {
        for (int k = 0; k < nodes; k++)
            for (int i = 0; i < nodes; i++)
                for (int j = 0; j < nodes; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
        solved = true;
    }
}
