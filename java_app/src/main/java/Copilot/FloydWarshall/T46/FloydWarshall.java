package Copilot.FloydWarshall.T46;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    int[][] dist;
    int[][] next;
    int nodes;
    int INF = 1000;
    FloydWarshall(int nodes) {
        this.nodes = nodes;
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];
        for(int i = 0; i < nodes; i++) {
            for(int j = 0; j < nodes; j++) {
                dist[i][j] = INF;
                next[i][j] = INF;
            }
        }
    }
    public void addEdge(int source, int dest, int weight) {
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }
    public List<Integer> path(int source, int dest) {
        if(dist[source][dest] == INF) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(source);
        while(source != dest) {
            source = next[source][dest];
            res.add(source);
        }
        return res;
    }
    public void run() {
        for(int k = 0; k < nodes; k++) {
            for(int i = 0; i < nodes; i++) {
                for(int j = 0; j < nodes; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}
