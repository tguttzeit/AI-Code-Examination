package ChatGPT.Dijkstra.PromptOnly.T1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DijkstraTest {
    private Dijkstra dijkstra;

    @Before
    public void setUp() {
        // Initialize the Dijkstra object with your graph
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        dijkstra = new Dijkstra(edges, 5); // Assuming n is 5 for this graph
    }

    @Test
    public void testOnlyPositiveEdgeCosts() {
        assertTrue(dijkstra.onlyPositiveEdgeCosts());
    }

    @Test
    public void testShortestPathsGraph1() {
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);
        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    @Test
    public void testShortestPathsGraph2() {
        // Create a new Dijkstra object for Graph 2
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(3, 1, 1),
                new Dijkstra.Edge(4, 3, 3)
        );
        dijkstra = new Dijkstra(edges, 5);

        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);
        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    @Test
    public void testShortestPathsGraph3() {
        // Create a new Dijkstra object for Graph 3
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 0, 1),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        dijkstra = new Dijkstra(edges, 5);

        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);
        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(1)); // No path
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(2)); // No path
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(3)); // No path
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(4)); // No path
    }
}
