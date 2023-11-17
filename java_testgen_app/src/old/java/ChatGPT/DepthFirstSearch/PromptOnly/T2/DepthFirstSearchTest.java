package ChatGPT.DepthFirstSearch.PromptOnly.T2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
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
        dfs = new DepthFirstSearch(edges, 7); // Assuming 7 is the number of nodes in the graph
    }

    @Test
    public void testDFSOnNode0() {
        dfs.dfs(0);
        ArrayList<Integer> visitedNodes = dfs.visitedNodes;
        List<Integer> expected = Arrays.asList(0, 1, 4, 3);
        assertEquals(expected, visitedNodes);
    }

    @Test
    public void testDFSOnNode2() {
        dfs.dfs(2);
        ArrayList<Integer> visitedNodes = dfs.visitedNodes;
        List<Integer> expected = Arrays.asList(2, 4, 3, 1, 0);
        assertEquals(expected, visitedNodes);
    }

    @Test
    public void testDFSOnNode6() {
        dfs.dfs(6);
        ArrayList<Integer> visitedNodes = dfs.visitedNodes;
        List<Integer> expected = Arrays.asList(6);
        assertEquals(expected, visitedNodes);
    }
}