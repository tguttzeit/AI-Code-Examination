package ChatGPT.Dijkstra.AIGenerated.T10;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DijkstraTest {
    private Dijkstra dijkstra;

    @Before
    public void setUp() {
        List<Dijkstra.Edge> edges1 = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );

        dijkstra = new Dijkstra(edges1, 5);
    }

    @Test
    public void testShortestPathGraph1() {
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);
        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(5, (int) shortestPaths.get(4));
    }

    @Test
    public void testShortestPathGraph2() {
        List<Dijkstra.Edge> edges2 = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(3, 1, 1),
                new Dijkstra.Edge(4, 3, 3)
        );

        dijkstra = new Dijkstra(edges2, 5);

        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);
        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(5, (int) shortestPaths.get(4));
    }

    @Test
    public void testShortestPathGraph3() {
        List<Dijkstra.Edge> edges3 = Arrays.asList(
                new Dijkstra.Edge(0, 0, 1),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );

        dijkstra = new Dijkstra(edges3, 5);

        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);
        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(1)); // No path to vertex 1
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(2)); // No path to vertex 2
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(3)); // No path to vertex 3
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(4)); // No path to vertex 4
    }
}
