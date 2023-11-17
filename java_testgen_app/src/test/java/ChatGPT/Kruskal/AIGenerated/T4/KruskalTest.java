package ChatGPT.Kruskal.AIGenerated.T4;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class KruskalTest {

    @Test
    public void testKruskalAlgorithmGraph1() {
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

        // The minimum spanning tree for this graph should have 6 edges.
        assertEquals(6, mst.size());
    }

    @Test
    public void testKruskalAlgorithmGraph2() {
        List<Kruskal.Edge> edges = new ArrayList<>();
        edges.add(new Kruskal.Edge(0, 1, -3));
        edges.add(new Kruskal.Edge(0, 4, 1));
        edges.add(new Kruskal.Edge(4, 1, 4));
        edges.add(new Kruskal.Edge(2, 1, 9));
        edges.add(new Kruskal.Edge(2, 4, 3));
        edges.add(new Kruskal.Edge(4, 3, 2));

        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 5);

        // The minimum spanning tree for this graph should have 4 edges.
        assertEquals(4, mst.size());
    }

    @Test
    public void testKruskalAlgorithmEmptyGraph() {
        List<Kruskal.Edge> edges = new ArrayList<>();
        List<Kruskal.Edge> mst = Kruskal.runKruskalAlgorithm(edges, 0);

        // The minimum spanning tree for an empty graph should be empty.
        assertEquals(0, mst.size());
    }
}
