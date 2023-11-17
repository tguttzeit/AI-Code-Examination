package ChatGPT.BreadthFirstSearch.PromptOnly.T5;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {
    private Graph breadthFirstSearch;

    @Before
    public void setUp() {
        // Create a graph with 6 vertices
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
        int[] parentNodes = breadthFirstSearch.bfs(0);
        // Verify that the parent nodes are as expected
        assertArrayEquals(new int[]{-1, 0, 0, 1, -1, -1}, parentNodes);
    }

    @Test
    public void testBFSStartingFromVertex3() {
        int[] parentNodes = breadthFirstSearch.bfs(3);
        // Verify that the parent nodes are as expected
        assertArrayEquals(new int[]{-1, -1, -1, 3, 3, 3}, parentNodes);
    }

    @Test
    public void testAddEdge() {
        breadthFirstSearch.addEdge(4, 5);
        int[] parentNodes = breadthFirstSearch.bfs(4);
        // Verify that the parent nodes are as expected after adding an edge
        assertArrayEquals(new int[]{-1, -1, -1, -1, 4, 4}, parentNodes);
    }
}
