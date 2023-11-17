package Copilot.FloydWarshall.T24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    int nodes;
    int[][] matrix;
    int[][] path;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        matrix = new int[nodes][nodes];
        path = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
                path[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        matrix[source][dest] = weight;
    }

    public List<Integer> path(int source, int dest) {
        List<Integer> result = new ArrayList<>();
        if (path[source][dest] == -1) {
            return result;
        }
        result.add(source);
        while (source != dest) {
            source = path[source][dest];
            result.add(source);
        }
        return result;
    }

    public void run() {
        for (int i = 0; i < nodes; i++) {
            matrix[i][i] = 0;
        }
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
    }
}
