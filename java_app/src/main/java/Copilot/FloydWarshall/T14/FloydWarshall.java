package Copilot.FloydWarshall.T14;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int nodes;
    private int[][] distance;
    private int[][] next;
    private boolean hasNegativeCycle;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.distance = new int[nodes][nodes];
        this.next = new int[nodes][nodes];
        this.hasNegativeCycle = false;
    }

    public void addEdge(int source, int dest, int weight) {
        distance[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        List<Integer> path = new ArrayList<>();
        if (distance[source][dest] == Integer.MAX_VALUE) {
            return path;
        }
        int i = source;
        for (; i != dest; i = next[i][dest]) {
            if (i == Integer.MAX_VALUE) {
                return new ArrayList<>();
            }
            path.add(i);
        }
        if (next[i][dest] == Integer.MAX_VALUE) {
            return new ArrayList<>();
        }
        path.add(dest);
        return path;
    }

    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                if (distance[i][k] == Integer.MAX_VALUE) {
                    continue;
                }
                for (int j = 0; j < nodes; j++) {
                    if (distance[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        next[i][j] = next[i][k];
                    }
                }
                if (distance[i][i] < 0) {
                    hasNegativeCycle = true;
                    return;
                }
            }
        }
    }
}
