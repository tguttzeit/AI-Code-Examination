package ChatGPT.FloydWarshall.T23;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
    private int[][] next;
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];

        // Initialize the distance matrix with maximum values
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                next[i][j] = -1;
            }
        }

        // Initialize diagonal elements with zeros
        for (int i = 0; i < nodes; i++) {
            dist[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (dist[source][dest] == Integer.MAX_VALUE) {
            return null; // There is no path from source to dest
        }

        List<Integer> pathList = new ArrayList<>();
        pathList.add(source);
        while (source != dest) {
            source = next[source][dest];
            pathList.add(source);
        }
        return pathList;
    }

    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}
