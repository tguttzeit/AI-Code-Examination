package Copilot.BreadthFirstSearch.T40;

import java.util.*;

public class Graph {
    int vertices;
    ArrayList<Integer>[] adjList;

    public Graph(int vertices){
        this.vertices = vertices;
        adjList = new ArrayList[vertices];
        for(int i = 0; i < vertices; i++)
            adjList[i] = new ArrayList<>();
    }

    public void addEdge(int source, int destination){
        adjList[source].add(destination);
    }

    public int[] bfs(int sourceVertex){
        // Implement the bfs(int sourceVertex) method. The method should return an integer array of parent nodes for each vertex in the graph. The array of parent node values are all initialized to -1 in the bfs(int sourceVertex) method.
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[sourceVertex] = true;
        queue.add(sourceVertex);
        while(!queue.isEmpty()){
            int current = queue.remove();
            for(int neighbor: adjList[current]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }
        return parent;
    }
}