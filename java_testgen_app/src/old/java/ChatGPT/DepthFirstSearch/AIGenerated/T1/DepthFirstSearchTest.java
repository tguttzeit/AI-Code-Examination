package ChatGPT.DepthFirstSearch.AIGenerated.T1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

public class DepthFirstSearchTest {

    @Test
    public void testDFSOnGraph() {
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

        int numNodes = 7; // Total number of nodes in the graph
        DepthFirstSearch dfs = new DepthFirstSearch(edges, numNodes);

        boolean[] discovered = new boolean[numNodes];
        dfs.dfs(0, discovered);

        ArrayList<Integer> visitedNodes = dfs.visitedNodes;
        assertEquals(Arrays.asList(0, 1, 4, 3, 2, 5), visitedNodes);
    }

    @Test
    public void testDFSOnEmptyGraph() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList();
        int numNodes = 0; // Total number of nodes in the graph
        DepthFirstSearch dfs = new DepthFirstSearch(edges, numNodes);

        boolean[] discovered = new boolean[numNodes];
        dfs.dfs(0, discovered);

        ArrayList<Integer> visitedNodes = dfs.visitedNodes;
        assertEquals(0, visitedNodes.size());
    }

    @Test
    public void testDFSOnSingleNodeGraph() {
        List<DepthFirstSearch.Edge> edges = Arrays.asList();
        int numNodes = 1; // Total number of nodes in the graph
        DepthFirstSearch dfs = new DepthFirstSearch(edges, numNodes);

        boolean[] discovered = new boolean[numNodes];
        dfs.dfs(0, discovered);

        ArrayList<Integer> visitedNodes = dfs.visitedNodes;
        assertEquals(Arrays.asList(0), visitedNodes);
    }
}