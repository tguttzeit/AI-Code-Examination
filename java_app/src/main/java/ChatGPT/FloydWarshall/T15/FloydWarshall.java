package ChatGPT.FloydWarshall.T15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] dist; // 2D array to store shortest distances
    private int[][] next; // 2D array to store next nodes for reconstructing the path
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];
        
        // Initialize the dist matrix with infinity and next matrix with -1
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2); // Using MAX_VALUE / 2 to avoid overflow
            Arrays.fill(next[i], -1);
        }
        
        // Set diagonal elements to 0
        for (int i = 0; i < nodes; i++) {
            dist[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge with a given weight
        dist[source][dest] = weight;
        next[source][dest] = dest; // Next node for the path
    }

    public List<Integer> path(int source, int dest) {
        // Reconstruct the shortest path from source to destination
        if (dist[source][dest] == Integer.MAX_VALUE / 2) {
            return null; // No path exists
        }

        List<Integer> path = new ArrayList<>();
        while (source != dest) {
            if (next[source][dest] == -1) {
                return null; // No path exists
            }
            path.add(source);
            source = next[source][dest];
        }
        path.add(dest);
        return path;
    }

    public void run() {
        // Run the Floyd-Warshall algorithm
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}
