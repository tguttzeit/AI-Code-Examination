package Copilot.FloydWarshall.T7;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    int[][] matrix;
    int[][] next;
    int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.matrix = new int[nodes][nodes];
        this.next = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
                next[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        matrix[source][dest] = weight;
    }

    public List<Integer> path(int source, int dest) {
        List<Integer> path = new ArrayList<>();
        if (matrix[source][dest] == Integer.MAX_VALUE) {
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
        for (int i = 0; i < nodes; i++) {
            matrix[i][i] = 0;
        }
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE
                            && matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        next[i][j] = k;
                    }
                }
            }
        }
    }
}
