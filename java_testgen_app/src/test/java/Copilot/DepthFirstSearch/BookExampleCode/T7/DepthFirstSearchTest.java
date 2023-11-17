package Copilot.DepthFirstSearch.BookExampleCode.T7;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

public class DepthFirstSearchTest {
    private static DepthFirstSearch graph;

    @BeforeClass
    public static void setUp() {
        graph = new DepthFirstSearch(null, 7);
    }

    @Test
    public void testDfs() {
        boolean[] discovered = new boolean[7];
        graph.dfs(0, discovered);
        assertEquals(Arrays.asList(0, 1, 4, 3), graph.visitedNodes);
    }

    @Test
    public void testDfs2() {
        boolean[] discovered = new boolean[7];
        graph.dfs(2, discovered);
        assertEquals(Arrays.asList(2, 4, 3, 1, 0), graph.visitedNodes);
    }

    @Test
    public void testDfs3() {
        boolean[] discovered = new boolean[7];
        graph.dfs(6, discovered);
        assertEquals(Arrays.asList(6), graph.visitedNodes);
    }
}