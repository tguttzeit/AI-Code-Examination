package ChatGPT.FloydWarshall.T21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
    private int[][] next;
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];

        for (int i = 0; i < nodes; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2);
            Arrays.fill(next[i], -1);
            dist[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes)
            throw new IllegalArgumentException("Invalid node indices");

        dist[source][dest] = Math.min(dist[source][dest], weight);
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes)
            throw new IllegalArgumentException("Invalid node indices");

        if (dist[source][dest] == Integer.MAX_VALUE / 2)
            return null; // There is no path from source to dest

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
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}