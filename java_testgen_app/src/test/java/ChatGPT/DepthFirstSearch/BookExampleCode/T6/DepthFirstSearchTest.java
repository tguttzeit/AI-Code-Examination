package ChatGPT.DepthFirstSearch.BookExampleCode.T6;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DepthFirstSearchTest {

    @Test
    public void testDFS() {
        // Build the graph with the provided edges
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
        DepthFirstSearch graph = new DepthFirstSearch(edges, 7);

        // Test 1: Check the DFS traversal starting from vertex 0
        boolean[] discovered1 = new boolean[7];
        graph.dfs(0, discovered1);
        ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(0, 1, 4, 3, 2, 5, 6));
        assertEquals(expected1, graph.visitedNodes);

        // Test 2: Check the DFS traversal starting from vertex 2
        boolean[] discovered2 = new boolean[7];
        graph.visitedNodes.clear(); // Clear the visitedNodes list from previous traversal
        graph.dfs(2, discovered2);
        ArrayList<Integer> expected2 = new ArrayList<>(Arrays.asList(2, 4, 3, 1, 0, 5, 6));
        assertEquals(expected2, graph.visitedNodes);

        // Test 3: Check the DFS traversal starting from vertex 6
        boolean[] discovered3 = new boolean[7];
        graph.visitedNodes.clear(); // Clear the visitedNodes list from previous traversal
        graph.dfs(6, discovered3);
        ArrayList<Integer> expected3 = new ArrayList<>(Arrays.asList(6));
        assertEquals(expected3, graph.visitedNodes);
    }
}
