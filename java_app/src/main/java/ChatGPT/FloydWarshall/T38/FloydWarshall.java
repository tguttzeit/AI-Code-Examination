package ChatGPT.FloydWarshall.T38;

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

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE / 2; // "Infinity" for practical purposes
                }
                next[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        List<Integer> pathList = new ArrayList<>();
        if (dist[source][dest] == Integer.MAX_VALUE / 2) {
            return pathList; // No path exists
        }

        int intermediate = next[source][dest];
        if (intermediate == -1) {
            pathList.add(source);
            pathList.add(dest);
            return pathList;
        }

        pathList.addAll(path(source, intermediate));
        pathList.remove(pathList.size() - 1); // Remove intermediate node
        pathList.addAll(path(intermediate, dest));
        return pathList;
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

