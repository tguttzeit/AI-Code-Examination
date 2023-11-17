package ChatGPT.DepthFirstSearch.PromptOnly.T3;

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

        dfs = new DepthFirstSearch(edges, 7); // Assuming 'n' is 7 for the graph in your example
    }

    @Test
    public void testDFSOnSingleNode() {
        dfs.dfs(6); // Start DFS from node 6
        ArrayList<Integer> visitedNodes = dfs.visitedNodes;
        assertEquals(Arrays.asList(6), visitedNodes);
    }

    @Test
    public void testDFSOnDisconnectedGraph() {
        dfs.dfs(0); // Start DFS from node 0
        ArrayList<Integer> visitedNodes = dfs.visitedNodes;
        Collections.sort(visitedNodes);
        assertEquals(Arrays.asList(0, 1, 3, 4), visitedNodes);
    }

    @Test
    public void testDFSOnConnectedGraph() {
        dfs.dfs(2); // Start DFS from node 2
        ArrayList<Integer> visitedNodes = dfs.visitedNodes;
        Collections.sort(visitedNodes);
        assertEquals(Arrays.asList(2, 4, 3, 1, 0), visitedNodes);
    }
}
