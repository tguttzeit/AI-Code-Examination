package Copilot.DepthFirstSearch.BookExampleCode.T3;

import static org.junit.Assert.assertTrue;

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
        DepthFirstSearch dfs = new DepthFirstSearch(edges, 7);
        boolean[] discovered = new boolean[7];
        dfs.dfs(0, discovered);
        assertTrue(dfs.visitedNodes.size() == 6);
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
        DepthFirstSearch dfs = new DepthFirstSearch(edges, 7);
        boolean[] discovered = new boolean[7];
        dfs.dfs(2, discovered);
        assertTrue(dfs.visitedNodes.size() == 4);
        }

@Test
public void testDfs3() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList(
        new DepthFirstSearch.Edge(0, 1),
        new DepthFirstSearch.Edge(0, 3),
        new DepthFirstSearch.Edge(1, 4),
        new DepthFirstSearch.Edge(2, 4),
        new DepthFirstSearch.Edge(2, 5),
        new DepthFirstSearch.Edge(3, 1),
        new DepthFirstSearch
}
}