package ChatGPT.DepthFirstSearch.PromptOnly.T1;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.*;

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

        int n = 7; // Assuming there are 7 nodes in the graph
        dfs = new DepthFirstSearch(edges, n);
    }

    @Test
    public void testDFSWithStartNode0() {
        dfs.dfs(0);
        ArrayList<Integer> visitedNodes = dfs.getVisitedNodes();

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 4, 3));
        assertEquals(expected, visitedNodes);
    }

    @Test
    public void testDFSWithStartNode2() {
        dfs.dfs(2);
        ArrayList<Integer> visitedNodes = dfs.getVisitedNodes();

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 4, 3, 1));
        assertEquals(expected, visitedNodes);
    }

    @Test
    public void testDFSWithStartNode6() {
        dfs.dfs(6);
        ArrayList<Integer> visitedNodes = dfs.getVisitedNodes();

        ArrayList<Integer> expected = new ArrayList<>(Collections.singletonList(6));
        assertEquals(expected, visitedNodes);
    }
}