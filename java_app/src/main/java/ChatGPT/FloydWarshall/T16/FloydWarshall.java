package ChatGPT.FloydWarshall.T16;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
    private int[][] next;
    private int nodes;
    private static final int INF = Integer.MAX_VALUE / 2; // Represents infinity for shortest path

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];
        
        // Initialize the distance matrix with infinity and next matrix with -1
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                dist[i][j] = INF;
                next[i][j] = -1;
            }
        }
        
        // Initialize the diagonal elements to 0
        for (int i = 0; i < nodes; i++) {
            dist[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge with the given weight from source to destination
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        // Reconstruct the shortest path from source to dest using the next matrix
        if (dist[source][dest] == INF) {
            return null; // No path exists
        }

        List<Integer> path = new ArrayList<>();
        int current = source;
        while (current != dest) {
            path.add(current);
            current = next[current][dest];
        }
        path.add(dest);

        return path;
    }

    public void run() {
        // Floyd-Warshall algorithm implementation
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}
