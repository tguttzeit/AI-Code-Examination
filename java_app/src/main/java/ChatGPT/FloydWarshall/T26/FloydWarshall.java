package ChatGPT.FloydWarshall.T26;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] distanceMatrix;
    private int[][] nextNodeMatrix;
    private int numNodes;

    public FloydWarshall(int nodes) {
        this.numNodes = nodes;
        this.distanceMatrix = new int[nodes][nodes];
        this.nextNodeMatrix = new int[nodes][nodes];

        // Initialize the distance matrix with maximum values and the nextNode matrix with -1.
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    distanceMatrix[i][j] = 0;
                    nextNodeMatrix[i][j] = -1;
                } else {
                    distanceMatrix[i][j] = Integer.MAX_VALUE;
                    nextNodeMatrix[i][j] = -1;
                }
            }
        }
    }

    public void addEdge(int source, int dest, int weight) {
        if (source < 0 || source >= numNodes || dest < 0 || dest >= numNodes) {
            throw new IllegalArgumentException("Invalid node indices.");
        }

        distanceMatrix[source][dest] = weight;
        nextNodeMatrix[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (source < 0 || source >= numNodes || dest < 0 || dest >= numNodes) {
            throw new IllegalArgumentException("Invalid node indices.");
        }

        List<Integer> path = new ArrayList<>();
        if (distanceMatrix[source][dest] == Integer.MAX_VALUE) {
            // No path exists
            return path;
        }

        int current = source;
        while (current != dest) {
            path.add(current);
            current = nextNodeMatrix[current][dest];
        }
        path.add(dest);
        return path;
    }

    public void run() {
        for (int k = 0; k < numNodes; k++) {
            for (int i = 0; i < numNodes; i++) {
                for (int j = 0; j < numNodes; j++) {
                    if (distanceMatrix[i][k] != Integer.MAX_VALUE
                            && distanceMatrix[k][j] != Integer.MAX_VALUE
                            && distanceMatrix[i][k] + distanceMatrix[k][j] < distanceMatrix[i][j]) {
                        distanceMatrix[i][j] = distanceMatrix[i][k] + distanceMatrix[k][j];
                        nextNodeMatrix[i][j] = nextNodeMatrix[i][k];
                    }
                }
            }
        }
    }
}
