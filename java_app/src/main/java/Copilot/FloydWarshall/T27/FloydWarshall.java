package Copilot.FloydWarshall.T27;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
	private int[][] next;
	private int nodes;
	private int INF = Integer.MAX_VALUE;
	
	public FloydWarshall(int nodes) {
		this.nodes = nodes;
		dist = new int[nodes][nodes];
		next = new int[nodes][nodes];
		for(int i = 0; i < nodes; i++) {
			for(int j = 0; j < nodes; j++) {
				dist[i][j] = INF;
				next[i][j] = INF;
			}
		}
	}
	
	public void addEdge(int source, int dest, int weight) {
		dist[source][dest] = weight;
		next[source][dest] = dest;
	}
	
	public List<Integer> path(int source, int dest) {
		List<Integer> path = new ArrayList<>();
		if(dist[source][dest] == INF) {
			return path;
		}
		int curr = source;
		while(curr != dest) {
			path.add(curr);
			curr = next[curr][dest];
		}
		path.add(curr);
		return path;
	}
	
	public void run() {
		for(int i = 0; i < nodes; i++) {
			for(int j = 0; j < nodes; j++) {
				for(int k = 0; k < nodes; k++) {
					if(dist[j][i] == INF || dist[i][k] == INF) {
						continue;
					}
					if(dist[j][k] > dist[j][i] + dist[i][k]) {
						dist[j][k] = dist[j][i] + dist[i][k];
						next[j][k] = next[j][i];
					}
				}
			}
		}
	}
}
