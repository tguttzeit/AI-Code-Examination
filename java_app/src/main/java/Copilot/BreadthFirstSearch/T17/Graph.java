package Copilot.BreadthFirstSearch.T17;


public class Graph {
    private int vertices;
    private int[][] adjMatrix;
    private int[] parent;
    
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjMatrix = new int[vertices][vertices];
        this.parent = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            parent[i] = -1;
        }
    }
    
    public int[] bfs(int sourceVertex) {
        // YOUR CODE HERE
        // Create a queue of integers to store the vertices to visit.
        // Create a boolean array to store which vertices have been visited.
        // Enqueue the source vertex.
        // Mark the source vertex as visited.
        // While the queue is not empty:
        // Dequeue the first vertex from the queue.
        // For each vertex that is adjacent to the current vertex:
        // If the vertex has not been visited:
        // Enqueue the vertex.
        // Mark the vertex as visited.
        // Set the parent of the vertex to the current vertex.
        // Return the array of parent node values.
        return parent;
    }
    
    public void addEdge(int v1, int v2) {
        adjMatrix[v1][v2] = 1;
    }
    
    public String toString() {
        String result = "";
        for (int[] row : adjMatrix) {
            for (int element : row) {
                result += element + " ";
            }
            result += "\n";
        }
        return result;
    }

}