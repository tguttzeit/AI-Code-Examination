package Copilot.BreadthFirstSearch.PromptOnly.T9;

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
        int[] expected = {-1, 0, 0, 1, 3, 3};
        int[] actual = breadthFirstSearch.bfs(0);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testBFS2() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(1, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 4);
        breadthFirstSearch.addEdge(2, 5);
        breadthFirstSearch.addEdge(3, 5);
        int[] expected = {-1, 0, 0, 1, 2, 2};
        int[] actual = breadthFirstSearch.bfs(1);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void testBFS3() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(0, 3);
        breadthFirstSearch.addEdge(0, 4);
        breadthFirstSearch.addEdge(0, 5);
        int[] expected = {-1, 0, 0, 0, 0, 0};
        int[] actual = breadthFirstSearch.bfs(0);
        assertArrayEquals(expected, actual);
    }



}