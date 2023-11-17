package Copilot.FloydWarshall.T39;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
	private int[][] next;
	private int nodes;
	private boolean hasRun;
	public FloydWarshall(int nodes) {
		this.nodes = nodes;
		this.dist = new int[nodes][nodes];
		this.next = new int[nodes][nodes];
		this.hasRun = false;
	}
	public void addEdge(int source, int dest, int weight) {
		this.dist[source][dest] = weight;
	}
	public List<Integer> path(int source, int dest) {
		if (!this.hasRun) {
			this.run();
		}
		if (this.dist[source][dest] == Integer.MAX_VALUE) {
			return null;
		}
		List<Integer> path = new ArrayList<>();
		path.add(source);
		while (source != dest) {
			source = this.next[source][dest];
			path.add(source);
		}
		return path;
	}
	public void run() {
		for (int i = 0; i < this.nodes; i++) {
			for (int j = 0; j < this.nodes; j++) {
				if (i == j) {
					this.next[i][j] = -1;
				} else {
					this.next[i][j] = j;
				}
				if (this.dist[i][j] == 0 && i != j) {
					this.dist[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		for (int k = 0; k < this.nodes; k++) {
			for (int i = 0; i < this.nodes; i++) {
				for (int j = 0; j < this.nodes; j++) {
					if (this.dist[i][k] != Integer.MAX_VALUE && this.dist[k][j] != Integer.MAX_VALUE && this.dist[i][j] > this.dist[i][k] + this.dist[k][j]) {
						this.dist[i][j] = this.dist[i][k] + this.dist[k][j];
						this.next[i][j] = this.next[i][k];
					}
				}
			}
		}
		this.hasRun = true;
	}
}
