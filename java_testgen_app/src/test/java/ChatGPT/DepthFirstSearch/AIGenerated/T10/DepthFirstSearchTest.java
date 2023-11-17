package ChatGPT.DepthFirstSearch.AIGenerated.T10;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DepthFirstSearchTest {
    private DepthFirstSearch dfs;

    @Before
    public void setUp() {
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

        int numNodes = 7; // The number of nodes in the graph
        dfs = new DepthFirstSearch(edges, numNodes);
    }

    @Test
    public void testDFSStartingFromNode0() {
        boolean[] discovered = new boolean[7]; // An array to track discovered nodes
        ArrayList<Integer> visitedNodes = new ArrayList<>();

        dfs.dfs(0, discovered);

        // Check if all nodes reachable from node 0 are visited
        assertEquals(Arrays.asList(0, 1, 4, 3), visitedNodes);
    }

    @Test
    public void testDFSStartingFromNode2() {
        boolean[] discovered = new boolean[7]; // An array to track discovered nodes
        ArrayList<Integer> visitedNodes = new ArrayList<>();

        dfs.dfs(2, discovered);

        // Check if all nodes reachable from node 2 are visited
        assertEquals(Arrays.asList(2, 4, 1, 3, 0), visitedNodes);
    }

    @Test
    public void testDFSStartingFromNode6() {
        boolean[] discovered = new boolean[7]; // An array to track discovered nodes
        ArrayList<Integer> visitedNodes = new ArrayList<>();

        dfs.dfs(6, discovered);

        // Check if only node 6 is visited
        assertEquals(Arrays.asList(6), visitedNodes);
    }
}