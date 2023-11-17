package Copilot.DepthFirstSearch.AIGenerated.T7;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DepthFirstSearchTest {
    @Test
    public void testDfs() {
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

        int n = 7;

        DepthFirstSearch dfs = new DepthFirstSearch(edges, n);

        boolean[] discovered = new boolean[n];

        dfs.dfs(0, discovered);

        assertEquals(Arrays.asList(0, 1, 4, 3, 2, 5), dfs.visitedNodes);
    }

    @Test
    public void testDfs2() {
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

        int n = 7;

        DepthFirstSearch dfs = new DepthFirstSearch(edges, n);

        boolean[] discovered = new boolean[n];

        dfs.dfs(2, discovered);

        assertEquals(Arrays.asList(2, 4, 3, 1, 0, 5), dfs.visitedNodes);
    }

    @Test
    public void testDfs3() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList(
                new DepthFirstSearch.Edge(0, 1),
                new DepthFirstSearch.Edge(0, 3),
                new DepthFirstSearch.Edge(1, 4),
                new DepthFirstSearch.
}
