package ChatGPT.DepthFirstSearch.PromptOnly.T10;

import org.junit.Before;
import org.junit.Test;
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

        int n = 7; // Number of nodes
        dfs = new DepthFirstSearch(edges, n);
    }

    @Test
    public void testDFSOnGraph() {
        dfs.dfs(0);

        ArrayList<Integer> visitedNodes = dfs.getVisitedNodes();
        assertEquals(Arrays.asList(0, 1, 4, 3, 2, 5), visitedNodes);
    }

    @Test
    public void testDFSOnSingleNodeGraph() {
        dfs = new DepthFirstSearch(new ArrayList<>(), 1); // Single node graph
        dfs.dfs(0);

        ArrayList<Integer> visitedNodes = dfs.getVisitedNodes();
        assertEquals(Collections.singletonList(0), visitedNodes);
    }

    @Test
    public void testDFSOnDisconnectedGraph() {
        List<DepthFirstSearch.Edge> disconnectedEdges = Arrays.asList(
                new DepthFirstSearch.Edge(0, 1),
                new DepthFirstSearch.Edge(2, 3)
        );

        dfs = new DepthFirstSearch(disconnectedEdges, 4); // Disconnected graph
        dfs.dfs(0);

        ArrayList<Integer> visitedNodes = dfs.getVisitedNodes();
        assertEquals(Arrays.asList(0, 1), visitedNodes);
    }
}
