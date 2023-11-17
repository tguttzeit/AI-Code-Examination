package ChatGPT.FloydWarshall.T3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] distance; // To store the shortest distances between nodes
    private int[][] next; // To store the next node in the shortest path
    private int nodes; // Number of nodes in the graph

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        distance = new int[nodes][nodes];
        next = new int[nodes][nodes];

        // Initialize distance matrix with maximum values and next matrix with -1
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            Arrays.fill(next[i], -1);
        }

        // Set diagonal elements to 0
        for (int i = 0; i < nodes; i++) {
            distance[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge with the given weight
        distance[source][dest] = weight;
        next[source][dest] = dest; // Next node for the path from source to dest is initially dest
    }

    public List<Integer> path(int source, int dest) {
        // Reconstruct the shortest path from source to dest
        List<Integer> path = new ArrayList<>();
        if (distance[source][dest] == Integer.MAX_VALUE) {
            // No path exists
            return path;
        }

        int at = source;
        while (at != dest) {
            if (at == -1) {
                // No path exists
                return new ArrayList<>();
            }
            path.add(at);
            at = next[at][dest];
        }
        path.add(dest);

        return path;
    }

    public void run() {
        // Run the Floyd-Warshall algorithm
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE
                            && distance[i][k] + distance[k][j] < distance[i][j]) {
                        // If a shorter path is found from i to j through k, update it
                        distance[i][j] = distance[i][k] + distance[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}
