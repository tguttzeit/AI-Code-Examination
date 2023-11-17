package ChatGPT.DepthFirstSearch.BookExampleCode.T5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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

        dfs = new DepthFirstSearch(edges, 7);
    }

    @Test
    public void testDFS() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(0, discovered);

        assertTrue(discovered[0]);
        assertTrue(discovered[1]);
        assertTrue(discovered[3]);
        assertTrue(discovered[4]);
        assertTrue(discovered[2]);
        assertTrue(discovered[5]);
        assertFalse(discovered[6]); // Node 6 is not reachable from the starting node (0)
    }

    @Test
    public void testVisitedNodesOrder() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(0, discovered);

        List<Integer> expectedOrder = Arrays.asList(0, 1, 4, 3, 2, 5);
        assertEquals(expectedOrder, dfs.visitedNodes);
    }

    @Test
    public void testDisconnectedGraph() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList(
                new DepthFirstSearch.Edge(0, 1),
                new DepthFirstSearch.Edge(2, 3),
                new DepthFirstSearch.Edge(4, 5)
        );

        DepthFirstSearch disconnectedDfs = new DepthFirstSearch(edges, 6);
        boolean[] discovered = new boolean[6];
        disconnectedDfs.dfs(0, discovered);

        assertTrue(discovered[0]);
        assertTrue(discovered[1]);
        assertFalse(discovered[2]); // Node 2 is not reachable from node 0
        assertFalse(discovered[3]); // Node 3 is not reachable from node 0
        assertFalse(discovered[4]); // Node 4 is not reachable from node 0
        assertFalse(discovered[5]); // Node 5 is not reachable from node 0
    }
}
