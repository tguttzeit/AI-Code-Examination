package ChatGPT.FloydWarshall.T6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] graph;
    private int[][] next;
    private int nodes;
    private boolean isComputed = false;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.graph = new int[nodes][nodes];
        this.next = new int[nodes][nodes];
        
        // Initialize the graph with initial values.
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE / 2); // Set to a large value to represent infinity
            graph[i][i] = 0; // Distance from a node to itself is always 0
        }
    }

    public void addEdge(int source, int dest, int weight) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid node index");
        }
        graph[source][dest] = weight;
    }

    public List<Integer> path(int source, int dest) {
        if (!isComputed) {
            throw new IllegalStateException("You must run the Floyd-Warshall algorithm first using the run() method.");
        }

        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid node index");
        }

        if (graph[source][dest] == Integer.MAX_VALUE / 2) {
            return null; // There is no path from source to destination
        }

        List<Integer> path = new ArrayList<>();
        while (source != dest) {
            path.add(source);
            source = next[source][dest];
        }
        path.add(dest);
        return path;
    }

    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        next[i][j] = k;
                    }
                }
            }
        }
        isComputed = true;
    }
}
