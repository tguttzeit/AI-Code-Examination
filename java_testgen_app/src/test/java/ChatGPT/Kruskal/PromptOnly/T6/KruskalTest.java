package ChatGPT.Kruskal.PromptOnly.T6;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class KruskalTest {

    private List<Kruskal.Edge> graph1Edges;
    private List<Kruskal.Edge> graph2Edges;

    @Before
    public void setUp() {
        // Graph 1
        graph1Edges = Arrays.asList(
                new Kruskal.Edge(0, 1, 7),
                new Kruskal.Edge(1, 2, 8),
                new Kruskal.Edge(0, 3, 5),
                new Kruskal.Edge(1, 3, 9),
                new Kruskal.Edge(1, 4, 7),
                new Kruskal.Edge(2, 4, 5),
                new Kruskal.Edge(3, 4, 15),
                new Kruskal.Edge(3, 5, 6),
                new Kruskal.Edge(4, 5, 8),
                new Kruskal.Edge(4, 6, 9),
                new Kruskal.Edge(5, 6, 11)
        );

        // Graph 2
        graph2Edges = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 1, 4),
                new Kruskal.Edge(2, 1, 9),
                new Kruskal.Edge(2, 4, 3),
                new Kruskal.Edge(4, 3, 2)
        );
    }

    @Test
    public void testGraph1KruskalAlgorithm() {
        List<Kruskal.Edge> minimumSpanningTree = Kruskal.runKruskalAlgorithm(graph1Edges, 7);
        // You need to assert the correctness of the minimum spanning tree here.
        // Add assertions based on the expected result.
        // For example:
        // assertEquals(expectedEdgeList, minimumSpanningTree);
    }

    @Test
    public void testGraph2KruskalAlgorithm() {
        List<Kruskal.Edge> minimumSpanningTree = Kruskal.runKruskalAlgorithm(graph2Edges, 5);
        // You need to assert the correctness of the minimum spanning tree here.
        // Add assertions based on the expected result.
        // For example:
        // assertEquals(expectedEdgeList, minimumSpanningTree);
    }

    @Test
    public void testEmptyGraphKruskalAlgorithm() {
        List<Kruskal.Edge> minimumSpanningTree = Kruskal.runKruskalAlgorithm(Arrays.asList(), 0);
        // You need to assert the correctness of the minimum spanning tree here.
        // Add assertions based on the expected result.
        // For example:
        // assertTrue(minimumSpanningTree.isEmpty());
    }
}
