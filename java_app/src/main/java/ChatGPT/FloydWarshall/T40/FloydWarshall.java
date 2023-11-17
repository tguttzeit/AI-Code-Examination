package ChatGPT.FloydWarshall.T40;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int nodes;
    private int[][] dist;
    private int[][] next;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];

        // Initialize the distance matrix with maximum values and the next matrix with -1
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
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            dist[source][dest] = weight;
        } else {
            throw new IllegalArgumentException("Invalid source or destination node");
        }
    }

    public List<Integer> path(int source, int dest) {
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            List<Integer> path = new ArrayList<>();
            if (dist[source][dest] == Integer.MAX_VALUE) {
                // No path exists
                return path;
            }

            int current = source;
            while (current != dest) {
                path.add(current);
                current = next[current][dest];
            }
            path.add(dest);
            return path;
        } else {
            throw new IllegalArgumentException("Invalid source or destination node");
        }
    }

    public void run() {
        // Floyd-Warshall algorithm
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = k;
                    }
                }
            }
        }
    }
}

