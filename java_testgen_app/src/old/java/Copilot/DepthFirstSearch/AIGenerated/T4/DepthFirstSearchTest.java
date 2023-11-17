package Copilot.DepthFirstSearch.AIGenerated.T4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DepthFirstSearchTest {
    @Test
    public void testDfs1() {
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

        ArrayList<Integer> visitedNodes = new ArrayList<>();
        visitedNodes.add(0);
        visitedNodes.add(1);
        visitedNodes.add(4);
        visitedNodes.add(3);

        assertEquals(visitedNodes, dfs.visitedNodes);
    }

    @Test
    public void testDfs2() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList(
                new DepthFirstSearch.Edge(0, 1),
                new DepthFirstSearch.Edge(0, 2),
                new DepthFirstSearch.Edge(1, 3),
                new DepthFirstSearch.Edge(1, 4),
                new DepthFirstSearch.Edge(2, 5),
                new DepthFirstSearch.Edge(2, 6)
        );

        DepthFirstSearch dfs = new DepthFirstSearch(edges, 7);

        boolean[] discovered = new boolean[7];

        dfs.dfs(0, discovered);

        ArrayList<Integer> visitedNodes = new ArrayList<>();
        visitedNodes.add(0);
        visitedNodes.add(1);
        visitedNodes.add(3);
        visitedNodes.add(4);
        visitedNodes.add(2);
        visitedNodes.add(5);
        visitedNodes.add(6);

        assertEquals(visitedNodes, dfs.visitedNodes);
    }

    @Test
    public void testDfs3() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList(
                new DepthFirstSearch.Edge(0, 1),
                new DepthFirstSearch.Edge(0, 2),
                new
}
