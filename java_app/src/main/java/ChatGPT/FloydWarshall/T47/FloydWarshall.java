package ChatGPT.FloydWarshall.T47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] distanceMatrix;
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.distanceMatrix = new int[nodes][nodes];

        // Initialize the distance matrix with initial values
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(distanceMatrix[i], Integer.MAX_VALUE);
            distanceMatrix[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge with the given weight to the distance matrix
        distanceMatrix[source][dest] = weight;
    }

    public List<Integer> path(int source, int dest) {
        // Return the shortest path from source to dest using the Floyd-Warshall algorithm
        if (distanceMatrix[source][dest] == Integer.MAX_VALUE) {
            return null; // There is no path from source to dest
        }

        List<Integer> path = new ArrayList<>();
        path.add(source);

        while (source != dest) {
            source = nextNode(source, dest);
            path.add(source);
        }

        return path;
    }

    private int nextNode(int source, int dest) {
        // Find the next intermediate node on the shortest path
        int next = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < nodes; i++) {
            if (i != source && i != dest) {
                int dist = distanceMatrix[source][i] + distanceMatrix[i][dest];
                if (dist < minDist) {
                    minDist = dist;
                    next = i;
                }
            }
        }

        return next;
    }

    public void run() {
        // Run the Floyd-Warshall algorithm to compute shortest paths
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (distanceMatrix[i][k] != Integer.MAX_VALUE && distanceMatrix[k][j] != Integer.MAX_VALUE) {
                        int newDist = distanceMatrix[i][k] + distanceMatrix[k][j];
                        if (newDist < distanceMatrix[i][j]) {
                            distanceMatrix[i][j] = newDist;
                        }
                    }
                }
            }
        }
    }
}
