package ChatGPT.DepthFirstSearch.BookExampleCode.T9;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class DepthFirstSearchTest {

    @Test
    public void testDFSWithValidGraph() {
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

        assertTrue(dfs.visitedNodes.containsAll(Arrays.asList(0, 1, 4, 3, 2, 5, 6)));
    }

    @Test
    public void testDFSWithEmptyGraph() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList();

        DepthFirstSearch dfs = new DepthFirstSearch(edges, 0);
        boolean[] discovered = new boolean[0];
        dfs.dfs(0, discovered);

        assertTrue(dfs.visitedNodes.isEmpty());
    }

    @Test
    public void testDFSWithDisconnectedGraph() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList(
                new DepthFirstSearch.Edge(0, 1),
                new DepthFirstSearch.Edge(2, 3),
                new DepthFirstSearch.Edge(4, 5)
        );

        DepthFirstSearch dfs = new DepthFirstSearch(edges, 6);
        boolean[] discovered = new boolean[6];
        dfs.dfs(0, discovered);

        assertTrue(dfs.visitedNodes.containsAll(Arrays.asList(0, 1)) &&
                dfs.visitedNodes.containsAll(Arrays.asList(2, 3)) &&
                dfs.visitedNodes.containsAll(Arrays.asList(4, 5)));
    }
}
