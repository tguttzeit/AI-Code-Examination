package ChatGPT.Dijkstra.BookExampleCode.T3;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

public class DijkstraTest {

    // Test case for Graph 1
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
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        assertEquals(0, (int) shortestPaths.get(1));
        assertEquals(3, (int) shortestPaths.get(2));
        assertEquals(5, (int) shortestPaths.get(3));
        assertEquals(5, (int) shortestPaths.get(4));
    }

    // Test case for Graph 2
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
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        assertEquals(0, (int) shortestPaths.get(1));
        assertEquals(3, (int) shortestPaths.get(2));
        assertEquals(5, (int) shortestPaths.get(3));
        assertEquals(5, (int) shortestPaths.get(4));
    }

    // Test case for Graph 3
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
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        assertNull(shortestPaths.get(0));
        assertNull(shortestPaths.get(1));
        assertNull(shortestPaths.get(2));
        assertNull(shortestPaths.get(3));
        assertNull(shortestPaths.get(4));
    }
}
