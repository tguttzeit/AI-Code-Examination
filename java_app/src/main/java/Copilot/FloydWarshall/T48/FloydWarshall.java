package Copilot.FloydWarshall.T48;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FloydWarshall {
    private int[][] d;
    private int[][] p;
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        d = new int[nodes][nodes];
        p = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++)
                d[i][j] = 999999;
            d[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        d[source][dest] = weight;
        p[source][dest] = source;
    }

    public List<Integer> path(int source, int dest) {
        List<Integer> path = new ArrayList<>();
        if (d[source][dest] == 999999)
            return path;
        path.add(dest);
        while (source != dest) {
            dest = p[source][dest];
            path.add(dest);
        }
        Collections.reverse(path);
        return path;
    }

    public void run() {
        for (int k = 0; k < nodes; k++)
            for (int i = 0; i < nodes; i++)
                for (int j = 0; j < nodes; j++)
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                        p[i][j] = p[k][j];
                    }
    }
}
