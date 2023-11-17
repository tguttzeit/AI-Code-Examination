package ChatGPT.FloydWarshall.T35;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] distance;
    private int nodes;
    private List<Integer>[][] paths;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.distance = new int[nodes][nodes];
        this.paths = new ArrayList[nodes][nodes];

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                distance[i][j] = Integer.MAX_VALUE;
                paths[i][j] = new ArrayList<>();
                if (i == j) {
                    distance[i][j] = 0;
                    paths[i][j].add(i);
                }
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        distance[source][dest] = weight;
        paths[source][dest].add(dest);
    }

    public List<Integer> path(int source, int dest) {
        return paths[source][dest];
    }

    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE &&
                            distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        paths[i][j].clear();
                        paths[i][j].addAll(paths[i][k]);
                        paths[i][j].addAll(paths[k][j]);
                    }
                }
            }
        }
    }
}

