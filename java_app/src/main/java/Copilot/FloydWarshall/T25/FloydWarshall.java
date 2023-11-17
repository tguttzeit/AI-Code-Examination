package Copilot.FloydWarshall.T25;

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
		
		for (int i = 0; i < nodes; i++) {
			for (int j = 0; j < nodes; j++) {
				this.dist[i][j] = Integer.MAX_VALUE / 2;
				this.next[i][j] = -1;
			}
		}
	}
	
	public void addEdge(int source, int dest, int weight) {
		this.dist[source][dest] = weight;
		this.next[source][dest] = dest;
	}
	
	public List<Integer> path(int source, int dest) {
		List<Integer> path = new ArrayList<>();
		if (this.next[source][dest] == -1) {
			return path;
		}
		
		path.add(source);
		while (source != dest) {
			source = this.next[source][dest];
			path.add(source);
		}
		
		return path;
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
