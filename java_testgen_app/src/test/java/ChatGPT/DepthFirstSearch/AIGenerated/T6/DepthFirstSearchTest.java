package ChatGPT.DepthFirstSearch.AIGenerated.T6;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
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

        dfs = new DepthFirstSearch(edges, 7); // 7 is the number of nodes in the graph
    }

    @Test
    public void testDFSOnGraph() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(0, discovered);

        // The DFS traversal from node 0 should visit nodes 0, 1, 4, 3
        List<Integer> expectedTraversal = Arrays.asList(0, 1, 4, 3);
        assertEquals(expectedTraversal, dfs.visitedNodes);
    }

    @Test
    public void testDFSOnDisconnectedGraph() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(6, discovered);

        // The DFS traversal from node 6 should only visit node 6
        List<Integer> expectedTraversal = Arrays.asList(6);
        assertEquals(expectedTraversal, dfs.visitedNodes);
    }

    @Test
    public void testDFSOnEmptyGraph() {
        DepthFirstSearch emptyGraph = new DepthFirstSearch(Arrays.asList(), 0);
        boolean[] discovered = new boolean[0];
        emptyGraph.dfs(0, discovered);

        // The DFS traversal on an empty graph should result in an empty visitedNodes list
        assertTrue(emptyGraph.visitedNodes.isEmpty());
    }
}