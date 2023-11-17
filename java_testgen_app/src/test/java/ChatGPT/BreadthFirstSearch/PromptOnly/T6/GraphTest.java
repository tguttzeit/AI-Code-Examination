package ChatGPT.BreadthFirstSearch.PromptOnly.T6;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphTest {
    private Graph breadthFirstSearch;

    @Before
    public void setUp() {
        // Initialize the graph with 6 vertices
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
        int[] expectedParentNodes = {-1, 0, 0, 1, 3, 3};
        int[] resultParentNodes = breadthFirstSearch.bfs(0);
        assertArrayEquals(expectedParentNodes, resultParentNodes);
    }

    @Test
    public void testBFSStartingFromVertex3() {
        int[] expectedParentNodes = {-1, -1, -1, -1, 3, 3};
        int[] resultParentNodes = breadthFirstSearch.bfs(3);
        assertArrayEquals(expectedParentNodes, resultParentNodes);
    }

    @Test
    public void testBFSStartingFromVertex5() {
        int[] expectedParentNodes = {-1, -1, -1, -1, 3, -1};
        int[] resultParentNodes = breadthFirstSearch.bfs(5);
        assertArrayEquals(expectedParentNodes, resultParentNodes);
    }
}
