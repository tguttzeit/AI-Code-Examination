package Copilot.BreadthFirstSearch.BookExampleCode.T5;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GraphTest {

    @Test
    public void testBreadthFirstSearch() {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        int[] expected = new int[]{-1, 0, 0, 1, 3, 3};
        int[] actual = g.bfs(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBreadthFirstSearchWithDisconnectedGraph() {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        int[] expected = new int[]{-1, 0, 0, -1, 3, 3};
        int[] actual = g.bfs(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBreadthFirstSearchWithSelfLoops() {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 1);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        int[] expected = new int[]{-1, 0, 0, 1, 3, 3};
        int[] actual = g.bfs(0);
        assertArrayEquals(expected, actual);
    }





}