package ChatGPT.FloydWarshall.T22;

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

        // Initialize the distance matrix with infinity (or a very large value)
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                next[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge with the given weight between source and destination
        dist[source][dest] = weight;
        next[source][dest] = dest; // Next node for the path
    }

    public List<Integer> path(int source, int dest) {
        // Reconstruct the shortest path from source to dest
        if (dist[source][dest] == Integer.MAX_VALUE) {
            return null; // There is no path
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
        // Floyd Warshall algorithm
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}
