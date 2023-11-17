package ChatGPT.Dijkstra.PromptOnly.T10;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class DijkstraTest {

    private List<Dijkstra.Edge> edges1;
    private List<Dijkstra.Edge> edges2;
    private List<Dijkstra.Edge> edges3;

    @Before
    public void setUp() {
        // Define the edges for each graph
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

        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    @Test
    public void testGraph2ShortestPaths() {
        Dijkstra dijkstra = new Dijkstra(edges2, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    @Test
    public void testGraph3ShortestPaths() {
        Dijkstra dijkstra = new Dijkstra(edges3, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        assertEquals(0, (int) shortestPaths.get(0));
        assertFalse(shortestPaths.containsKey(1)); // No path to node 1
        assertFalse(shortestPaths.containsKey(2)); // No path to node 2
        assertFalse(shortestPaths.containsKey(3)); // No path to node 3
        assertFalse(shortestPaths.containsKey(4)); // No path to node 4
    }
}
