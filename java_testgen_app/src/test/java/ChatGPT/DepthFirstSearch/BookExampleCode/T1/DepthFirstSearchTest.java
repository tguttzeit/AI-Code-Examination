package ChatGPT.DepthFirstSearch.BookExampleCode.T1;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class DepthFirstSearchTest {

    @Test
    public void testDFSWithGraph1() {
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
    public void testDFSWithGraph2() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList(
                new DepthFirstSearch.Edge(0, 1),
                new DepthFirstSearch.Edge(1, 2),
                new DepthFirstSearch.Edge(2, 3),
                new DepthFirstSearch.Edge(3, 4)
        );
        DepthFirstSearch dfs = new DepthFirstSearch(edges, 5);

        boolean[] discovered = new boolean[5];
        dfs.dfs(0, discovered);

        assertTrue(dfs.visitedNodes.containsAll(Arrays.asList(0, 1, 2, 3, 4)));
    }

    @Test
    public void testDFSWithGraph3() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList(
                new DepthFirstSearch.Edge(0, 1),
                new DepthFirstSearch.Edge(0, 2),
                new DepthFirstSearch.Edge(1, 3),
                new DepthFirstSearch.Edge(2, 4)
        );
        DepthFirstSearch dfs = new DepthFirstSearch(edges, 5);

        boolean[] discovered = new boolean[5];
        dfs.dfs(0, discovered);

        assertTrue(dfs.visitedNodes.containsAll(Arrays.asList(0, 1, 3, 2, 4)));
    }
}
