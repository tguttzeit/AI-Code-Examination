package ChatGPT.BreadthFirstSearch.BookExampleCode.T7;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    private Graph breadthFirstSearch;

    @Before
    public void setUp() {
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
        int[] expectedParent = { -1, 0, 0, 1, 3, 3 };
        int[] result = breadthFirstSearch.bfs(0);
        assertArrayEquals(expectedParent, result);
    }

    @Test
    public void testBFSStartingFromNode1() {
        int[] expectedParent = { 1, -1, 0, 1, 3, 3 };
        int[] result = breadthFirstSearch.bfs(1);
        assertArrayEquals(expectedParent, result);
    }

    @Test
    public void testBFSStartingFromNode3() {
        int[] expectedParent = { 1, 2, 3, -1, 3, 3 };
        int[] result = breadthFirstSearch.bfs(3);
        assertArrayEquals(expectedParent, result);
    }
}
