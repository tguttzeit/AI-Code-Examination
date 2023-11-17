package Copilot.FloydWarshall.T16;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int nodes;
    private int[][] dist;
    private int[][] next;
    private boolean isRun = false;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) { // Initialize next matrix
                if (i == j) {
                    next[i][j] = -1;
                } else {
                    next[i][j] = j;
                }
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        dist[source][dest] = weight;
    }

    public List<Integer> path(int source, int dest) {
        if (!isRun) {
            run();
        }
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

    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        isRun = true;
    }
}
