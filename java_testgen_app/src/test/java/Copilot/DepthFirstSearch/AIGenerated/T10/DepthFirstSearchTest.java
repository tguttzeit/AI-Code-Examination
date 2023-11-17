package Copilot.DepthFirstSearch.AIGenerated.T10;

import static org.junit.Assert.assertEquals;

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
                boolean[] discovered = new boolean[7];
                dfs.dfs(0, discovered);
                assertEquals("[0, 1, 4, 3]", dfs.visitedNodes.toString());
        }

        @Test
        public void test2() {
                List<DepthFirstSearch.Edge> edges = Arrays.asList(
                                new DepthFirstSearch.Edge(0, 1),
                                new DepthFirstSearch.Edge(0, 2),
                                new DepthFirstSearch.Edge(1, 2),
                                new DepthFirstSearch.Edge(2, 0),
                                new DepthFirstSearch.Edge(2, 3),
                                new DepthFirstSearch.Edge(3, 3));
                DepthFirstSearch dfs = new DepthFirstSearch(edges, 4);
                boolean[] discovered = new boolean[4];
                dfs.dfs(1, discovered);
                assertEquals("[1, 2, 0, 3]", dfs.visitedNodes.toString());
        }

        @Test
        public void test3() {
                List<DepthFirstSearch.Edge> edges = Arrays.asList(
                                new DepthFirstSearch.Edge(0, 1),
                                new DepthFirstSearch.Edge(0, 2),
                                new DepthFirstSearch.Edge(1, 2),
                                new DepthFirstSearch.Edge(2, 0),
                                new DepthFirstSearch.Edge(2, 3),
                                new DepthFirstSearch.Edge(3, 3));
                DepthFirstSearch dfs = new DepthFirstSearch(edges, 4);
                boolean[] discovered = new boolean[4];
                dfs.dfs(3, discovered);
        }
}
