package ChatGPT.DepthFirstSearch.T35;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DepthFirstSearchTest {

    // total number of nodes in the graph
    int n;
    
    boolean[] discovered;
    DepthFirstSearch graph;

    @Before
    public void setUp() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList(
                // Notice that there is no path to node 0
                new DepthFirstSearch.Edge(0, 1),
                new DepthFirstSearch.Edge(0, 3),
                new DepthFirstSearch.Edge(1, 4),
                new DepthFirstSearch.Edge(2, 4),
                new DepthFirstSearch.Edge(2, 5),
                new DepthFirstSearch.Edge(3, 1),
                new DepthFirstSearch.Edge(4, 3),
                new DepthFirstSearch.Edge(5, 5),
                new DepthFirstSearch.Edge(6, 6));

        n = 7;

        // build a graph from the given edges
        graph = new DepthFirstSearch(edges, n);

        // to keep track of whether a vertex is discovered or not
        discovered = new boolean[n];
    }

    @Test
    // checks if search algorithm works correct (correct node visiting order,
    // no double visits because of loops)
    public void shouldReturnCorrectArray() {
        int startNode = 0;

        graph.dfs(startNode, discovered);

        for (int i = 0; i < n; i++) {
            if (!discovered[i]) {
                graph.dfs(i, discovered);
            }
        }

        Integer[] nodeArray = graph.visitedNodes.toArray(new Integer[0]);

        assertEquals(n, nodeArray.length);

        Integer[] possibility1 = { 0, 1, 4, 2, 5, 3, 6 };
        Integer[] possibility2 = { 0, 1, 4, 3, 2, 5, 6 };
        Integer[] possibility3 = { 0, 1, 3, 4, 2, 5, 6 };
        Integer[] possibility4 = { 0, 3, 1, 4, 2, 5, 6 };
        Integer[] possibility5 = { 0, 3, 4, 2, 5, 1, 6 };
        Integer[] possibility6 = { 0, 3, 4, 1, 2, 5, 6 };

        boolean expected = true;
        boolean actual = Arrays.equals(nodeArray, possibility1) ||
                Arrays.equals(nodeArray, possibility2) ||
                Arrays.equals(nodeArray, possibility3) ||
                Arrays.equals(nodeArray, possibility4) ||
                Arrays.equals(nodeArray, possibility5) ||
                Arrays.equals(nodeArray, possibility6);

        assertEquals(expected, actual);
    }
}
