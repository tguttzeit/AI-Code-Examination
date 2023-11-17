package Copilot.FloydWarshall.T31;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int nodes;
    private int[][] distance;
    private int[][] path;
    public FloydWarshall(int nodes){
        this.nodes = nodes;
        distance = new int[nodes][nodes];
        path = new int[nodes][nodes];
        for(int i=0;i<nodes;i++){
            for(int j=0;j<nodes;j++){
                distance[i][j] = Integer.MAX_VALUE;
                if(i==j){
                    distance[i][j] = 0;
                }
                path[i][j] = -1;
            }
        }
    }
    public void addEdge(int source, int dest, int weight){
        distance[source][dest] = weight;
        path[source][dest] = dest;
    }
    public List<Integer> path(int source, int dest){
        List<Integer> result = new ArrayList<>();
        if(path[source][dest]==-1){
            return result;
        }
        result.add(source);
        while(source!=dest){
            source = path[source][dest];
            result.add(source);
        }
        return result;
    }
    public void run(){
        for(int k=0;k<nodes;k++){
            for(int i=0;i<nodes;i++){
                for(int j=0;j<nodes;j++){
                    if(distance[i][k]!=Integer.MAX_VALUE && distance[k][j]!=Integer.MAX_VALUE && distance[i][k]+distance[k][j]<distance[i][j]){
                        distance[i][j] = distance[i][k]+distance[k][j];
                        path[i][j] = path[i][k];
                    }
                }
            }
        }
    }
}
