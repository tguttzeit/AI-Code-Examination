package ChatGPT.Dijkstra.PromptOnly.T4;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class DijkstraTest {

    // Test Graph 1
    @Test
    public void testGraph1() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        Dijkstra dijkstra = new Dijkstra(edges, 5);

        // Test onlyPositiveEdgeCosts() method
        assertTrue(dijkstra.onlyPositiveEdgeCosts());

        // Test findShortestPaths() method
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    // Test Graph 2
    @Test
    public void testGraph2() {
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
        Dijkstra dijkstra = new Dijkstra(edges, 5);

        // Test onlyPositiveEdgeCosts() method
        assertTrue(dijkstra.onlyPositiveEdgeCosts());

        // Test findShortestPaths() method
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    // Test Graph 3
    @Test
    public void testGraph3() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 0, 1),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        Dijkstra dijkstra = new Dijkstra(edges, 5);

        // Test onlyPositiveEdgeCosts() method
        assertFalse(dijkstra.onlyPositiveEdgeCosts()); // Graph 3 has a negative edge cost

        // Test findShortestPaths() method
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // Verify that no paths exist for Graph 3 since it's not a valid graph
        assertNull(shortestPaths.get(0));
        assertNull(shortestPaths.get(1));
        assertNull(shortestPaths.get(2));
        assertNull(shortestPaths.get(3));
        assertNull(shortestPaths.get(4));
    }
}
