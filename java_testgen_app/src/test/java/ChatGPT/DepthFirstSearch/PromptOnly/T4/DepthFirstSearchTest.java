package ChatGPT.DepthFirstSearch.PromptOnly.T4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
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

        dfs = new DepthFirstSearch(edges, 7); // '7' represents the number of nodes in the graph
    }

    @Test
    public void testDFS1() {
        List<Integer> expected = Arrays.asList(0, 1, 4, 3);
        dfs.dfs(0, new boolean[7]);
        assertEquals(expected, dfs.visitedNodes);
    }

    @Test
    public void testDFS2() {
        List<Integer> expected = Arrays.asList(2, 4, 3, 1, 0);
        dfs.dfs(2, new boolean[7]);
        assertEquals(expected, dfs.visitedNodes);
    }

    @Test
    public void testDFS3() {
        List<Integer> expected = Arrays.asList(6);
        dfs.dfs(6, new boolean[7]);
        assertEquals(expected, dfs.visitedNodes);
    }
}
