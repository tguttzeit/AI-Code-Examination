package Copilot.DepthFirstSearch.AIGenerated.T3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DepthFirstSearchTest {
    DepthFirstSearch dfs = new DepthFirstSearch();

    @Test
    public void testDepthFirstSearch() {
        boolean[] discovered = new boolean[100];
        dfs.dfs(0, discovered);

        assertEquals(0, dfs.visitedNodes.get(0));
        assertEquals(1, dfs.visitedNodes.get(1));
        assertEquals(4, dfs.visitedNodes.get(2));
        assertEquals(3, dfs.visitedNodes.get(3));
        assertEquals(2, dfs.visitedNodes.get(4));
        assertEquals(5, dfs.visitedNodes.get(5));
        assertEquals(6, dfs.visitedNodes.get(6));
    }

}