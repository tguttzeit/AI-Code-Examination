package ChatGPT.DepthFirstSearch.AIGenerated.T7;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
    public void testDFSOnSingleNodeGraph() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(6, discovered);

        // In a single-node graph, the visited node should be the starting node.
        List<Integer> expectedVisitedNodes = Arrays.asList(6);
        assertEquals(expectedVisitedNodes, dfs.visitedNodes);
    }

    @Test
    public void testDFSOnDisconnectedGraph() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(0, discovered);

        // In a disconnected graph, the visited nodes should include all components reachable from the starting node.
        List<Integer> expectedVisitedNodes = Arrays.asList(0, 1, 3, 4);
        assertEquals(expectedVisitedNodes, dfs.visitedNodes);
    }

    @Test
    public void testDFSOnConnectedGraph() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(2, discovered);

        // In a connected graph, the visited nodes should include all nodes in the connected component.
        List<Integer> expectedVisitedNodes = Arrays.asList(2, 4, 3, 1, 0, 5);
        assertEquals(expectedVisitedNodes, dfs.visitedNodes);
    }
}