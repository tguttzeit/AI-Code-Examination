package ChatGPT.BreadthFirstSearch.PromptOnly.T7;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GraphTest {
    private Graph breadthFirstSearch;

    @Before
    public void setUp() {
        // Create a new graph with 6 vertices
        breadthFirstSearch = new Graph(6);
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
        int[] expectedParents = {-1, 0, 0, 1, 3, 3};
        int[] actualParents = breadthFirstSearch.bfs(0);
        assertArrayEquals(expectedParents, actualParents);
    }

    @Test
    public void testBFSStartingFromVertex2() {
        int[] expectedParents = {2, 2, -1, 2, 3, 3};
        int[] actualParents = breadthFirstSearch.bfs(2);
        assertArrayEquals(expectedParents, actualParents);
    }

    @Test
    public void testBFSStartingFromVertex4() {
        int[] expectedParents = {3, 3, 3, 3, -1, 3};
        int[] actualParents = breadthFirstSearch.bfs(4);
        assertArrayEquals(expectedParents, actualParents);
    }

    @Test
    public void testAddEdge() {
        breadthFirstSearch.addEdge(1, 2);
        int[] expectedParents = {-1, 1, 1, 2, 3, 3};
        int[] actualParents = breadthFirstSearch.bfs(0); // Re-run BFS from vertex 0
        assertArrayEquals(expectedParents, actualParents);
    }
}
