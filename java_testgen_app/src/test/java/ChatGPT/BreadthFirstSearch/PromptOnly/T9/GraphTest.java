package ChatGPT.BreadthFirstSearch.PromptOnly.T9;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    private Graph breadthFirstSearch;

    @Before
    public void setUp() {
        // Create a new graph instance before each test case
        breadthFirstSearch = new Graph(6); // Assuming 6 vertices as mentioned
    }

    @Test
    public void testBFSWithSource0() {
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);

        int[] parentNodes = breadthFirstSearch.bfs(0);

        int[] expectedParents = {-1, 0, 0, 1, 3, 3};
        assertArrayEquals(expectedParents, parentNodes);
    }

    @Test
    public void testBFSWithSource3() {
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);

        int[] parentNodes = breadthFirstSearch.bfs(3);

        int[] expectedParents = {-1, -1, -1, 3, 3, 3};
        assertArrayEquals(expectedParents, parentNodes);
    }

    @Test
    public void testNoEdges() {
        // Test with a graph that has no edges
        int[] parentNodes = breadthFirstSearch.bfs(0);

        int[] expectedParents = {-1, -1, -1, -1, -1, -1};
        assertArrayEquals(expectedParents, parentNodes);
    }
}
