package Copilot.FloydWarshall.T44;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    int nodes;
    int[][] distance;
    int[][] next;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.distance = new int[nodes][nodes];
        this.next = new int[nodes][nodes];
    }

    public void addEdge(int source, int dest, int weight) {
        this.distance[source][dest] = weight;
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
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(next[i], -1);
        }

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                next[i][j] = j;
            }
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
    }
}
