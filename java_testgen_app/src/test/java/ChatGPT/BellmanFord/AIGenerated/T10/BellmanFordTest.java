package ChatGPT.BellmanFord.AIGenerated.T10;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BellmanFordTest {
    // Define your Edge objects for each graph
    private List<BellmanFord.Edge> graph1Edges;
    private List<BellmanFord.Edge> graph2Edges;
    private List<BellmanFord.Edge> graph3Edges;

    @Before
    public void setUp() {
        // Define the edges for each graph
        graph1Edges = Arrays.asList(
                new BellmanFord.Edge(0, 0, 1),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2),
                new BellmanFord.Edge(1, 4, 2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(4, 3, 3)
        );

        graph2Edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 4, -2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(3, 1, 1),
                new BellmanFord.Edge(4, 3, -3)
        );

        graph3Edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2),
                new BellmanFord.Edge(1, 4, 2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(3, 1, 1),
                new BellmanFord.Edge(4, 3, -3)
        );
    }

    @Test
    public void testGraph1() {
        Map<Integer, Integer> result = BellmanFord.bellmanFord(graph1Edges, 0, 5);
        assertNotNull(result);
        assertEquals(0, (int) result.get(0));
        assertEquals(5, (int) result.get(1));
        assertEquals(7, (int) result.get(2));
        assertEquals(2, (int) result.get(3));
        assertEquals(4, (int) result.get(4));
    }

    @Test
    public void testGraph2() {
        Map<Integer, Integer> result = BellmanFord.bellmanFord(graph2Edges, 0, 5);
        assertNotNull(result);
        assertEquals(0, (int) result.get(0));
        assertEquals(-1, (int) result.get(1));
        assertEquals(2, (int) result.get(2));
        assertEquals(-2, (int) result.get(3));
        assertEquals(-4, (int) result.get(4));
    }

    @Test
    public void testGraph3() {
        Map<Integer, Integer> result = BellmanFord.bellmanFord(graph3Edges, 0, 5);
        assertNotNull(result);
        assertEquals(0, (int) result.get(0));
        assertEquals(-1, (int) result.get(1));
        assertEquals(2, (int) result.get(2));
        assertEquals(4, (int) result.get(3));
        assertEquals(2, (int) result.get(4));
    }
}
