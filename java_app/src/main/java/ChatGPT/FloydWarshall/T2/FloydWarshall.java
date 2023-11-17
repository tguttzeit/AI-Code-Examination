package ChatGPT.FloydWarshall.T2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] graph;
    private int[][] dist;
    private int[][] next;
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.graph = new int[nodes][nodes];
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];

        // Initialize the graph with maximum values and diagonal with 0s
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        graph[source][dest] = weight;
    }

    public List<Integer> path(int source, int dest) {
        List<Integer> pathList = new ArrayList<>();

        if (dist[source][dest] == Integer.MAX_VALUE) {
            return pathList; // No path exists
        }

        int u = source;
        while (u != dest) {
            pathList.add(u);
            u = next[u][dest];
        }
        pathList.add(dest);

        return pathList;
    }

    public void run() {
        // Initialize dist and next matrices with the same values as the graph
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                dist[i][j] = graph[i][j];
                if (i != j && graph[i][j] != Integer.MAX_VALUE) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                            dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}
