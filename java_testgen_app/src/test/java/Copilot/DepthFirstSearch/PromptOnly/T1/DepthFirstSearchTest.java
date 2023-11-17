package Copilot.DepthFirstSearch.PromptOnly.T1;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DepthFirstSearchTest {
    @Test
    public void test() {
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
        DepthFirstSearch graph = new DepthFirstSearch(edges, n);
        graph.dfs(0, new boolean[n]);

        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(1);
        expected.add(4);
        expected.add(3);
        expected.add(2);
        expected.add(5);

        assertEquals(expected, graph.visitedNodes);
    }
}
