package ChatGPT.FloydWarshall.T44;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int nodes;
    private int[][] graph;
    private Integer[][] next;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.graph = new int[nodes][nodes];
        this.next = new Integer[nodes][nodes];

        // Initialize the graph with maximum values (infinity)
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid node index");
        }

        graph[source][dest] = weight;
    }

    public List<Integer> path(int source, int dest) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid node index");
        }

        if (next[source][dest] == null) {
            return new ArrayList<>();
        }

        List<Integer> path = new ArrayList<>();
        path.add(source);

        while (source != dest) {
            source = next[source][dest];
            path.add(source);
        }

        return path;
    }

    public void run() {
        // Initialize the next matrix for path reconstruction
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                next[i][j] = (i == j || graph[i][j] == Integer.MAX_VALUE) ? null : j;
            }
        }

        // Floyd-Warshall algorithm
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE &&
                            graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}

