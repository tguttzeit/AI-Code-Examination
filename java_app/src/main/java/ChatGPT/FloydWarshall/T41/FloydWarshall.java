package ChatGPT.FloydWarshall.T41;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist; // 2D array to store the shortest distances between nodes
    private int[][] next; // 2D array to store the next node on the shortest path
    private int nodes; // Number of nodes in the graph

    // Constructor to initialize the FloydWarshall class
    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];

        // Initialize the distance matrix with infinity and next matrix with -1 (indicating no path)
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                next[i][j] = -1;
            }
        }

        // Initialize the diagonal elements of the distance matrix to 0
        for (int i = 0; i < nodes; i++) {
            dist[i][i] = 0;
        }
    }

    // Method to add an edge with a weight between source and destination
    public void addEdge(int source, int dest, int weight) {
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    // Method to retrieve the shortest path between source and destination as a list of integers
    public List<Integer> path(int source, int dest) {
        if (dist[source][dest] == Integer.MAX_VALUE) {
            return null; // There is no path between source and destination
        }

        List<Integer> path = new ArrayList<>();
        path.add(source);
        while (source != dest) {
            source = next[source][dest];
            path.add(source);
        }
        return path;
    }

    // Method to run the Floyd Warshall algorithm to compute all-pairs shortest paths
    public void run() {
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
