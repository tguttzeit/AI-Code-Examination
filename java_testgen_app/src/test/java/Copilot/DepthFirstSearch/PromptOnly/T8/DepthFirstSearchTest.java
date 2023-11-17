package Copilot.DepthFirstSearch.PromptOnly.T8;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

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
        DepthFirstSearch dfs = new DepthFirstSearch(edges, 7);
        dfs.dfs(0, new boolean[7]);
        List<Integer> expected = Arrays.asList(0, 1, 4, 3, 2, 5);
        assertEquals(expected, dfs.visitedNodes);
    }
}