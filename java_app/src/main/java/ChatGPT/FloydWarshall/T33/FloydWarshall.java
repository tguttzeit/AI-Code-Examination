package ChatGPT.FloydWarshall.T33;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist; // 2D array to store the shortest distances between nodes
    private int[][] next; // 2D array to store the next node in the shortest path
    private int nodes; // Number of nodes in the graph

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];

        // Initialize the distance matrix with infinity
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                next[i][j] = -1;
            }
        }

        // Initialize the diagonal with zeros (distance to itself is zero)
        for (int i = 0; i < nodes; i++) {
            dist[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge with the given weight to the distance matrix
        dist[source][dest] = weight;
        next[source][dest] = dest; // Next node in the path is initially the destination
    }

    public List<Integer> path(int source, int dest) {
        // Reconstruct the shortest path from source to dest
        List<Integer> pathList = new ArrayList<>();
        if (dist[source][dest] == Integer.MAX_VALUE) {
            return pathList; // No path exists
        }

        int current = source;
        while (current != dest) {
            pathList.add(current);
            current = next[current][dest];
        }
        pathList.add(dest);

        return pathList;
    }

    public void run() {
        // Floyd-Warshall algorithm to compute shortest distances
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE &&
                        dist[i][k] + dist[k][j] < dist[i][j]) {
                        // Update the shortest distance and next node in the path
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}
