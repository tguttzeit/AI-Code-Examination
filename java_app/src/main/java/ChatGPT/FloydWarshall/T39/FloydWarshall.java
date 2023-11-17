package ChatGPT.FloydWarshall.T39;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist; // Matrix to store the shortest distances between nodes
    private int nodes; // Total number of nodes in the graph

    // Constructor to initialize the FloydWarshall object with the number of nodes
    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];

        // Initialize the distance matrix with initial values
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

    // Method to add an edge with a given weight
    public void addEdge(int source, int dest, int weight) {
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            dist[source][dest] = weight;
        } else {
            throw new IllegalArgumentException("Invalid node indices");
        }
    }

    // Method to run the Floyd Warshall algorithm
    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
    }

    // Method to find the shortest path between two nodes and return it as a List of integers
    public List<Integer> path(int source, int dest) {
        List<Integer> pathList = new ArrayList<>();
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            return pathList; // Return an empty list if the source or destination node is invalid
        }

        if (dist[source][dest] == Integer.MAX_VALUE) {
            return pathList; // Return an empty list if there is no path between source and destination
        }

        int current = source;
        pathList.add(current);
        while (current != dest) {
            for (int next = 0; next < nodes; next++) {
                if (dist[current][next] + dist[next][dest] == dist[current][dest]) {
                    pathList.add(next);
                    current = next;
                    break;
                }
            }
        }

        return pathList;
    }
}
