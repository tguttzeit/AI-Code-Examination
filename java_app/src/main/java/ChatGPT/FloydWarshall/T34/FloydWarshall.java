package ChatGPT.FloydWarshall.T34;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] distance;
    private int[][] next;
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.distance = new int[nodes][nodes];
        this.next = new int[nodes][nodes];

        // Initialize the distance matrix with infinity values and next matrix with -1.
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE / 2); // Using a large value to avoid overflow
            Arrays.fill(next[i], -1);
            distance[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        // Adding an edge with a given weight between source and destination.
        distance[source][dest] = weight;
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (distance[source][dest] == Integer.MAX_VALUE / 2) {
            // No path exists between source and destination.
            return null;
        }

        List<Integer> path = new ArrayList<>();
        int current = source;

        while (current != dest) {
            if (current == -1) {
                // There is no path between source and destination.
                return null;
            }
            path.add(current);
            current = next[current][dest];
        }

        path.add(dest);
        return path;
    }

    public void run() {
        // Floyd-Warshall algorithm implementation
        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }
}
