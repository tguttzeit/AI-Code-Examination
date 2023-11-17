package ChatGPT.FloydWarshall.T37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
    private int[][] next;
    private int nodes;
    private static final int INF = Integer.MAX_VALUE;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];

        // Initialize the distance matrix with infinity values
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(dist[i], INF);
            Arrays.fill(next[i], -1);
        }

        // Set diagonal elements to 0
        for (int i = 0; i < nodes; i++) {
            dist[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            dist[source][dest] = weight;
            next[source][dest] = dest;
        } else {
            throw new IllegalArgumentException("Invalid node indices.");
        }
    }

    public List<Integer> path(int source, int dest) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid node indices.");
        }

        if (dist[source][dest] == INF) {
            return null; // No path exists
        }

        List<Integer> pathList = new ArrayList<>();
        while (source != dest) {
            if (source == -1) {
                return null; // No path exists
            }
            pathList.add(source);
            source = next[source][dest];
        }
        pathList.add(dest);

        return pathList;
    }

    public void run() {
        // Floyd-Warshall algorithm
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
