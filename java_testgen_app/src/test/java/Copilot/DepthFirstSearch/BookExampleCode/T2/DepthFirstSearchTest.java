package Copilot.DepthFirstSearch.BookExampleCode.T2;

import org.junit.Test;
import org.junit.BeforeClass;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class DepthFirstSearchTest {
    private static DepthFirstSearch dfs = null;

    @BeforeClass
    public static void setup() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList(
                new DepthFirstSearch.Edge(0, 1),
                new DepthFirstSearch.Edge(0, 3),
                new DepthFirstSearch.Edge(1, 4),
                new DepthFirstSearch.Edge(2, 4),
                new DepthFirstSearch.Edge(2, 5),
                new DepthFirstSearch.Edge(3, 1),
                new DepthFirstSearch.Edge(4, 3),
                new DepthFirstSearch.Edge(5, 5),
                new DepthFirstSearch.Edge(6, 6));

        dfs = new DepthFirstSearch(edges, 7);
    }

    @Test
    public void testDFS() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(0, discovered);

        List<Integer> expected = Arrays.asList(0, 1, 4, 3);
        assertEquals(expected, dfs.visitedNodes);
    }

    @Test
    public void testDFS2() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(2, discovered);

        List<Integer> expected = Arrays.asList(2, 4, 3, 1, 0);
        assertEquals(expected, dfs.visitedNodes);
    }

    @Test
    public void testDFS3() {
        boolean[] discovered = new boolean[7];
        dfs.dfs(5, discovered);

        List<Integer> expected = Arrays.asList(5);
        assertEquals(expected, dfs.visitedNodes);
    }
}