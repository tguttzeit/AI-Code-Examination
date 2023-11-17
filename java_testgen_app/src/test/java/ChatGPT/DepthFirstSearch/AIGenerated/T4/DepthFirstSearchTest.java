package ChatGPT.DepthFirstSearch.AIGenerated.T4;

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
        dfs = new DepthFirstSearch(edges, 7);
    }

    @Test
    public void testDFSStartingFromNode0() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(0, discovered);
        List<Integer> expectedVisitedNodes = Arrays.asList(0, 1, 4, 3);
        assertEquals(expectedVisitedNodes, dfs.visitedNodes);
    }

    @Test
    public void testDFSStartingFromNode2() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(2, discovered);
        List<Integer> expectedVisitedNodes = Arrays.asList(2, 4, 3, 1, 0);
        assertEquals(expectedVisitedNodes, dfs.visitedNodes);
    }

    @Test
    public void testDFSStartingFromNode6() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(6, discovered);
        List<Integer> expectedVisitedNodes = Arrays.asList(6);
        assertEquals(expectedVisitedNodes, dfs.visitedNodes);
    }
}