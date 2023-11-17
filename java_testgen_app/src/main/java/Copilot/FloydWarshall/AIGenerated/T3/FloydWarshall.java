package Copilot.FloydWarshall.AIGenerated.T3;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    int[][] dist;
    int[][] next;
    int nodes;
    boolean hasRun = false;

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
        for (int i = 0; i < nodes; i++) {
            dist[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (!hasRun) {
            run();
        }
        List<Integer> path = new ArrayList<>();
        if (dist[source][dest] == Integer.MAX_VALUE) {
            return path;
        }
        int cur = source;
        while (cur != dest) {
            path.add(cur);
            cur = next[cur][dest];
        }
        path.add(dest);
        return path;
    }

    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        hasRun = true;
    }
}
