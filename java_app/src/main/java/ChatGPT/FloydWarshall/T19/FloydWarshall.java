package ChatGPT.FloydWarshall.T19;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] distance; // Distance matrix
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.distance = new int[nodes][nodes];

        // Initialize the distance matrix
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    distance[i][j] = 0; // Distance from a node to itself is 0
                } else {
                    distance[i][j] = Integer.MAX_VALUE; // Initialize other distances to infinity
                }
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge with the given weight
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            distance[source][dest] = weight;
        } else {
            throw new IllegalArgumentException("Invalid node indices");
        }
    }

    public List<Integer> path(int source, int dest) {
        // Initialize the path list
        List<Integer> path = new ArrayList<>();

        // If source or destination is invalid, return an empty list
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            return path;
        }

        // If there is no path from source to destination, return an empty list
        if (distance[source][dest] == Integer.MAX_VALUE) {
            return path;
        }

        // Backtrack to construct the path
        while (source != dest) {
            path.add(source);
            for (int i = 0; i < nodes; i++) {
                if (distance[source][dest] == distance[source][i] + distance[i][dest]) {
                    source = i;
                    break;
                }
            }
        }
        path.add(dest);

        return path;
    }

    public void run() {
        // Floyd-Warshall algorithm
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE
                            && distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }
}
