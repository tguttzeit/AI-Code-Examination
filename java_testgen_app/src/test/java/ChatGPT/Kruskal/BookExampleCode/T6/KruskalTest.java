package ChatGPT.Kruskal.BookExampleCode.T6;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
    public void testKruskalAlgorithmGraph1() {
        List<Kruskal.Edge> minimumSpanningTree = Kruskal.runKruskalAlgorithm(graph1Edges, 7);

        // Expected minimum spanning tree edges
        List<Kruskal.Edge> expectedMST = Arrays.asList(
                new Kruskal.Edge(0, 3, 5),
                new Kruskal.Edge(1, 0, 7),
                new Kruskal.Edge(1, 4, 7),
                new Kruskal.Edge(3, 5, 6),
                new Kruskal.Edge(4, 2, 5),
                new Kruskal.Edge(4, 6, 9)
        );

        assertEquals(expectedMST.size(), minimumSpanningTree.size());
        for (Kruskal.Edge edge : expectedMST) {
            assertTrue(minimumSpanningTree.contains(edge));
        }
    }

    @Test
    public void testKruskalAlgorithmGraph2() {
        List<Kruskal.Edge> minimumSpanningTree = Kruskal.runKruskalAlgorithm(graph2Edges, 5);

        // Expected minimum spanning tree edges
        List<Kruskal.Edge> expectedMST = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 3, 2),
                new Kruskal.Edge(2, 4, 3)
        );

        assertEquals(expectedMST.size(), minimumSpanningTree.size());
        for (Kruskal.Edge edge : expectedMST) {
            assertTrue(minimumSpanningTree.contains(edge));
        }
    }

    @Test
    public void testKruskalAlgorithmEmptyGraph() {
        // Test with an empty graph
        List<Kruskal.Edge> minimumSpanningTree = Kruskal.runKruskalAlgorithm(Arrays.asList(), 0);
        assertEquals(0, minimumSpanningTree.size());
    }
}
