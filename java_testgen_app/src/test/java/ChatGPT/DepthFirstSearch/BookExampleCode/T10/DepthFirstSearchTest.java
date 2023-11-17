package ChatGPT.DepthFirstSearch.BookExampleCode.T10;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

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
                new DepthFirstSearch.Edge(6, 6)
        );

        DepthFirstSearch dfs = new DepthFirstSearch(edges, 7);

        // Test 1: Check DFS traversal starting from node 0
        boolean[] discovered1 = new boolean[7];
        dfs.dfs(0, discovered1);
        List<Integer> expectedTraversal1 = Arrays.asList(0, 1, 4, 3);
        assertEquals(expectedTraversal1, dfs.visitedNodes);

        // Test 2: Check DFS traversal starting from node 2
        dfs.visitedNodes.clear(); // Clear previous traversal results
        boolean[] discovered2 = new boolean[7];
        dfs.dfs(2, discovered2);
        List<Integer> expectedTraversal2 = Arrays.asList(2, 4, 3, 1, 0);
        assertEquals(expectedTraversal2, dfs.visitedNodes);

        // Test 3: Check DFS traversal starting from node 6
        dfs.visitedNodes.clear(); // Clear previous traversal results
        boolean[] discovered3 = new boolean[7];
        dfs.dfs(6, discovered3);
        List<Integer> expectedTraversal3 = Arrays.asList(6);
        assertEquals(expectedTraversal3, dfs.visitedNodes);
    }
}
