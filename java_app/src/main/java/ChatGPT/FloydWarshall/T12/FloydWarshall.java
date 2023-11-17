package ChatGPT.FloydWarshall.T12;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] distance;
    private int[][] next;
    private int nodes;
    private boolean hasRun = false;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.distance = new int[nodes][nodes];
        this.next = new int[nodes][nodes];

        // Initialize distance matrix with infinity and next matrix with -1 (indicating no direct edge)
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
                next[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid source or destination node.");
        }
        distance[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (!hasRun) {
            throw new IllegalStateException("Floyd-Warshall algorithm has not been executed yet.");
        }
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid source or destination node.");
        }
        List<Integer> path = new ArrayList<>();
        if (distance[source][dest] == Integer.MAX_VALUE) {
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
    }

    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE
                            && distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        hasRun = true;
    }
}
