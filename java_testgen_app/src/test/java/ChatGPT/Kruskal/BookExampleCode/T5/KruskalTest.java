package ChatGPT.Kruskal.BookExampleCode.T5;

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
        // Graph 1 edges
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

        // Graph 2 edges
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
    public void testKruskalAlgorithmGraph1() {
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(graph1Edges, 7);

        // Expected MST edges and weights
        List<Kruskal.Edge> expectedMST = Arrays.asList(
                new Kruskal.Edge(0, 3, 5),
                new Kruskal.Edge(1, 0, 7),
                new Kruskal.Edge(1, 4, 7),
                new Kruskal.Edge(3, 5, 6),
                new Kruskal.Edge(4, 2, 5),
                new Kruskal.Edge(4, 6, 9)
        );

        assertEquals(expectedMST, mst);
    }

    @Test
    public void testKruskalAlgorithmGraph2() {
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(graph2Edges, 5);

        // Expected MST edges and weights
        List<Kruskal.Edge> expectedMST = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 3, 2),
                new Kruskal.Edge(4, 2, 3)
        );

        assertEquals(expectedMST, mst);
    }

    @Test
    public void testKruskalAlgorithmEmptyGraph() {
        List<Kruskal.Edge> emptyEdges = Arrays.asList();
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(emptyEdges, 0);

        assertEquals(0, mst.size());
    }
}
