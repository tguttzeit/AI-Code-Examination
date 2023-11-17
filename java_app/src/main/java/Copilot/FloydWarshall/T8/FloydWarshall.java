package Copilot.FloydWarshall.T8;

import java.util.ArrayList;
import java.util.List;

public class FloydWarshall {
    public int[][] matrix;
	public int[][] next;
	public int nodes;
	public int edges;
	public int INF = 9999999;
	
	public FloydWarshall(int nodes) {
		this.nodes = nodes;
		matrix = new int[nodes][nodes];
		next = new int[nodes][nodes];
		for(int i = 0; i < nodes; i++) {
			for(int j = 0; j < nodes; j++) {
				if(i == j) {
					matrix[i][j] = 0;
				} else {
					matrix[i][j] = INF;
				}
				next[i][j] = j;
			}
		}
	}
	
	public void addEdge(int source, int dest, int weight) {
		matrix[source][dest] = weight;
	}
	
	public void run() {
		for(int k = 0; k < nodes; k++) {
			for(int i = 0; i < nodes; i++) {
				for(int j = 0; j < nodes; j++) {
					if(matrix[i][k] + matrix[k][j] < matrix[i][j]) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
						next[i][j] = next[i][k];
					}
				}
			}
		}
	}
	
	public List<Integer> path(int source, int dest) {
		List<Integer> path = new ArrayList<>();
		int curr = source;
		while(curr != dest) {
			path.add(curr);
			curr = next[curr][dest];
		}
		path.add(curr);
		return path;
	}
}
