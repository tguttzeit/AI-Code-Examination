package ChatGPT.Kruskal.PromptOnly.T8;

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
        // Define edges for Graph 1
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

        // Define edges for Graph 2
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
    public void testKruskalGraph1() {
        List<Kruskal.Edge> minimumSpanningTree = Kruskal.runKruskalAlgorithm(graph1Edges, 7);
        // Assert the expected number of edges in the minimum spanning tree
        assertEquals(6, minimumSpanningTree.size());
        // Add more assertions as needed for Graph 1
    }

    @Test
    public void testKruskalGraph2() {
        List<Kruskal.Edge> minimumSpanningTree = Kruskal.runKruskalAlgorithm(graph2Edges, 5);
        // Assert the expected number of edges in the minimum spanning tree
        assertEquals(4, minimumSpanningTree.size());
        // Add more assertions as needed for Graph 2
    }

    // Add more test cases if needed

}
