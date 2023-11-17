package ChatGPT.FloydWarshall.T17;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist; // 2D array to store the shortest distances between nodes
    private int nodes;    // Number of nodes in the graph

    // Constructor to initialize the FloydWarshall class with the number of nodes
    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];

        // Initialize the distance matrix with initial values
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    dist[i][j] = 0; // Distance from a node to itself is 0
                } else {
                    dist[i][j] = Integer.MAX_VALUE; // Initialize other distances as infinity
                }
            }
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int dest, int weight) {
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            dist[source][dest] = weight;
        }
    }

    // Method to find the shortest path between source and destination nodes
    public List<Integer> path(int source, int dest) {
        List<Integer> pathList = new ArrayList<>();
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            return pathList; // Invalid source or destination
        }

        if (dist[source][dest] == Integer.MAX_VALUE) {
            return pathList; // No path exists between source and destination
        }

        // Reconstruct the shortest path using the distance matrix
        int intermediate = dest;
        while (intermediate != source) {
            pathList.add(0, intermediate);
            for (int prev = 0; prev < nodes; prev++) {
                if (dist[source][intermediate] == dist[source][prev] + dist[prev][intermediate]) {
                    intermediate = prev;
                    break;
                }
            }
        }
        pathList.add(0, source);
        return pathList;
    }

    // Method to run the Floyd-Warshall algorithm
    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}
