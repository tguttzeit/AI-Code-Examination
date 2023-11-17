package ChatGPT.FloydWarshall.T36;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] graph; // Adjacency matrix to represent the graph
    private int nodes;     // Number of nodes in the graph

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.graph = new int[nodes][nodes];

        // Initialize the adjacency matrix with maximum values
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0; // Distance from a node to itself is 0
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Add an edge with the given weight to the adjacency matrix
        graph[source][dest] = weight;
    }

    public List<Integer> path(int source, int dest) {
        // Initialize the path list
        List<Integer> path = new ArrayList<>();

        // If there is no path from source to dest, return an empty list
        if (graph[source][dest] == Integer.MAX_VALUE) {
            return path;
        }

        // Backtrack to find the shortest path
        int current = source;
        while (current != dest) {
            path.add(current);
            for (int next = 0; next < nodes; next++) {
                if (graph[current][next] != Integer.MAX_VALUE && graph[next][dest] != Integer.MAX_VALUE &&
                        graph[current][dest] == graph[current][next] + graph[next][dest]) {
                    current = next;
                    break;
                }
            }
        }

        // Add the destination node to the path
        path.add(dest);

        return path;
    }

    public void run() {
        // Perform the Floyd-Warshall algorithm
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE &&
                            graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }
}
