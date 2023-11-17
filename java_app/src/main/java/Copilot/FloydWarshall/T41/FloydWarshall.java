package Copilot.FloydWarshall.T41;

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
    }

    public void addEdge(int source, int dest, int weight) {
        this.dist[source][dest] = weight;
        this.next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        List<Integer> path = new ArrayList<>();
        if (this.dist[source][dest] == Integer.MAX_VALUE) {
            return path;
        }
        path.add(source);
        while (source != dest) {
            source = this.next[source][dest];
            path.add(source);
        }
        return path;
    }

    public void run() {
        for (int i = 0; i < this.nodes; i++) {
            for (int j = 0; j < this.nodes; j++) {
                for (int k = 0; k < this.nodes; k++) {
                    if (this.dist[j][i] == Integer.MAX_VALUE || this.dist[i][k] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (this.dist[j][i] + this.dist[i][k] < this.dist[j][k]) {
                        this.dist[j][k] = this.dist[j][i] + this.dist[i][k];
                        this.next[j][k] = this.next[j][i];
                    }
                }
            }
        }
    }
}
