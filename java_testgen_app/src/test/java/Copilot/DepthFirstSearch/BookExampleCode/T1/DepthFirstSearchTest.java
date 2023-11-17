package Copilot.DepthFirstSearch.BookExampleCode.T1;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
public class DepthFirstSearchTest {
    @Test
    public void testDepthFirstSearch() {
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

        assertEquals("[0, 1, 4, 3]", dfs.visitedNodes.toString());

        dfs.dfs(2, discovered);

        assertEquals("[0, 1, 4, 3, 2, 5]", dfs.visitedNodes.toString());

        dfs.dfs(6, discovered);

        assertEquals("[0, 1, 4, 3, 2, 5, 6]", dfs.visitedNodes.toString());
    }
}