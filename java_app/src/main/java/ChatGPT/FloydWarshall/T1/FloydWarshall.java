package ChatGPT.FloydWarshall.T1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] dist; // Distance matrix
    private int[][] next; // Next node matrix
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];

        // Initialize distance matrix with infinity values
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Initialize next node matrix with -1 values
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(next[i], -1);
        }

        // Initialize diagonal with zeros
        for (int i = 0; i < nodes; i++) {
            dist[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge with the given weight
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        List<Integer> path = new ArrayList<>();
        if (dist[source][dest] == Integer.MAX_VALUE) {
            // There is no path from source to destination
            return path;
        }

        // Reconstruct the shortest path
        int current = source;
        while (current != dest) {
            path.add(current);
            current = next[current][dest];
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
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            next[i][j] = next[i][k];
                        }
                    }
                }
            }
        }
    }
}
