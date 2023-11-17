package ChatGPT.BreadthFirstSearch.BookExampleCode.T3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {
    private Graph breadthFirstSearch;

    @Before
    public void setUp() {
        breadthFirstSearch = new Graph(6); // Create a graph with 6 nodes
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);
    }

    @Test
    public void testBFSStartingFromNode0() {
        int[] expectedParent = {-1, 0, 0, 1, 3, 3};
        int[] resultParent = breadthFirstSearch.bfs(0);
        assertArrayEquals(expectedParent, resultParent);
    }

    @Test
    public void testBFSStartingFromNode1() {
        int[] expectedParent = {1, -1, 0, 1, 3, 3};
        int[] resultParent = breadthFirstSearch.bfs(1);
        assertArrayEquals(expectedParent, resultParent);
    }

    @Test
    public void testBFSStartingFromNode3() {
        int[] expectedParent = {1, -1, 0, -1, 3, 3};
        int[] resultParent = breadthFirstSearch.bfs(3);
        assertArrayEquals(expectedParent, resultParent);
    }
}
