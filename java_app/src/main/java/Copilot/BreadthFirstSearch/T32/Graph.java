package Copilot.BreadthFirstSearch.T32;


import java.util.*;

public class Graph{
    private int vertices;
    private LinkedList<Integer> edges[];
    private int[] parents;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        edges = new LinkedList[vertices];
        parents = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            edges[i] = new LinkedList<Integer>();
            parents[i] = -1;
        }
    }
    
    public void addEdge(int sourceVertex, int targetVertex) {
        edges[sourceVertex].add(targetVertex);
    }
    
    public int[] bfs(int sourceVertex) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(sourceVertex);
        parents[sourceVertex] = sourceVertex;
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            for (int edge : edges[vertex]) {
                if (parents[edge] == -1) {
                    parents[edge] = vertex;
                    queue.add(edge);
                }
            }
        }
        return parents;
    }
}