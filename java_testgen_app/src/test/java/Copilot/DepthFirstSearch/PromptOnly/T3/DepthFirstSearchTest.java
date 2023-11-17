package Copilot.DepthFirstSearch.PromptOnly.T3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
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
                new DepthFirstSearch.Edge(6, 6));
        int n = 7;
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (DepthFirstSearch.Edge e : edges) {
            adjacency.get(e.source).add(e.dest);
        }
        DepthFirstSearch dfs = new DepthFirstSearch(edges, n);
        dfs.dfs(0, new boolean[n]);
        ArrayList<Integer> visitedNodes = dfs.visitedNodes;
        Assert.assertEquals(visitedNodes, Arrays.asList(0, 1, 4, 3, 2, 5));
        dfs.dfs(2, new boolean[n]);
        visitedNodes = dfs.visitedNodes;
        Assert.assertEquals(visitedNodes, Arrays.asList(2, 4, 3, 1, 0, 5));
        dfs.dfs(6, new boolean[n]);
        visitedNodes = dfs.visitedNodes;
        Assert.assertEquals(visitedNodes, Arrays.asList(6));
    }
}