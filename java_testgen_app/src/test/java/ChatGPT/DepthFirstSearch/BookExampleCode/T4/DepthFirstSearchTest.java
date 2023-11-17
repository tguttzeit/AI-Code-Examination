package ChatGPT.DepthFirstSearch.BookExampleCode.T4;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DepthFirstSearchTest {

    private DepthFirstSearch dfs;

    @Before
    public void setUp() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList(
                new DepthFirstSearch.Edge(0, 1),
                new DepthFirstSearch.Edge(0, 3),
                new DepthFirstSearch.Edge(1, 4),
                new DepthFirstSearch.Edge(2, 4),
                new DepthFirstSearch.Edge(2, 5),
                new DepthFirstSearch.Edge(3, 1),
                new DepthFirstSearch.Edge(4, 3),
                new DepthFirstSearch.Edge(5, 5),
                new DepthFirstSearch.Edge(6, 6)
        );
        dfs = new DepthFirstSearch(edges, 7); // The second parameter is the number of nodes in the graph
    }

    @Test
    public void testDFS() {
        boolean[] discovered = new boolean[7]; // Assuming 7 nodes in the graph

        dfs.dfs(0, discovered);
        assertTrue(discovered[0]);
        assertTrue(discovered[1]);
        assertTrue(discovered[3]);
        assertTrue(discovered[4]);
        assertTrue(discovered[2]);
        assertTrue(discovered[5]);
        assertFalse(discovered[6]); // Node 6 is not connected to the rest

        List<Integer> expectedVisitedNodes = Arrays.asList(0, 1, 4, 3, 2, 5);
        assertEquals(expectedVisitedNodes, dfs.visitedNodes);
    }

    @Test
    public void testDisconnectedGraph() {
        boolean[] discovered = new boolean[7]; // Assuming 7 nodes in the graph

        dfs.dfs(6, discovered); // Starting from a disconnected node
        assertTrue(discovered[6]);
        assertFalse(discovered[0]);
        assertFalse(discovered[1]);
        assertFalse(discovered[3]);
        assertFalse(discovered[4]);
        assertFalse(discovered[2]);
        assertFalse(discovered[5]);

        List<Integer> expectedVisitedNodes = Arrays.asList(6);
        assertEquals(expectedVisitedNodes, dfs.visitedNodes);
    }

    @Test
    public void testEmptyGraph() {
        DepthFirstSearch emptyDFS = new DepthFirstSearch(Arrays.asList(), 0); // Empty graph
        boolean[] discovered = new boolean[0]; // Assuming 0 nodes in the graph

        emptyDFS.dfs(0, discovered); // Try to DFS from an empty graph

        assertEquals(0, emptyDFS.visitedNodes.size());
    }
}
