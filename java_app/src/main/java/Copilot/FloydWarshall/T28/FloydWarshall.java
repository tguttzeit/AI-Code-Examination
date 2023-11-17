package Copilot.FloydWarshall.T28;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
	private int[][] pred;
	private int nodes;
	private final static int INF = 999;

	public FloydWarshall(int nodes) {
		this.nodes = nodes;
		dist = new int[nodes][nodes];
		pred = new int[nodes][nodes];
	}

	public void addEdge(int source, int dest, int weight) {
		dist[source][dest] = weight;
		pred[source][dest] = source;
	}

	public List<Integer> path(int source, int dest) {
		List<Integer> path = new ArrayList<>();
		if (dist[source][dest] == INF) {
			return path;
		}
		path.add(dest);
		while (source != dest) {
			dest = pred[source][dest];
			path.add(0, dest);
		}
		return path;
	}

	public void run() {
		for (int k = 0; k < nodes; k++) {
			for (int i = 0; i < nodes; i++) {
				for (int j = 0; j < nodes; j++) {
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						pred[i][j] = pred[k][j];
					}
				}
			}
		}
	}
}
