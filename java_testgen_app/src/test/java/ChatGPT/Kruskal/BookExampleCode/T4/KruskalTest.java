package ChatGPT.Kruskal.BookExampleCode.T4;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KruskalTest {

    private List<Kruskal.Edge> edges1;
    private List<Kruskal.Edge> edges2;

    @Before
    public void setUp() {
        // Graph 1
        edges1 = Arrays.asList(
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
        edges2 = Arrays.asList(
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
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges1, 7);

        // Verify that the MST has the expected edges and total weight
        assertEquals(6, mst.size());
        assertTrue(mst.contains(new Kruskal.Edge(0, 1, 7)));
        assertTrue(mst.contains(new Kruskal.Edge(0, 3, 5)));
        assertTrue(mst.contains(new Kruskal.Edge(3, 5, 6)));
        assertTrue(mst.contains(new Kruskal.Edge(1, 4, 7)));
        assertTrue(mst.contains(new Kruskal.Edge(2, 4, 5)));
        assertTrue(mst.contains(new Kruskal.Edge(4, 6, 9)));
    }

    @Test
    public void testKruskalAlgorithmGraph2() {
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges2, 5);

        // Verify that the MST has the expected edges and total weight
        assertEquals(4, mst.size());
        assertTrue(mst.contains(new Kruskal.Edge(0, 1, -3)));
        assertTrue(mst.contains(new Kruskal.Edge(0, 4, 1)));
        assertTrue(mst.contains(new Kruskal.Edge(4, 3, 2)));
        assertTrue(mst.contains(new Kruskal.Edge(2, 4, 3)));
    }

    @Test
    public void testKruskalAlgorithmEmptyGraph() {
        List<Kruskal.Edge> emptyEdges = Arrays.asList();
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(emptyEdges, 0);

        // An empty graph should result in an empty MST
        assertEquals(0, mst.size());
    }
}
