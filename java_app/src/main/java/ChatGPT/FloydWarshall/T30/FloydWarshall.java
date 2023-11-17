package ChatGPT.FloydWarshall.T30;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
    private int[][] next;
    private int nodes;

    public FloydWarshall(int nodes) {
        this.nodes = nodes;
        this.dist = new int[nodes][nodes];
        this.next = new int[nodes][nodes];

        // Initialize the distance matrix with infinity and next matrix with -1
        for (int i = 0; i < nodes; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2); // Using MAX_VALUE/2 to avoid overflow
            Arrays.fill(next[i], -1);
            dist[i][i] = 0;
        }
    }

    public void addEdge(int source, int dest, int weight) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid source or destination node.");
        }

        dist[source][dest] = Math.min(dist[source][dest], weight);
        next[source][dest] = dest;
    }

    public List<Integer> path(int source, int dest) {
        if (source < 0 || source >= nodes || dest < 0 || dest >= nodes) {
            throw new IllegalArgumentException("Invalid source or destination node.");
        }

        if (dist[source][dest] == Integer.MAX_VALUE / 2) {
            return null; // There is no path from source to destination
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
