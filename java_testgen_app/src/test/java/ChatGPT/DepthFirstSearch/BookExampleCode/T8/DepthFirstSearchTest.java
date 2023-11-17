package ChatGPT.DepthFirstSearch.BookExampleCode.T8;

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
        dfs = new DepthFirstSearch(edges, 7); // The second argument is the number of nodes (n).
    }

    @Test
    public void testDFSWithSingleNode() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(6, discovered); // Start DFS from node 6
        assertTrue(discovered[6]);
        assertEquals(Arrays.asList(6), dfs.visitedNodes);
    }

    @Test
    public void testDFSWithMultipleConnectedNodes() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(0, discovered); // Start DFS from node 0
        assertTrue(discovered[0]);
        assertTrue(discovered[1]);
        assertTrue(discovered[3]);
        assertTrue(discovered[4]);
        assertTrue(discovered[2]);
        assertTrue(discovered[5]);
        assertEquals(Arrays.asList(0, 1, 4, 3, 2, 5), dfs.visitedNodes);
    }

    @Test
    public void testDFSWithIsolatedNode() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(6, discovered); // Start DFS from node 6 (isolated)
        assertTrue(discovered[6]);
        assertEquals(Arrays.asList(6), dfs.visitedNodes);
    }
}
