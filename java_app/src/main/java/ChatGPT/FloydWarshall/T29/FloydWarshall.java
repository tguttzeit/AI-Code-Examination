package ChatGPT.FloydWarshall.T29;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist; // 2D array to store the shortest distances between nodes
    private int nodes; // Number of nodes in the graph

    // Constructor to initialize the FloydWarshall object with the number of nodes
    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        dist = new int[nodes][nodes];

        // Initialize the distance matrix with infinity for all pairs and 0 for diagonal (node to itself)
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int dest, int weight) {
        // Check if source and destination are valid nodes
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            dist[source][dest] = weight;
        } else {
            System.out.println("Invalid source or destination node.");
        }
    }

    // Method to find the shortest path between two nodes and return it as a List of integers
    public List<Integer> path(int source, int dest) {
        List<Integer> pathList = new ArrayList<>();

        // If either source or destination is invalid, return an empty list
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            return pathList;
        }

        // If there is no path from source to destination, return an empty list
        if (dist[source][dest] == Integer.MAX_VALUE) {
            return pathList;
        }

        // Reconstruct the path using the parent array
        int current = source;
        while (current != dest) {
            pathList.add(current);
            current = dist[current][dest];
        }
        pathList.add(dest);

        return pathList;
    }

    // Method to run the Floyd-Warshall algorithm
    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
    }
}
