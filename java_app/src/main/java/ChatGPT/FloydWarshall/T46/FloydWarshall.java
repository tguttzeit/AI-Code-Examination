package ChatGPT.FloydWarshall.T46;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
    private int[][] next;
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];

        // Initialize the distance matrix with infinity (or a large value) and no next node.
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
                next[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge to the distance and next matrices.
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (dist[source][dest] == Integer.MAX_VALUE) {
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
