package Copilot.FloydWarshall.T1;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int nodes;
    private int[][] distance;
    private int[][] next;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.distance = new int[nodes][nodes];
        this.next = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                distance[i][j] = Integer.MAX_VALUE;
                next[i][j] = -1;
            }
        }
        for (int i = 0; i < nodes; i++) {
            distance[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        distance[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (distance[source][dest] == Integer.MAX_VALUE) {
            return null;
        }
        List<Integer> path = new ArrayList<>();
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
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE
                            && distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}
