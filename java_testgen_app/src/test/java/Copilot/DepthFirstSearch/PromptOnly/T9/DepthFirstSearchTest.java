package Copilot.DepthFirstSearch.PromptOnly.T9;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class DepthFirstSearchTest {
        @Test
        public void test1() {
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

                DepthFirstSearch dfs = new DepthFirstSearch(edges, 7);

                dfs.dfs(0, new boolean[7]);

                ArrayList<Integer> visitedNodes = dfs.visitedNodes;

                assertEquals(visitedNodes.get(0).intValue(), 0);
                assertEquals(visitedNodes.get(1).intValue(), 1);
                assertEquals(visitedNodes.get(2).intValue(), 4);
                assertEquals(visitedNodes.get(3).intValue(), 3);
                assertEquals(visitedNodes.get(4).intValue(), 2);
                assertEquals(visitedNodes.get(5).intValue(), 5);
                assertEquals(visitedNodes.get(6).intValue(), 6);
        }

        @Test
        public void test2() {
                List<DepthFirstSearch.Edge> edges = Arrays.asList(
                                new DepthFirstSearch.Edge(0, 1),
                                new DepthFirstSearch.Edge(0, 2),
                                new DepthFirstSearch.Edge(1, 3),
                                new DepthFirstSearch.Edge(2, 4),
                                new DepthFirstSearch.Edge(3, 5),
                                new DepthFirstSearch.Edge(4, 5),
                                new DepthFirstSearch.Edge(5, 6));

                DepthFirstSearch dfs = new DepthFirstSearch(edges, 7);

                dfs.dfs(0, new boolean[7]);

                ArrayList<Integer> visitedNodes = dfs.visitedNodes;

                assertEquals(visitedNodes.get(0).intValue(), 0);
                assertEquals(visitedNodes.get(1).intValue(), 1);
                assertEquals(visitedNodes.get(2).intValue(), 3);
                assertEquals(visitedNodes.get(3).intValue(), 5);
        }
}