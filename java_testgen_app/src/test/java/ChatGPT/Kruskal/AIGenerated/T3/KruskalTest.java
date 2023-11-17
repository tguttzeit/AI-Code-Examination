package ChatGPT.Kruskal.AIGenerated.T3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KruskalTest {

    @Test
    public void testKruskalAlgorithmGraph1() {
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

        // Expected minimum spanning tree edges in Graph 1
        List<Kruskal.Edge> expectedMST = Arrays.asList(
                new Kruskal.Edge(0, 3, 5),
                new Kruskal.Edge(1, 0, 7),
                new Kruskal.Edge(2, 4, 5),
                new Kruskal.Edge(3, 5, 6),
                new Kruskal.Edge(4, 1, 7),
                new Kruskal.Edge(5, 4, 8)
        );

        assertEquals(expectedMST.size(), mst.size());
        assertTrue(mst.containsAll(expectedMST));
    }

    @Test
    public void testKruskalAlgorithmGraph2() {
        List<Kruskal.Edge> edges = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 1, 4),
                new Kruskal.Edge(2, 1, 9),
                new Kruskal.Edge(2, 4, 3),
                new Kruskal.Edge(4, 3, 2)
        );

        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 5);

        // Expected minimum spanning tree edges in Graph 2
        List<Kruskal.Edge> expectedMST = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 3, 2),
                new Kruskal.Edge(2, 4, 3)
        );

        assertEquals(expectedMST.size(), mst.size());
        assertTrue(mst.containsAll(expectedMST));
    }

    @Test
    public void testKruskalAlgorithmEmptyGraph() {
        // Test an empty graph
        List<Kruskal.Edge> edges = new ArrayList<>();

        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 0);

        // Expected minimum spanning tree in an empty graph is an empty list
        assertTrue(mst.isEmpty());
    }
}
