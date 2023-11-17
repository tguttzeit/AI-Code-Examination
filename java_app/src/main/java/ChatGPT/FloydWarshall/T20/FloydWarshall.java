package ChatGPT.FloydWarshall.T20;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] graph;
    private int[][] next;
    private int nodes;
    private boolean isExecuted = false;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.graph = new int[nodes][nodes];
        this.next = new int[nodes][nodes];
        
        // Initialize the graph with infinity values and the next array with -1 (indicating no path)
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Integer.MAX_VALUE / 2; // Use a large value as infinity
                }
                next[i][j] = -1;
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid source or destination node");
        }
        
        graph[source][dest] = weight;
    }

    public List<Integer> path(int source, int dest) {
        if (!isExecuted) {
            throw new IllegalStateException("Please run the Floyd Warshall algorithm first.");
        }
        
        List<Integer> pathList = new ArrayList<>();
        if (graph[source][dest] == Integer.MAX_VALUE / 2) {
            // No path exists
            return pathList;
        }
        
        int current = source;
        while (current != dest) {
            if (current == -1) {
                return null; // No path exists
            }
            pathList.add(current);
            current = next[current][dest];
        }
        pathList.add(dest);
        
        return pathList;
    }

    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                        next[i][j] = k;
                    }
                }
            }
        }
        isExecuted = true;
    }
}
