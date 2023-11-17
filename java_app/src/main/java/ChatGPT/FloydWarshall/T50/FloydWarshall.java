package ChatGPT.FloydWarshall.T50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] graph;
    private int nodes;
    private List<Integer>[][] nextNodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.graph = new int[nodes][nodes];
        this.nextNodes = new ArrayList[nodes][nodes];

        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                graph[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
                nextNodes[i][j] = new ArrayList<>();
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid node indices");
        }

        graph[source][dest] = weight;
        nextNodes[source][dest].clear();
        nextNodes[source][dest].add(dest);
    }

    public List<Integer> path(int source, int dest) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid node indices");
        }

        return nextNodes[source][dest];
    }

    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE &&
                            graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        nextNodes[i][j] = new ArrayList<>(nextNodes[i][k]);
                        nextNodes[i][j].addAll(nextNodes[k][j]);
                    }
                }
            }
        }
    }
}
