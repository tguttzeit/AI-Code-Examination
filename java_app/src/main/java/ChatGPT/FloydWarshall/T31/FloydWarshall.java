package ChatGPT.FloydWarshall.T31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] dist; // 2D array to store the shortest distances
    private int[][] next; // 2D array to store the next node on the shortest path
    private int nodes; // Number of nodes in the graph

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        dist = new int[nodes][nodes];
        next = new int[nodes][nodes];
        
        // Initialize the distance matrix with maximum values
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2); // To avoid overflow
            Arrays.fill(next[i], -1);
            dist[i][i] = 0; // Distance from a node to itself is always 0
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge to the adjacency matrix
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        // Reconstruct and return the shortest path from source to dest
        if (dist[source][dest] == Integer.MAX_VALUE / 2) {
            return null; // No path exists
        }

        List<Integer> pathList = new ArrayList<>();
        pathList.add(source);
        while (source != dest) {
            source = next[source][dest];
            pathList.add(source);
        }

        return pathList;
    }

    public void run() {
        // Floyd-Warshall algorithm
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
}
