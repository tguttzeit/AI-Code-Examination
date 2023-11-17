package Copilot.DepthFirstSearch.BookExampleCode.T4;

import java.util.Arrays;
import java.util.List;

public class DepthFirstSearchTest {
    public static void main(String[] args) {
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
        System.out.println(dfs.visitedNodes);
    }
}