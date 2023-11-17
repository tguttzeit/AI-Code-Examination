package Copilot.FloydWarshall.T19;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    int[][] adjMatrix;
    int[][] distMatrix;
    int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.adjMatrix = new int[nodes][nodes];
        this.distMatrix = new int[nodes][nodes];
    }

    public void addEdge(int source, int dest, int weight) {
        adjMatrix[source][dest] = weight;
    }

    public List<Integer> path(int source, int dest) {
        List<Integer> path = new ArrayList<>();
        if (distMatrix[source][dest] == Integer.MAX_VALUE) {
            return path;
        }
        path.add(source);
        while (source != dest) {
            source = distMatrix[source][dest];
            path.add(source);
        }
        return path;
    }

    public void run() {
        // Initialize the distMatrix with the adjMatrix.
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                distMatrix[i][j] = adjMatrix[i][j];
            }
        }
        // Floyd Warshall algorithm.
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (distMatrix[i][k] != Integer.MAX_VALUE && distMatrix[k][j] != Integer.MAX_VALUE && distMatrix[i][k] + distMatrix[k][j] < distMatrix[i][j]) {
                        distMatrix[i][j] = distMatrix[i][k] + distMatrix[k][j];
                    }
                }
            }
        }
    }
}
