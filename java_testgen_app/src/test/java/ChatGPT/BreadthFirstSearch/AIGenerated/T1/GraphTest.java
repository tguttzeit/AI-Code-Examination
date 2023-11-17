package ChatGPT.BreadthFirstSearch.AIGenerated.T1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {
    private Graph breadthFirstSearch;

    @Before
    public void setUp() {
        breadthFirstSearch = new Graph(6); // Create a graph with 6 vertices

        // Build the graph with the specified edges
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);
    }

    @Test
    public void testBFSStartingFromVertex0() {
        int[] expectedParent = {-1, 0, 0, 1, 3, 3};
        int[] actualParent = breadthFirstSearch.bfs(0);
        assertArrayEquals(expectedParent, actualParent);
    }

    @Test
    public void testBFSStartingFromVertex1() {
        int[] expectedParent = {1, -1, 0, 1, 3, 3};
        int[] actualParent = breadthFirstSearch.bfs(1);
        assertArrayEquals(expectedParent, actualParent);
    }

    @Test
    public void testBFSStartingFromVertex5() {
        int[] expectedParent = {3, -1, 2, 3, 3, -1};
        int[] actualParent = breadthFirstSearch.bfs(5);
        assertArrayEquals(expectedParent, actualParent);
    }
}
