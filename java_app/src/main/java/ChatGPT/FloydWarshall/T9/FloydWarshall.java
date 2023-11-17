package ChatGPT.FloydWarshall.T9;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist; // Distance matrix
    private int[][] next; // Next node matrix
    private int nodes;    // Number of nodes in the graph

    // Constructor to initialize the FloydWarshall instance with the number of nodes
    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];

        // Initialize the distance and next matrices
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                dist[i][j] = Integer.MAX_VALUE / 2; // Set to a large value (infinity)
                next[i][j] = -1; // No next node initially
            }
        }

        // Initialize the diagonal of the distance matrix to 0
        for (int i = 0; i < nodes; i++) {
            dist[i][i] = 0;
        }
    }

    // Add an edge with a given weight between source and destination nodes
    public void addEdge(int source, int dest, int weight) {
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    // Run the Floyd-Warshall algorithm to compute shortest paths
    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    // Find the shortest path from source to destination and return it as a list of nodes
    public List<Integer> path(int source, int dest) {
        List<Integer> pathList = new ArrayList<>();
        if (dist[source][dest] == Integer.MAX_VALUE / 2) {
            return pathList; // No path exists
        }

        int current = source;
        while (current != dest) {
            if (current == -1) {
                return null; // No path exists
            }
            pathList.add(current);
            current = next[current][dest];
        }
        pathList.add(dest);
        return pathList;
    }
}
