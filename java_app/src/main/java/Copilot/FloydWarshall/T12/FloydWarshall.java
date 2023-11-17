package Copilot.FloydWarshall.T12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
	private int[][] next;
	
	public FloydWarshall(int nodes) {
		dist = new int[nodes][nodes];
		next = new int[nodes][nodes];
		for (int i = 0; i < nodes; i++) {
			for (int j = 0; j < nodes; j++) {
				next[i][j] = j;
				if (i == j) {
					dist[i][j] = 0;
				} else {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}
	}
	
	public void addEdge(int source, int dest, int weight) {
		dist[source][dest] = weight;
	}
	
	public void run() {
		for (int k = 0; k < dist.length; k++) {
			for (int i = 0; i < dist.length; i++) {
				for (int j = 0; j < dist.length; j++) {
					if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
						continue;
					}
					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
						next[i][j] = next[i][k];
					}
				}
			}
		}
	}
	
	public List<Integer> path(int source, int dest) {
		List<Integer> path = new ArrayList<>();
		if (dist[source][dest] == Integer.MAX_VALUE) {
			return path;
		}
		path.add(source);
		while (source != dest) {
			source = next[source][dest];
			path.add(source);
		}
		return path;
	}
}
