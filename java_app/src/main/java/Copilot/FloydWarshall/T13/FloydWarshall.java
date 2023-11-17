package Copilot.FloydWarshall.T13;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] matrix;
    private int nodes;
    private int[][] path;
    private final int INF = 999999;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.matrix = new int[nodes][nodes];
        this.path = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                matrix[i][j] = INF;
                path[i][j] = INF;
            }
        }
    }
    public void addEdge(int source, int dest, int weight) {
        matrix[source][dest] = weight;
        path[source][dest] = dest;
    }
    public List<Integer> path(int source, int dest) {
        List<Integer> result = new ArrayList<>();
        if (path[source][dest] == INF) {
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
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        path[i][j] = path[i][k];
                    }
                }
            }
        }
    }
}
