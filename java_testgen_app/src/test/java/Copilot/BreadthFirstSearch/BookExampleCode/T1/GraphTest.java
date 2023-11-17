package Copilot.BreadthFirstSearch.BookExampleCode.T1;

import static org.junit.Assert.assertEquals;

public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        int[] parent = graph.bfs(0);
        assertEquals(0, parent[0]);
        assertEquals(0, parent[1]);
        assertEquals(0, parent[2]);
        assertEquals(1, parent[3]);
        assertEquals(3, parent[4]);
        assertEquals(3, parent[5]);
    }

}