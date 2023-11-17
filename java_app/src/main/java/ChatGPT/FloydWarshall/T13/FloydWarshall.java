package ChatGPT.FloydWarshall.T13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] distance; // The matrix to store the shortest distances between nodes
    private int nodes; // Number of nodes in the graph

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.distance = new int[nodes][nodes];

        // Initialize the distance matrix with infinity (or a very large value) for all pairs
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0; // Distance from a node to itself is always 0
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge with the given weight
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            distance[source][dest] = weight;
        }
    }

    public List<Integer> path(int source, int dest) {
        // Reconstruct the shortest path from 'source' to 'dest' using the distance matrix
        List<Integer> pathList = new ArrayList<>();
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            if (distance[source][dest] == Integer.MAX_VALUE) {
                return pathList; // No path exists
            }

            int intermediate = source;
            while (intermediate != dest) {
                pathList.add(intermediate);
                intermediate = nextNode(intermediate, dest);
            }
            pathList.add(dest);
        }
        return pathList;
    }

    private int nextNode(int source, int dest) {
        // Find the next node on the shortest path from 'source' to 'dest'
        int next = -1;
        int shortestDist = distance[source][dest];

        for (int i = 0; i < nodes; i++) {
            if (i != source && i != dest) {
                int totalDist = distance[source][i] + distance[i][dest];
                if (totalDist == shortestDist) {
                    next = i;
                    break;
                }
            }
        }
        return next;
    }

    public void run() {
        // Floyd-Warshall algorithm implementation
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE) {
                        // Check for overflow before updating the distance
                        if (distance[i][k] + distance[k][j] < distance[i][j]) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                        }
                    }
                }
            }
        }
    }
}
