package ChatGPT.Kruskal.PromptOnly.T9;

import org.junit.Test;

import java.util.*;

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

        List<Kruskal.Edge> result = Kruskal.runKruskalAlgorithm(edges, 7);

        // Create a set of edges in the minimum spanning tree for Graph 1
        Set<Kruskal.Edge> expectedEdges = new HashSet<>(Arrays.asList(
                new Kruskal.Edge(0, 1, 7),
                new Kruskal.Edge(0, 3, 5),
                new Kruskal.Edge(3, 5, 6),
                new Kruskal.Edge(1, 4, 7),
                new Kruskal.Edge(4, 2, 5),
                new Kruskal.Edge(4, 6, 9)
        ));

        // Check if the result contains all expected edges
        assertTrue(result.containsAll(expectedEdges));
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

        List<Kruskal.Edge> result = Kruskal.runKruskalAlgorithm(edges, 5);

        // Create a set of edges in the minimum spanning tree for Graph 2
        Set<Kruskal.Edge> expectedEdges = new HashSet<>(Arrays.asList(
                new Kruskal.Edge(0, 1, -3),
                new Kruskal.Edge(0, 4, 1),
                new Kruskal.Edge(4, 3, 2),
                new Kruskal.Edge(2, 4, 3)
        ));

        // Check if the result contains all expected edges
        assertTrue(result.containsAll(expectedEdges));
    }

    @Test
    public void testEmptyGraph() {
        // Test with an empty graph
        List<Kruskal.Edge> edges = Collections.emptyList();
        List<Kruskal.Edge> result = Kruskal.runKruskalAlgorithm(edges, 0);

        // The result should be an empty list since there are no edges
        assertTrue(result.isEmpty());
    }
}
