package ChatGPT.BreadthFirstSearch.BookExampleCode.T8;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {
    private Graph breadthFirstSearch;

    @Before
    public void setUp() {
        // Build the graph with the specified edges
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
        int[] parent = breadthFirstSearch.bfs(0);
        assertArrayEquals(new int[]{-1, 0, 0, 1, 3, 3}, parent);
    }

    @Test
    public void testBFSStartingFromNode1() {
        int[] parent = breadthFirstSearch.bfs(1);
        assertArrayEquals(new int[]{1, -1, 0, 1, 3, 3}, parent);
    }

    @Test
    public void testBFSStartingFromNode3() {
        int[] parent = breadthFirstSearch.bfs(3);
        assertArrayEquals(new int[]{2, 2, 3, -1, 3, 3}, parent);
    }
}
