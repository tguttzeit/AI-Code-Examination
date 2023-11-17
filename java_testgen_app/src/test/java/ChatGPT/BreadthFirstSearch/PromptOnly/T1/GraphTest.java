package ChatGPT.BreadthFirstSearch.PromptOnly.T1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class GraphTest {
    private Graph breadthFirstSearch;

    @Before
    public void setUp() {
        // Create a graph with 6 vertices
        breadthFirstSearch = new Graph(6);
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
        int[] actualParents = breadthFirstSearch.bfs(0);
        assertArrayEquals(expectedParents, actualParents);
    }

    @Test
    public void testBFSWithSourceVertex1() {
        int[] expectedParents = {1, -1, 0, -1, 3, 3};
        int[] actualParents = breadthFirstSearch.bfs(1);
        assertArrayEquals(expectedParents, actualParents);
    }

    @Test
    public void testBFSWithSourceVertex3() {
        int[] expectedParents = {1, 2, 0, -1, 3, 3};
        int[] actualParents = breadthFirstSearch.bfs(3);
        assertArrayEquals(expectedParents, actualParents);
    }
}
