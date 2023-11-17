package ChatGPT.Dijkstra.PromptOnly.T7;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class DijkstraTest {
    private List<Dijkstra.Edge> graph1Edges;
    private List<Dijkstra.Edge> graph2Edges;
    private List<Dijkstra.Edge> graph3Edges;

    @Before
    public void setUp() {
        // Initialize graph edges for each test case
        graph1Edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );

        graph2Edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(3, 1, 1),
                new Dijkstra.Edge(4, 3, 3)
        );

        graph3Edges = Arrays.asList(
                new Dijkstra.Edge(0, 0, 1),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
    }

    @Test
    public void testGraph1ShortestPaths() {
        Dijkstra dijkstra = new Dijkstra(graph1Edges, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // Assert the shortest paths for nodes in Graph 1
        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    @Test
    public void testGraph2ShortestPaths() {
        Dijkstra dijkstra = new Dijkstra(graph2Edges, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // Assert the shortest paths for nodes in Graph 2
        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    @Test
    public void testGraph3ShortestPaths() {
        Dijkstra dijkstra = new Dijkstra(graph3Edges, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // Assert the shortest paths for nodes in Graph 3
        assertEquals(0, (int) shortestPaths.get(0));
        assertNull(shortestPaths.get(1)); // No path to node 1
        assertNull(shortestPaths.get(2)); // No path to node 2
        assertNull(shortestPaths.get(3)); // No path to node 3
        assertNull(shortestPaths.get(4)); // No path to node 4
    }
}
