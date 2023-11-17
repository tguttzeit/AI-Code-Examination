package Copilot.FloydWarshall.T37;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int nodes;
    private int[][] dist;
    private int[][] next;
    private boolean isRun;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];
        this.isRun = false;
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                this.dist[i][j] = Integer.MAX_VALUE;
                this.next[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        this.dist[source][dest] = weight;
        this.next[source][dest] = dest;
    }

    public void run() {
        for (int i = 0; i < nodes; i++) {
            this.dist[i][i] = 0;
        }
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (this.dist[i][k] != Integer.MAX_VALUE && this.dist[k][j] != Integer.MAX_VALUE && this.dist[i][k] + this.dist[k][j] < this.dist[i][j]) {
                        this.dist[i][j] = this.dist[i][k] + this.dist[k][j];
                        this.next[i][j] = this.next[i][k];
                    }
                }
            }
        }
        this.isRun = true;
    }

    public List<Integer> path(int source, int dest) {
        if (!this.isRun) {
            throw new IllegalStateException("Please run Floyd Warshall first");
        }
        List<Integer> res = new ArrayList<>();
        res.add(source);
        while (source != dest) {
            if (this.next[source][dest] == -1) {
                return new ArrayList<>();
            }
            source = this.next[source][dest];
            res.add(source);
        }
        return res;
    }
}
