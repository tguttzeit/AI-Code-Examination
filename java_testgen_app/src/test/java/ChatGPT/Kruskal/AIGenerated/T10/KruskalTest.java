package ChatGPT.Kruskal.AIGenerated.T10;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KruskalTest {
    @Test
    public void testGraph1() {
        List<Kruskal.Edge> edges = Arrays.asList(
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

        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 7);

        // The minimum spanning tree for this graph should have 6 edges.
        assertEquals(6, mst.size());

        // You can add additional assertions to check specific edges in the MST if needed.
    }

    @Test
    public void testGraph2() {
        List<Kruskal.Edge> edges = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 1, 4),
                new Kruskal.Edge(2, 1, 9),
                new Kruskal.Edge(2, 4, 3),
                new Kruskal.Edge(4, 3, 2)
        );

        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 5);

        // The minimum spanning tree for this graph should have 4 edges.
        assertEquals(4, mst.size());

        // You can add additional assertions to check specific edges in the MST if needed.
    }

    @Test
    public void testEmptyGraph() {
        List<Kruskal.Edge> edges = Arrays.asList();
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 0);

        // The minimum spanning tree of an empty graph should be empty.
        assertTrue(mst.isEmpty());
    }
}
