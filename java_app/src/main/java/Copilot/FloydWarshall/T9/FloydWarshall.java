package Copilot.FloydWarshall.T9;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
    private int[][] next;
    private int nodes;
    private boolean ran;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];
        ran = false;
    }

    public void addEdge(int source, int dest, int weight) {
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (!ran) run();
        if (dist[source][dest] == Integer.MAX_VALUE) return null;
        List<Integer> path = new ArrayList<>();
        int curr = source;
        while (curr != dest) {
            path.add(curr);
            curr = next[curr][dest];
        }
        path.add(curr);
        return path;
    }

    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        ran = true;
    }
}
