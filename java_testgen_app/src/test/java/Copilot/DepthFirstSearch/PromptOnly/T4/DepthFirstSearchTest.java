package Copilot.DepthFirstSearch.PromptOnly.T4;

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
        int n = 7;
        DepthFirstSearch dfs = new DepthFirstSearch(edges, n);
        dfs.dfs(0, new boolean[n]);
        System.out.println(dfs.visitedNodes);
        assertEquals(7, dfs.visitedNodes.size());
        assertEquals(0, dfs.visitedNodes.get(0).intValue());
        assertEquals(1, dfs.visitedNodes.get(1).intValue());
        assertEquals(4, dfs.visitedNodes.get(2).intValue());
        assertEquals(3, dfs.visitedNodes.get(3).intValue());
        assertEquals(2, dfs.visitedNodes.get(4).intValue());
        assertEquals(5, dfs.visitedNodes.get(5).intValue());
        assertEquals(6, dfs.visitedNodes.get(6).intValue());
    }
}