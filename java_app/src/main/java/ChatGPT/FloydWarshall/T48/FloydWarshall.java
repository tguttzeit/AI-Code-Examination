package ChatGPT.FloydWarshall.T48;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] dist; // Distance matrix
    private int nodes;    // Number of nodes

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];

        // Initialize the distance matrix with maximum values
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge with the given weight to the distance matrix
        dist[source][dest] = weight;
    }

    public List<Integer> path(int source, int dest) {
        // Check if the distance matrix has been computed
        if (dist == null) {
            throw new IllegalStateException("Distance matrix has not been computed. Call run() method first.");
        }

        // Initialize the path list
        List<Integer> path = new ArrayList<>();

        // If there is no path between source and destination, return an empty list
        if (dist[source][dest] == Integer.MAX_VALUE) {
            return path;
        }

        // Reconstruct the shortest path
        int current = source;
        while (current != dest) {
            path.add(current);
            current = dist[current][dest];
        }
        path.add(dest);

        return path;
    }

    public void run() {
        // Floyd-Warshall algorithm
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }
}
