package ChatGPT.FloydWarshall.T49;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int nodes;
    private int[][] dist;
    private int[][] next;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];

        // Initialize the distance matrix with maximum values
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                dist[i][j] = Integer.MAX_VALUE / 2; // To avoid overflow during addition
                next[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge to the distance matrix
        dist[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        List<Integer> pathList = new ArrayList<>();
        if (dist[source][dest] == Integer.MAX_VALUE / 2) {
            // There is no path from source to destination
            return pathList;
        }

        int intermediate = next[source][dest];
        if (intermediate == -1) {
            // Direct edge from source to destination
            pathList.add(source);
            pathList.add(dest);
            return pathList;
        }

        // Recursively find the path
        pathList.addAll(path(source, intermediate));
        pathList.remove(pathList.size() - 1); // Remove the duplicate intermediate node
        pathList.addAll(path(intermediate, dest));
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
