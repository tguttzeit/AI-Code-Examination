package Copilot.BreadthFirstSearch.PromptOnly.T3;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GraphTest {

    @Test
    public void testAddEdge() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);
    }

    @Test
    public void testBfs() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);
        breadthFirstSearch.bfs(0);
        int[] expected = { -1, 0, 0, 1, 3, 3 };
        int[] actual = breadthFirstSearch.bfs(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBfs2() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);
        breadthFirstSearch.bfs(1);
        int[] expected = { -1, -1, 1, -1, 3, 3 };
        int[] actual = breadthFirstSearch.bfs(1);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBfs3() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);
        breadthFirstSearch.bfs(2);
        int[] expected = { -1, -1, -1, 2, 2 };
    }

}