package ChatGPT.FloydWarshall.T24;

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

        // Initialize the distance matrix with infinity (or a large value) and the next matrix with -1.
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            Arrays.fill(next[i], -1);
            dist[i][i] = 0; // Distance to itself is always 0
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge with a given weight to the adjacency matrix.
        dist[source][dest] = weight;
        next[source][dest] = dest; // Next node for (source, dest) is initially dest.
    }

    public List<Integer> path(int source, int dest) {
        // Reconstruct the shortest path from 'source' to 'dest' using the 'next' matrix.
        if (dist[source][dest] == Integer.MAX_VALUE) {
            // No path exists
            return null;
        }

        List<Integer> path = new ArrayList<>();
        path.add(source);

        while (source != dest) {
            source = next[source][dest];
            path.add(source);
        }

        return path;
    }

    public void run() {
        // Floyd-Warshall algorithm to find all-pairs shortest paths.
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        int throughK = dist[i][k] + dist[k][j];
                        if (throughK < dist[i][j]) {
                            dist[i][j] = throughK;
                            next[i][j] = next[i][k]; // Update the next node.
                        }
                    }
                }
            }
        }
    }
}
