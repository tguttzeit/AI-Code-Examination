package ChatGPT.FloydWarshall.T11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] dist; // Distance matrix
    private int[][] next; // Next node matrix
    private int nodes;

    // Constructor
    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];

        // Initialize the distance matrix and next node matrix
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2); // Set initial distances to a very large value
            Arrays.fill(next[i], -1); // Set initial next nodes to -1 (indicating no direct path)
            dist[i][i] = 0; // Distance to itself is 0
        }
    }

    // Add an edge with a given weight
    public void addEdge(int source, int dest, int weight) {
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            dist[source][dest] = weight;
            next[source][dest] = dest; // Next node for the direct edge
        }
    }

    // Reconstruct the shortest path from source to dest
    private List<Integer> reconstructPath(int source, int dest) {
        List<Integer> path = new ArrayList<>();
        if (next[source][dest] == -1) {
            return path; // No path exists
        }
        path.add(source);
        while (source != dest) {
            source = next[source][dest];
            path.add(source);
        }
        return path;
    }

    // Calculate and return the shortest path from source to dest
    public List<Integer> path(int source, int dest) {
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            return reconstructPath(source, dest);
        }
        return new ArrayList<>(); // Invalid source or destination
    }

    // Run the Floyd Warshall algorithm
    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k]; // Update the next node for the shortest path
                    }
                }
            }
        }
    }
}
