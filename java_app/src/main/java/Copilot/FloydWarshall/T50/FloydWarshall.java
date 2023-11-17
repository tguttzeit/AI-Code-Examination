package Copilot.FloydWarshall.T50;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
    private int[][] next;
    private int nodes;
    private boolean hasRun = false;
    
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
        if (!hasRun) {
            run();
        }
        List<Integer> path = new ArrayList<>();
        if (dist[source][dest] == Integer.MAX_VALUE) {
            return path;
        }
        int curr = source;
        while (curr != dest) {
            path.add(curr);
            curr = next[curr][dest];
        }
        path.add(dest);
        return path;
    }
    
    public void run() {
        for (int i = 0; i < nodes; i++) {
            dist[i][i] = 0;
        }
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        hasRun = true;
    }
}
