package Copilot.FloydWarshall.T35;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    int nodes;
    int[][] dist;
    int[][] next;
    final int INF = 99999999;

    public FloydWarshall(int nodes){
        this.nodes = nodes;
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];
        for(int i = 0; i < nodes; i++){
            for(int j = 0; j < nodes; j++){
                dist[i][j] = INF;
                next[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight){
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest){
        List<Integer> path = new ArrayList<>();
        if(next[source][dest] == -1){
            return path;
        }
        path.add(source);
        while(source != dest){
            source = next[source][dest];
            path.add(source);
        }
        return path;
    }

    public void run(){
        for(int k = 0; k < nodes; k++){
            for(int i = 0; i < nodes; i++){
                for(int j = 0; j < nodes; j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}
