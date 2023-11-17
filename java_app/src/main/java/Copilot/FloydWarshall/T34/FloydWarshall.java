package Copilot.FloydWarshall.T34;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int nodes;
    private int[][] distance;
    private Integer[][] next;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.distance = new int[nodes][nodes];
        this.next = new Integer[nodes][nodes];
    }

    public void addEdge(int source, int dest, int weight) {
        distance[source][dest] = weight;
    }

    public List<Integer> path(int source, int dest) {
        if (distance[source][dest] == 0) {
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
            for (int j = 0; j < nodes; j++) {
                next[i][j] = j;
            }
        }

        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (distance[i][k] != 0 && distance[k][j] != 0) {
                        if (distance[i][j] == 0 || distance[i][k] + distance[k][j] < distance[i][j]) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                            next[i][j] = next[i][k];
                        }
                    }
                }
            }
        }
    }
}
