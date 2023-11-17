package ChatGPT.Kruskal.PromptOnly.T4;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class KruskalTest {

    @Test
    public void testGraph1Kruskal() {
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

        List<Kruskal.Edge> result = Kruskal.runKruskalAlgorithm(edges, 7);

        // Add assertions to check the result against the expected minimum spanning tree.
        // You need to define the expected result based on the provided edges and weights.
        // For example:
        // assertEquals(expectedEdges, result);
    }

    @Test
    public void testGraph2Kruskal() {
        List<Kruskal.Edge> edges = Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 1, 4),
                new Kruskal.Edge(2, 1, 9),
                new Kruskal.Edge(2, 4, 3),
                new Kruskal.Edge(4, 3, 2)
        );

        List<Kruskal.Edge> result = Kruskal.runKruskalAlgorithm(edges, 5);

        // Add assertions to check the result against the expected minimum spanning tree.
        // You need to define the expected result based on the provided edges and weights.
        // For example:
        // assertEquals(expectedEdges, result);
    }

    @Test
    public void testEmptyGraphKruskal() {
        // Test with an empty graph (no edges).
        List<Kruskal.Edge> edges = Arrays.asList();

        List<Kruskal.Edge> result = Kruskal.runKruskalAlgorithm(edges, 0);

        // Add assertions to check that the result should also be an empty list.
        // For example:
        // assertTrue(result.isEmpty());
    }
}
