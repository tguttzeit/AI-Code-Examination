package Copilot.FloydWarshall.T23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    int nodes;
    int[][] distance;
    int[][] next;
    List<Integer> path;
    int INF = 10000000;
    public FloydWarshall(int nodes){
        this.nodes = nodes;
        distance = new int[nodes][nodes];
        next = new int[nodes][nodes];
        path = new ArrayList<>();
        for(int i = 0; i < nodes; i++){
            Arrays.fill(distance[i], INF);
            Arrays.fill(next[i], -1);
        }
    }
    public void addEdge(int source, int dest, int weight){
        distance[source][dest] = weight;
        next[source][dest] = dest;
    }
    public List<Integer> path(int source, int dest){
        if(distance[source][dest] == INF){
            return null;
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
                    if(distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}
