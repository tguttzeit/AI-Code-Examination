package ChatGPT.FloydWarshall.AIGenerated.T4;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] distanceMatrix;
    private int[][] pathMatrix;
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.distanceMatrix = new int[nodes][nodes];
        this.pathMatrix = new int[nodes][nodes];

        // Initialize the distance matrix with maximum values and path matrix with -1 (no path).
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    distanceMatrix[i][j] = 0;
                } else {
                    distanceMatrix[i][j] = Integer.MAX_VALUE;
                }
                pathMatrix[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge with the given weight to the distance matrix.
        distanceMatrix[source][dest] = weight;
        // Update the path matrix to indicate that there is a path from source to dest.
        pathMatrix[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        List<Integer> shortestPath = new ArrayList<>();

        // If there is no path from source to dest, return an empty list.
        if (distanceMatrix[source][dest] == Integer.MAX_VALUE) {
            return shortestPath;
        }

        // Reconstruct the shortest path using the path matrix.
        int currentNode = source;
        while (currentNode != dest) {
            shortestPath.add(currentNode);
            currentNode = pathMatrix[currentNode][dest];
        }
        shortestPath.add(dest);

        return shortestPath;
    }

    public void run() {
        // Floyd-Warshall algorithm implementation.
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (distanceMatrix[i][k] != Integer.MAX_VALUE &&
                        distanceMatrix[k][j] != Integer.MAX_VALUE &&
                        distanceMatrix[i][k] + distanceMatrix[k][j] < distanceMatrix[i][j]) {
                        distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];
                        pathMatrix[i][j] = pathMatrix[i][k];
                    }
                }
            }
        }
    }
}
