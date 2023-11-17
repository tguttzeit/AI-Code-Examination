package ChatGPT.DepthFirstSearch.PromptOnly.T6;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
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
                new DepthFirstSearch.Edge(6, 6));

        int n = 7; // Number of nodes in the graph

        dfs = new DepthFirstSearch(edges, n);
    }

    @Test
    public void testDFS() {
        boolean[] discovered = new boolean[7]; // Assuming 7 nodes
        List<Integer> visitedNodes = null;
        dfs.dfs(0, discovered);
        List<Integer> expected = Arrays.asList(0, 1, 4, 3);
        assertEquals(expected, visitedNodes);
    }

    @Test
    public void testDFSWithDisconnectedComponents() {
        boolean[] discovered = new boolean[7]; // Assuming 7 nodes
        List<Integer> visitedNodes = null;
        dfs.dfs(0, discovered);
        List<Integer> expected = Arrays.asList(0, 1, 4, 3);
        assertEquals(expected, visitedNodes);

        discovered = new boolean[7]; // Reset discovered array
        visitedNodes = null;
        dfs.dfs(2, discovered);
        List<Integer> expected2 = Arrays.asList(2, 4, 3);
        assertEquals(expected2, visitedNodes);
    }

    @Test
    public void testDFSWithSingleNodeGraph() {
        List<DepthFirstSearch.Edge> singleNodeEdges = Collections.emptyList();
        DepthFirstSearch singleNodeDFS = new DepthFirstSearch(singleNodeEdges, 1);
        boolean[] discovered = new boolean[1];
        List<Integer> visitedNodes = null;
        singleNodeDFS.dfs(0, discovered);
        List<Integer> expected = Collections.singletonList(0);
        assertEquals(expected, visitedNodes);
    }
}
