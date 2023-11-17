package Copilot.FloydWarshall.T33;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int nodes;
    private int[][] dist;
    private int[][] next;
    private boolean isRun = false;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];
        for(int i = 0; i < nodes; i++) {
            for(int j = 0; j < nodes; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                next[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if(!isRun) {
            run();
        }
        List<Integer> result = new ArrayList<>();
        if(dist[source][dest] == Integer.MAX_VALUE) {
            return result;
        }
        result.add(source);
        while(source != dest) {
            source = next[source][dest];
            result.add(source);
        }
        return result;
    }

    public void run() {
        for(int i = 0; i < nodes; i++) {
            for(int j = 0; j < nodes; j++) {
                for(int k = 0; k < nodes; k++) {
                    if(dist[j][i] != Integer.MAX_VALUE && dist[i][k] != Integer.MAX_VALUE && dist[j][k] > dist[j][i] + dist[i][k]) {
                        dist[j][k] = dist[j][i] + dist[i][k];
                        next[j][k] = next[j][i];
                    }
                }
            }
        }
        isRun = true;
    }
}
