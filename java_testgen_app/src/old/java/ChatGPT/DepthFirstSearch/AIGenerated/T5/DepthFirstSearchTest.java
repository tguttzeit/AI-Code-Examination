package ChatGPT.DepthFirstSearch.AIGenerated.T5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DepthFirstSearchTest {
    private DepthFirstSearch graph;

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
        graph = new DepthFirstSearch(edges, 7);
    }

    @Test
    public void testDFS1() {
        boolean[] discovered = new boolean[7];
        graph.dfs(0, discovered);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 4, 3));
        assertEquals(expected, graph.visitedNodes);
    }

    @Test
    public void testDFS2() {
        boolean[] discovered = new boolean[7];
        graph.dfs(2, discovered);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 4, 3, 1, 0, 5));
        assertEquals(expected, graph.visitedNodes);
    }

    @Test
    public void testDFS3() {
        boolean[] discovered = new boolean[7];
        graph.dfs(6, discovered);

        ArrayList<Integer> expected = new ArrayList<>(Collections.singletonList(6));
        assertEquals(expected, graph.visitedNodes);
    }
}