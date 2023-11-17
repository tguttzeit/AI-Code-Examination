package ChatGPT.Kruskal.AIGenerated.T8;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KruskalTest {

    private List<Kruskal.Edge> graph1Edges;
    private List<Kruskal.Edge> graph2Edges;

    @Before
    public void setUp() {
        // Graph 1 edges and weights
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

        // Graph 2 edges and weights
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
    public void testKruskalGraph1() {
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(graph1Edges, 7);

        // Expected edges in the minimum spanning tree for Graph 1
        List<Kruskal.Edge> expectedMST = Arrays.asList(
                new Kruskal.Edge(0, 3, 5),
                new Kruskal.Edge(1, 0, 7),
                new Kruskal.Edge(1, 4, 7),
                new Kruskal.Edge(3, 5, 6),
                new Kruskal.Edge(2, 4, 5),
                new Kruskal.Edge(4, 6, 9)
        );

        assertEquals(expectedMST, mst);
    }

    @Test
    public void testKruskalGraph2() {
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(graph2Edges, 5);

        // Expected edges in the minimum spanning tree for Graph 2
        List<Kruskal.Edge> expectedMST = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 3, 2),
                new Kruskal.Edge(2, 4, 3)
        );

        assertEquals(expectedMST, mst);
    }

    @Test
    public void testKruskalEmptyGraph() {
        // Test with an empty graph
        List<Kruskal.Edge> emptyGraph = Arrays.asList();
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(emptyGraph, 0);

        // Expected MST in an empty graph is an empty list
        List<Kruskal.Edge> expectedMST = Arrays.asList();

        assertEquals(expectedMST, mst);
    }
}
