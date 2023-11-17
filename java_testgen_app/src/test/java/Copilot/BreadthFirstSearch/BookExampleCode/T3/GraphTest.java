package Copilot.BreadthFirstSearch.BookExampleCode.T3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GraphTest {

    private Graph breadthFirstSearch;

    @Before
    public void init() {
        breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);
    }

    @Test
    public void testBFS() {
        int[] expected = { -1, 0, 0, 2, 3, 3 };
        int[] actual = breadthFirstSearch.bfs(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBFS2() {
        int[] expected = { -1, -1, 0, 1, 2, 3 };
        int[] actual = breadthFirstSearch.bfs(2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBFS3() {
        int[] expected = { -1, 1, 1, 3, 3, 3 };
        int[] actual = breadthFirstSearch.bfs(1);
        assertArrayEquals(expected, actual);
    }


}