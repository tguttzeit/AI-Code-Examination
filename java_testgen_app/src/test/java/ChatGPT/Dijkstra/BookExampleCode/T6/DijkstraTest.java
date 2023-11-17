package ChatGPT.Dijkstra.BookExampleCode.T6;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class DijkstraTest {

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

        Map<Integer, Integer> expectedPaths = new HashMap<>();
        expectedPaths.put(1, 1);
        expectedPaths.put(2, 4);
        expectedPaths.put(3, 3);
        expectedPaths.put(4, 3);

        assertEquals(expectedPaths, shortestPaths);
    }

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

        Map<Integer, Integer> expectedPaths = new HashMap<>();
        expectedPaths.put(1, 1);
        expectedPaths.put(2, 4);
        expectedPaths.put(3, 3);
        expectedPaths.put(4, 3);

        assertEquals(expectedPaths, shortestPaths);
    }

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

        assertNull(shortestPaths);
    }
}
