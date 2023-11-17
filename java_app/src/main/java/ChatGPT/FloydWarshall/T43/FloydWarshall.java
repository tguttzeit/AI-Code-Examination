package ChatGPT.FloydWarshall.T43;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] distance;
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.distance = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE / 2);
            distance[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        if (source >= 0 && source < nodes && dest >= 0 && dest < nodes) {
            distance[source][dest] = weight;
        } else {
            throw new IllegalArgumentException("Invalid source or destination node.");
        }
    }

    public List<Integer> path(int source, int dest) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid source or destination node.");
        }

        if (distance[source][dest] == Integer.MAX_VALUE / 2) {
            return null; // No path exists
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
        int minDist = Integer.MAX_VALUE;
        int nextNode = -1;

        for (int i = 0; i < nodes; i++) {
            if (i != source && distance[source][i] + distance[i][dest] < minDist) {
                minDist = distance[source][i] + distance[i][dest];
                nextNode = i;
            }
        }

        return nextNode;
    }

    public void run() {
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }
}
