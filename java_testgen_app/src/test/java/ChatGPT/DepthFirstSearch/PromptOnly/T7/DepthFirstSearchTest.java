package ChatGPT.DepthFirstSearch.PromptOnly.T7;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class DepthFirstSearchTest {

    private DepthFirstSearch graph;

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
        graph = new DepthFirstSearch(edges, 7); // '7' represents the number of nodes in the graph
    }

    @Test
    public void testDFSStartNode0() {
        List<Integer> expected = Arrays.asList(0, 1, 4, 3);
        graph.dfs(0, new boolean[7]);
        assertEquals(expected, graph.visitedNodes);
    }

    @Test
    public void testDFSStartNode2() {
        List<Integer> expected = Arrays.asList(2, 4, 3, 1, 0);
        graph.dfs(2, new boolean[7]);
        assertEquals(expected, graph.visitedNodes);
    }

    @Test
    public void testDFSStartNode6() {
        List<Integer> expected = Collections.singletonList(6);
        graph.dfs(6, new boolean[7]);
        assertEquals(expected, graph.visitedNodes);
    }
}
