package ChatGPT.BreadthFirstSearch.PromptOnly.T2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    private Graph breadthFirstSearch;

    @Before
    public void setUp() {
        // Initialize a new graph with 6 vertices
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
    public void testBFSStartingFromNode0() {
        int[] expectedParents = {-1, 0, 0, 1, 3, 3};
        int[] actualParents = breadthFirstSearch.bfs(0);
        assertArrayEquals(expectedParents, actualParents);
    }

    @Test
    public void testBFSStartingFromNode3() {
        int[] expectedParents = {-1, -1, 2, -1, 3, 3};
        int[] actualParents = breadthFirstSearch.bfs(3);
        assertArrayEquals(expectedParents, actualParents);
    }

    @Test
    public void testAddEdge() {
        // Add a new edge
        breadthFirstSearch.addEdge(4, 5);

        // Check if the edge was added successfully
        int[] expectedParents = {-1, 0, 0, 1, 3, 4};
        int[] actualParents = breadthFirstSearch.bfs(0);
        assertArrayEquals(expectedParents, actualParents);
    }
}
