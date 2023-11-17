package ChatGPT.DepthFirstSearch.PromptOnly.T8;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepthFirstSearchTest {

    private DepthFirstSearch graph;

    @Before
    public void setUp() {
        // Build the graph with the specified edges
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
        graph = new DepthFirstSearch(edges, 7); // Assuming 7 as the number of nodes
    }

    @Test
    public void testDFSStartingFromNode0() {
        ArrayList<Integer> visitedNodes = new ArrayList<>();
        graph.dfs(0, new boolean[7]); // Assuming 7 as the number of nodes
        visitedNodes = graph.visitedNodes;

        List<Integer> expectedOrder = Arrays.asList(0, 1, 4, 3);
        assertEquals(expectedOrder, visitedNodes);
    }

    @Test
    public void testDFSStartingFromNode2() {
        ArrayList<Integer> visitedNodes = new ArrayList<>();
        graph.dfs(2, new boolean[7]); // Assuming 7 as the number of nodes
        visitedNodes = graph.visitedNodes;

        List<Integer> expectedOrder = Arrays.asList(2, 4, 3, 1, 0);
        assertEquals(expectedOrder, visitedNodes);
    }

    @Test
    public void testDFSStartingFromNode6() {
        ArrayList<Integer> visitedNodes = new ArrayList<>();
        graph.dfs(6, new boolean[7]); // Assuming 7 as the number of nodes
        visitedNodes = graph.visitedNodes;

        List<Integer> expectedOrder = Arrays.asList(6);
        assertEquals(expectedOrder, visitedNodes);
    }
}
