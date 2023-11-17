package ChatGPT.DepthFirstSearch.BookExampleCode.T2;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DepthFirstSearchTest {
    private DepthFirstSearch dfs;

    @Before
    public void setUp() {
        // Create a graph with the specified edges
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
        dfs = new DepthFirstSearch(edges, 7); // 7 is the number of nodes
    }

    @Test
    public void testDFSStartingFromNode0() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(0, discovered);

        assertTrue(discovered[0]);
        assertTrue(discovered[1]);
        assertTrue(discovered[3]);
        assertTrue(discovered[4]);
        assertTrue(discovered[5]);
        assertFalse(discovered[2]);
        assertFalse(discovered[6]);
    }

    @Test
    public void testDFSStartingFromNode2() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(2, discovered);

        assertTrue(discovered[2]);
        assertTrue(discovered[4]);
        assertTrue(discovered[3]);
        assertTrue(discovered[1]);
        assertTrue(discovered[0]);
        assertFalse(discovered[5]);
        assertFalse(discovered[6]);
    }

    @Test
    public void testDFSStartingFromNode6() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(6, discovered);

        assertTrue(discovered[6]);
        assertFalse(discovered[0]);
        assertFalse(discovered[1]);
        assertFalse(discovered[2]);
        assertFalse(discovered[3]);
        assertFalse(discovered[4]);
        assertFalse(discovered[5]);
    }
}
