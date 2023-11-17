package ChatGPT.Kruskal.AIGenerated.T6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KruskalTest {

    @Test
    public void testGraph1() {
        List<Kruskal.Edge> edges = new ArrayList<>();
        edges.add(new Kruskal.Edge(0, 1, 7));
        edges.add(new Kruskal.Edge(1, 2, 8));
        edges.add(new Kruskal.Edge(0, 3, 5));
        edges.add(new Kruskal.Edge(1, 3, 9));
        edges.add(new Kruskal.Edge(1, 4, 7));
        edges.add(new Kruskal.Edge(2, 4, 5));
        edges.add(new Kruskal.Edge(3, 4, 15));
        edges.add(new Kruskal.Edge(3, 5, 6));
        edges.add(new Kruskal.Edge(4, 5, 8));
        edges.add(new Kruskal.Edge(4, 6, 9));
        edges.add(new Kruskal.Edge(5, 6, 11));

        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 7);

        // Define the expected minimum spanning tree for Graph 1
        List<Kruskal.Edge> expectedMST = new ArrayList<>();
        expectedMST.add(new Kruskal.Edge(0, 3, 5));
        expectedMST.add(new Kruskal.Edge(1, 0, 7));
        expectedMST.add(new Kruskal.Edge(2, 4, 5));
        expectedMST.add(new Kruskal.Edge(3, 5, 6));
        expectedMST.add(new Kruskal.Edge(4, 1, 7));
        expectedMST.add(new Kruskal.Edge(5, 6, 11));

        // Check if the calculated MST is equal to the expected MST
        assertEquals(expectedMST, mst);
    }

    @Test
    public void testGraph2() {
        List<Kruskal.Edge> edges = new ArrayList<>();
        edges.add(new Kruskal.Edge(0, 1, -3));
        edges.add(new Kruskal.Edge(0, 4, 1));
        edges.add(new Kruskal.Edge(4, 1, 4));
        edges.add(new Kruskal.Edge(2, 1, 9));
        edges.add(new Kruskal.Edge(2, 4, 3));
        edges.add(new Kruskal.Edge(4, 3, 2));

        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 5);

        // Define the expected minimum spanning tree for Graph 2
        List<Kruskal.Edge> expectedMST = new ArrayList<>();
        expectedMST.add(new Kruskal.Edge(0, 1, -3));
        expectedMST.add(new Kruskal.Edge(0, 4, 1));
        expectedMST.add(new Kruskal.Edge(4, 3, 2));

        // Check if the calculated MST is equal to the expected MST
        assertEquals(expectedMST, mst);
    }

    @Test
    public void testEmptyGraph() {
        List<Kruskal.Edge> edges = new ArrayList<>();

        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 0);

        // The MST of an empty graph should also be empty
        assertTrue(mst.isEmpty());
    }
}
