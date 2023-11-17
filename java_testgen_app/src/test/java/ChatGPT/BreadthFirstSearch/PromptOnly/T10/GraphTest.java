package ChatGPT.BreadthFirstSearch.PromptOnly.T10;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class GraphTest {
    private Graph breadthFirstSearch;

    @Before
    public void setUp() {
        // Initialize the graph with 6 vertices
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
    public void testBFSWithSourceVertex0() {
        int[] expectedParents = {-1, 0, 0, 1, 3, 3};
        int[] parents = breadthFirstSearch.bfs(0);
        assertArrayEquals(expectedParents, parents);
    }

    @Test
    public void testBFSWithSourceVertex1() {
        int[] expectedParents = {1, -1, 0, -1, 3, 3};
        int[] parents = breadthFirstSearch.bfs(1);
        assertArrayEquals(expectedParents, parents);
    }

    @Test
    public void testBFSWithSourceVertex4() {
        int[] expectedParents = {-1, -1, -1, -1, -1, -1};
        int[] parents = breadthFirstSearch.bfs(4);
        assertArrayEquals(expectedParents, parents);
    }
}
