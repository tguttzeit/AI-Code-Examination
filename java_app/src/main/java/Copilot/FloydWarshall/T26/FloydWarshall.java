package Copilot.FloydWarshall.T26;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int nodes;
    private int[][] dist;
    private int[][] next;
    private boolean hasRun = false;
    private static final int INF = 1000000000;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                dist[i][j] = INF;
                next[i][j] = -1;
            }
        }
        for (int i = 0; i < nodes; i++) {
            dist[i][i] = 0;
            next[i][i] = i;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (!hasRun) {
            return null;
        }
        List<Integer> path = new ArrayList<>();
        if (dist[source][dest] == INF) {
            return path;
        }
        path.add(source);
        while (source != dest) {
            source = next[source][dest];
            path.add(source);
        }
        return path;
    }

    public void run() {
        if (hasRun) {
            return;
        }
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        hasRun = true;
    }
}
