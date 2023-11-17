package Copilot.BreadthFirstSearch.T26;

import java.util.*;

public class Graph {
        // instance variables
        private int vertices;
        private LinkedList<Integer> adjListArray[];
    
        // constructor
        Graph(int vertices) {
            this.vertices = vertices;
            adjListArray = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjListArray[i] = new LinkedList<>();
            }
        }
    
        // instance methods
        public void addEdge(int src, int dest) {
            adjListArray[src].add(dest);
            adjListArray[dest].add(src);
        }
    
        public int[] bfs(int sourceVertex) {
            // this method should return an integer array of parent nodes for each vertex
            // in the graph. The array of parent node values are all initialized to -1 in
            // the bfs(int sourceVertex) method.
            int[] parent = new int[vertices];
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<Integer>();
            queue.add(sourceVertex);
            visited[sourceVertex] = true;
            parent[sourceVertex] = -1;
    
            while (!queue.isEmpty()) {
                int currentVertex = queue.remove();
                for (int adjacentVertex : adjListArray[currentVertex]) {
                    if (!visited[adjacentVertex]) {
                        visited[adjacentVertex] = true;
                        queue.add(adjacentVertex);
                        parent[adjacentVertex] = currentVertex;
                    }
                }
            }
            return parent;
        }
}