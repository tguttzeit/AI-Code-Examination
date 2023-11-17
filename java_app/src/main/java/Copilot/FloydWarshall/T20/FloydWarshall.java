package Copilot.FloydWarshall.T20;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
    private int[][] pred;
    private int nodes;
    private boolean done;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.pred = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++)
                this.dist[i][j] = Integer.MAX_VALUE;
            this.dist[i][i] = 0;
        }
        this.done = false;
    }

    public void addEdge(int source, int dest, int weight) {
        this.dist[source][dest] = weight;
        this.pred[source][dest] = source;
    }

    public List<Integer> path(int source, int dest) {
        if (!this.done)
            this.run();
        List<Integer> path = new ArrayList<>();
        path.add(source);
        path(source, dest, path);
        path.add(dest);
        return path;
    }

    private void path(int source, int dest, List<Integer> path) {
        if (source == dest)
            return;
        path(this.pred[source][dest], dest, path);
        path.add(dest);
    }

    public void run() {
        for (int k = 0; k < this.nodes; k++) {
            for (int i = 0; i < this.nodes; i++) {
                for (int j = 0; j < this.nodes; j++) {
                    if (this.dist[i][k] == Integer.MAX_VALUE || this.dist[k][j] == Integer.MAX_VALUE)
                        continue;
                    if (this.dist[i][j] > this.dist[i][k] + this.dist[k][j]) {
                        this.dist[i][j] = this.dist[i][k] + this.dist[k][j];
                        this.pred[i][j] = this.pred[k][j];
                    }
                }
            }
        }
        this.done = true;
    }
}
