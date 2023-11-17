package Copilot.BreadthFirstSearch.AIGenerated.T1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {
    @Test
    public void testBfs() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);

        int[] parent = breadthFirstSearch.bfs(0);
        assertEquals(0, parent[0]);
        assertEquals(0, parent[1]);
        assertEquals(0, parent[2]);
        assertEquals(1, parent[3]);
        assertEquals(3, parent[4]);
        assertEquals(3, parent[5]);
    }


}