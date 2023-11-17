package ChatGPT.BreadthFirstSearch.AIGenerated.T3;

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
    public void testBFSStartingFromVertex0() {
        int[] expectedParent = {-1, 0, 0, 1, 3, 3};
        int[] actualParent = breadthFirstSearch.bfs(0);
        assertArrayEquals(expectedParent, actualParent);
    }

    @Test
    public void testBFSStartingFromVertex1() {
        int[] expectedParent = {1, -1, 0, -1, 3, 3};
        int[] actualParent = breadthFirstSearch.bfs(1);
        assertArrayEquals(expectedParent, actualParent);
    }

    @Test
    public void testBFSStartingFromVertex4() {
        int[] expectedParent = {-1, -1, -1, 3, -1, 3};
        int[] actualParent = breadthFirstSearch.bfs(4);
        assertArrayEquals(expectedParent, actualParent);
    }
}
