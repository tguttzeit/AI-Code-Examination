package ChatGPT.FloydWarshall.T18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] dist; // Distance matrix
    private int[][] next; // Next node matrix
    private int nodes; // Number of nodes in the graph

    // Constructor to initialize the FloydWarshall class with the number of nodes
    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];

        // Initialize the distance and next matrices
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2); // Initialize distances to infinity
            Arrays.fill(next[i], -1); // Initialize next nodes to -1
            dist[i][i] = 0; // Distance from a node to itself is 0
        }
    }

    // Add an edge to the graph with a given source, destination, and weight
    public void addEdge(int source, int dest, int weight) {
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            dist[source][dest] = weight;
            next[source][dest] = dest;
        } else {
            throw new IllegalArgumentException("Invalid source or destination node");
        }
    }

    // Run the Floyd Warshall algorithm to compute shortest paths
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

    // Get the shortest path from source to destination as a list of nodes
    public List<Integer> path(int source, int dest) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid source or destination node");
        }
        
        List<Integer> pathList = new ArrayList<>();
        if (dist[source][dest] == Integer.MAX_VALUE / 2) {
            // No path exists
            return pathList;
        }

        int current = source;
        while (current != dest) {
            pathList.add(current);
            current = next[current][dest];
        }
        pathList.add(dest);
        return pathList;
    }
}
