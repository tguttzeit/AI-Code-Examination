package ChatGPT.FloydWarshall.T27;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] distance;
    private int[][] next;
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.distance = new int[nodes][nodes];
        this.next = new int[nodes][nodes];

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE / 2; // Set to a large value to represent infinity
                }
                next[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        distance[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (distance[source][dest] == Integer.MAX_VALUE / 2) {
            return null; // There is no path from source to destination
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
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}
