package ChatGPT.FloydWarshall.T25;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
    private int[][] next;
    private int nodes;
    private boolean isRun;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];
        this.isRun = false;

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                    next[i][j] = -1;
                } else {
                    dist[i][j] = Integer.MAX_VALUE / 2; // Using a large value to represent infinity
                    next[i][j] = -1;
                }
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid node indices");
        }

        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (!isRun) {
            throw new IllegalStateException("You must call run() before calling path()");
        }

        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid node indices");
        }

        if (dist[source][dest] == Integer.MAX_VALUE / 2) {
            return null; // No path exists
        }

        List<Integer> path = new ArrayList<>();
        int current = source;

        while (current != dest) {
            if (current == -1) {
                return null; // No path exists
            }
            path.add(current);
            current = next[current][dest];
        }

        path.add(dest);
        return path;
    }

    public void run() {
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
        isRun = true;
    }
}
