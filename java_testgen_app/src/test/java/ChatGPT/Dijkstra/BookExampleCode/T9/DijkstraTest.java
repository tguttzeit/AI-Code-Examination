package ChatGPT.Dijkstra.BookExampleCode.T9;

import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class DijkstraTest {
    private Dijkstra dijkstra;

    @Before
    public void setUp() {
        // Initialize the Dijkstra instance with the graph edges and number of vertices before each test
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        dijkstra = new Dijkstra(edges, 5);
    }

    @Test
    public void testShortestPathsGraph1() {
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);
        assertNotNull(shortestPaths);
        assertEquals(3, shortestPaths.size());
        assertEquals(Integer.valueOf(1), shortestPaths.get(1));
        assertEquals(Integer.valueOf(4), shortestPaths.get(2));
        assertEquals(Integer.valueOf(3), shortestPaths.get(3));
    }

    @Test
    public void testShortestPathsGraph2() {
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);
        assertNotNull(shortestPaths);
        assertEquals(3, shortestPaths.size());
        assertEquals(Integer.valueOf(1), shortestPaths.get(1));
        assertEquals(Integer.valueOf(4), shortestPaths.get(2));
        assertEquals(Integer.valueOf(3), shortestPaths.get(3));
    }

    @Test
    public void testShortestPathsGraph3() {
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
        assertNull(shortestPaths);
    }
}
