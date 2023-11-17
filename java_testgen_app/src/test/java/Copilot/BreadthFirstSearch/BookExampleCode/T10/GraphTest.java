package Copilot.BreadthFirstSearch.BookExampleCode.T10;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GraphTest {
    @Test
    public void testBFS() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);

        int[] parent = breadthFirstSearch.bfs(0);
        int[] expected = {-1, 0, 0, 1, 3, 3};
        assertArrayEquals(expected, parent);
    }

    @Test
    public void testBFS2() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);

        int[] parent = breadthFirstSearch.bfs(3);
        int[] expected = {2, 0, 1, -1, 3, 3};
        assertArrayEquals(expected, parent);
    }

    @Test
    public void testBFS3() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);

        int[] parent = breadthFirstSearch.bfs(5);
        int[] expected = {3, 0, 1, 2, 3, -1};
        assertArrayEquals(expected, parent);
    }




}