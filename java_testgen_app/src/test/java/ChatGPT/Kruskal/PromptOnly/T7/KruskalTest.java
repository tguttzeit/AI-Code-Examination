package ChatGPT.Kruskal.PromptOnly.T7;

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
        // Build Graph 1
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

        // Build Graph 2
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
        // Check the size of the resulting MST and the total weight
        assertEquals(6, minimumSpanningTree.size());
        int totalWeight = minimumSpanningTree.stream().mapToInt(edge -> edge.weight).sum();
        assertEquals(39, totalWeight);
    }

    @Test
    public void testKruskalAlgorithmGraph2() {
        List<Kruskal.Edge> minimumSpanningTree = Kruskal.runKruskalAlgorithm(graph2Edges, 5);
        // Check the size of the resulting MST and the total weight
        assertEquals(4, minimumSpanningTree.size());
        int totalWeight = minimumSpanningTree.stream().mapToInt(edge -> edge.weight).sum();
        assertEquals(3, totalWeight);
    }

    @Test
    public void testKruskalAlgorithmEmptyGraph() {
        List<Kruskal.Edge> emptyEdges = Arrays.asList();
        List<Kruskal.Edge> minimumSpanningTree = Kruskal.runKruskalAlgorithm(emptyEdges, 0);
        // An empty graph should result in an empty MST
        assertEquals(0, minimumSpanningTree.size());
    }
}
