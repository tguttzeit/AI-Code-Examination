package ChatGPT.BreadthFirstSearch.AIGenerated.T7;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
        int[] parent = breadthFirstSearch.bfs(0);
        int[] expectedParent = {-1, 0, 0, 1, 3, 3};
        assertArrayEquals(expectedParent, parent);
    }

    @Test
    public void testBFSStartingFromNode1() {
        int[] parent = breadthFirstSearch.bfs(1);
        int[] expectedParent = {-1, -1, 1, 0, 3, 3};
        assertArrayEquals(expectedParent, parent);
    }

    @Test
    public void testBFSStartingFromNode4() {
        int[] parent = breadthFirstSearch.bfs(4);
        int[] expectedParent = {-1, -1, -1, -1, -1, 3};
        assertArrayEquals(expectedParent, parent);
    }
}
