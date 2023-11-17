package ChatGPT.DepthFirstSearch.BookExampleCode.T7;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class DepthFirstSearchTest {

    private DepthFirstSearch dfs;
    private boolean[] discovered;

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

        int n = 7; // Number of vertices
        dfs = new DepthFirstSearch(edges, n);
        discovered = new boolean[n];
    }

    @Test
    public void testDFSOnConnectedGraph() {
        dfs.dfs(0, discovered);
        List<Integer> expectedVisitedNodes = Arrays.asList(0, 1, 4, 3, 2, 5, 6);
        assertEquals(expectedVisitedNodes, dfs.visitedNodes);
    }

    @Test
    public void testDFSOnDisconnectedGraph() {
        dfs.dfs(0, discovered);
        List<Integer> expectedVisitedNodes = Arrays.asList(0, 1, 4, 3, 2, 5, 6);
        assertEquals(expectedVisitedNodes, dfs.visitedNodes);

        // Reset visitedNodes list and discovered array
        dfs.visitedNodes.clear();
        Arrays.fill(discovered, false);

        dfs.dfs(6, discovered);
        List<Integer> expectedVisitedNodes2 = Collections.singletonList(6);
        assertEquals(expectedVisitedNodes2, dfs.visitedNodes);
    }

    @Test
    public void testDFSOnEmptyGraph() {
        List<DepthFirstSearch.Edge> emptyEdges = Collections.emptyList();
        DepthFirstSearch emptyDFS = new DepthFirstSearch(emptyEdges, 0);
        boolean[] emptyDiscovered = new boolean[0];

        emptyDFS.dfs(0, emptyDiscovered);
        assertTrue(emptyDFS.visitedNodes.isEmpty());
    }
}
