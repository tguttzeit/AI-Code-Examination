package ChatGPT.FloydWarshall.T4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] dist; // 2D array to store the shortest distances between nodes
    private int nodes;    // Number of nodes in the graph

    // Constructor to initialize the class with the number of nodes
    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        
        // Initialize the distance matrix with infinity values
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Initialize the diagonal with zeros
        for (int i = 0; i < nodes; i++) {
            dist[i][i] = 0;
        }
    }

    // Add an edge with a given source, destination, and weight
    public void addEdge(int source, int dest, int weight) {
        // Ensure that the indices are valid
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            dist[source][dest] = weight;
        } else {
            throw new IllegalArgumentException("Invalid node indices");
        }
    }

    // Find the shortest path from source to destination
    public List<Integer> path(int source, int dest) {
        // Check if the distance matrix has been computed
        if (dist == null) {
            throw new IllegalStateException("Floyd Warshall algorithm has not been run yet.");
        }

        // Check if the indices are valid
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid node indices");
        }

        List<Integer> path = new ArrayList<>();
        if (dist[source][dest] == Integer.MAX_VALUE) {
            // If there is no path, return an empty list
            return path;
        }

        // Reconstruct the path using the predecessor matrix
        int current = source;
        while (current != dest) {
            path.add(current);
            for (int next = 0; next < nodes; next++) {
                if (dist[current][dest] == dist[current][next] + dist[next][dest]) {
                    current = next;
                    break;
                }
            }
        }
        path.add(dest);

        return path;
    }

    // Run the Floyd Warshall algorithm to compute shortest paths
    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    // Relaxation step
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}
