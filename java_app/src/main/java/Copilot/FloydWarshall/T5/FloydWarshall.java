package Copilot.FloydWarshall.T5;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    private int[][] dist;
	private int[][] next;
	private int nodes;
	private boolean solved;
	
	public FloydWarshall(int nodes) {
		this.nodes = nodes;
		this.dist = new int[nodes][nodes];
		this.next = new int[nodes][nodes];
	}
	
	public void addEdge(int source, int dest, int weight) {
		this.dist[source][dest] = weight;
		this.next[source][dest] = dest;
	}
	
	public List<Integer> path(int source, int dest){
		if(!solved) {
			run();
		}
		List<Integer> path = new ArrayList<>();
		if(dist[source][dest] == Integer.MAX_VALUE) {
			return path;
		}
		int at = source;
		for(;at != dest; at = next[at][dest]) {
			if(at == Integer.MAX_VALUE) {
				return null;
			}
			path.add(at);
		}
		if(next[at][dest] == Integer.MAX_VALUE) {
			return null;
		}
		path.add(dest);
		return path;
	}
	
	public void run() {
		for(int i = 0; i < nodes; i++) {
			for(int j = 0; j < nodes; j++) {
				if(dist[i][j] == 0) {
					dist[i][j] = Integer.MAX_VALUE;
				}
				if(i == j) {
					dist[i][j] = 0;
				}
				next[i][j] = j;
			}
		}
		for(int k = 0; k < nodes; k++) {
			for(int i = 0; i < nodes; i++) {
				for(int j = 0; j < nodes; j++) {
					if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
						continue;
					}
					int newDist = dist[i][k] + dist[k][j];
					if(newDist < dist[i][j]) {
						dist[i][j] = newDist;
						next[i][j] = next[i][k];
					}
				}
			}
		}
		solved = true;
	}
}
