package Copilot.BreadthFirstSearch.PromptOnly.T1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {
    Graph breadthFirstSearch = new Graph(6);
    @Test
    public void testBFS() {
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);
        int[] bfs = breadthFirstSearch.bfs(0);
        assertEquals(bfs[0], -1);
        assertEquals(bfs[1], 0);
        assertEquals(bfs[2], 0);
        assertEquals(bfs[3], 1);
        assertEquals(bfs[4], 3);
        assertEquals(bfs[5], 3);
    }
    @Test
    public void testBFS1() {
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);
        int[] bfs = breadthFirstSearch.bfs(1);
        assertEquals(bfs[0], 1);
        assertEquals(bfs[1], -1);
        assertEquals(bfs[2], 0);
        assertEquals(bfs[3], 1);
        assertEquals(bfs[4], 3);
        assertEquals(bfs[5], 3);
    }
    @Test
    public void testBFS2() {
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);
        int[] bfs = breadthFirstSearch.bfs(3);
        assertEquals(bfs[0], 2);
        assertEquals(bfs[1], 3);
        assertEquals(bfs[2], 0);
        assertEquals(bfs[3], -1);
        assertEquals(bfs[4], 3);
        assertEquals(bfs[5], 3);
    }


}