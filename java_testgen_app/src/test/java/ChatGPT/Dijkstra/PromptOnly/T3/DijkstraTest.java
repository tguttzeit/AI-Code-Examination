package ChatGPT.Dijkstra.PromptOnly.T3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DijkstraTest {

    private List<Dijkstra.Edge> edges1;
    private List<Dijkstra.Edge> edges2;
    private List<Dijkstra.Edge> edges3;

    @Before
    public void setUp() {
        // Define the edges for three different graphs
        edges1 = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );

        edges2 = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(3, 1, 1),
                new Dijkstra.Edge(4, 3, 3)
        );

        edges3 = Arrays.asList(
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
        Dijkstra dijkstra = new Dijkstra(edges1, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // Add assertions to check the shortest paths for Graph 1
        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(5, (int) shortestPaths.get(4));
    }

    @Test
    public void testGraph2ShortestPaths() {
        Dijkstra dijkstra = new Dijkstra(edges2, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // Add assertions to check the shortest paths for Graph 2
        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(5, (int) shortestPaths.get(4));
    }

    @Test
    public void testGraph3ShortestPaths() {
        Dijkstra dijkstra = new Dijkstra(edges3, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // Add assertions to check the shortest paths for Graph 3
        assertEquals(0, (int) shortestPaths.get(0));
        assertNull(shortestPaths.get(1)); // No path from 0 to 1
        assertNull(shortestPaths.get(2)); // No path from 0 to 2
        assertNull(shortestPaths.get(3)); // No path from 0 to 3
        assertNull(shortestPaths.get(4)); // No path from 0 to 4
    }
}
