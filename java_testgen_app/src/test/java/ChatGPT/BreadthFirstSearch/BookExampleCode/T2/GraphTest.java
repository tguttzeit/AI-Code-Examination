package ChatGPT.BreadthFirstSearch.BookExampleCode.T2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {
    private Graph breadthFirstSearch;

    @Before
    public void setUp() {
        // Create a graph with the specified edges
        breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);
    }

    @Test
    public void testBFSStartingFromNode0() {
        int[] result = breadthFirstSearch.bfs(0);
        int[] expected = {-1, 0, 0, 1, 3, 3};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testBFSStartingFromNode1() {
        int[] result = breadthFirstSearch.bfs(1);
        int[] expected = {-1, 1, -1, 0, 3, 3};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testBFSStartingFromNode4() {
        int[] result = breadthFirstSearch.bfs(4);
        int[] expected = {-1, -1, -1, -1, 4, -1};
        assertArrayEquals(expected, result);
    }
}
