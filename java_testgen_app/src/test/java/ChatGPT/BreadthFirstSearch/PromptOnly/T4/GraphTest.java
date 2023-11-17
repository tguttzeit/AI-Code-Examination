package ChatGPT.BreadthFirstSearch.PromptOnly.T4;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

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
    public void testBFS() {
        int[] parentNodes = breadthFirstSearch.bfs(0);
        int[] expectedParents = {-1, 0, 0, 1, 3, 3};
        assertArrayEquals(expectedParents, parentNodes);
    }

    @Test
    public void testAddEdge() {
        breadthFirstSearch.addEdge(1, 2);
        int[] parentNodes = breadthFirstSearch.bfs(0);
        int[] expectedParents = {-1, 0, 0, 1, 3, 3};
        assertArrayEquals(expectedParents, parentNodes);
    }

    @Test
    public void testBFSWithDisconnectedGraph() {
        Graph disconnectedGraph = new Graph(6);
        disconnectedGraph.addEdge(0, 1);
        disconnectedGraph.addEdge(2, 4);

        int[] parentNodes = disconnectedGraph.bfs(0);
        int[] expectedParents = {-1, 0, -1, -1, -1, -1};
        assertArrayEquals(expectedParents, parentNodes);
    }
}
