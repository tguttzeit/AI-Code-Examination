package ChatGPT.DepthFirstSearch.PromptOnly.T5;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class DepthFirstSearchTest {

    @Test
    public void testDFS() {
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

        DepthFirstSearch dfs = new DepthFirstSearch(edges, 7); // Assuming 'n' is 7 in this case
        dfs.dfs(0); // Start DFS from node 0

        // Check if visitedNodes contains the expected nodes in the correct order
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 4, 3, 2, 5, 6));
        assertEquals(expected, dfs.visitedNodes);
    }

    @Test
    public void testDFSFromDifferentNode() {
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

        DepthFirstSearch dfs = new DepthFirstSearch(edges, 7);
        dfs.dfs(2); // Start DFS from node 2

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 4, 3, 1, 0, 5, 6));
        assertEquals(expected, dfs.visitedNodes);
    }

    @Test
    public void testDFSDisconnectedGraph() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList(
                new DepthFirstSearch.Edge(0, 1),
                new DepthFirstSearch.Edge(2, 3),
                new DepthFirstSearch.Edge(4, 5)
        );

        DepthFirstSearch dfs = new DepthFirstSearch(edges, 6); // Assuming 'n' is 6 in this case
        dfs.dfs(0); // Start DFS from node 0

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1));
        assertEquals(expected, dfs.visitedNodes);
    }
}
