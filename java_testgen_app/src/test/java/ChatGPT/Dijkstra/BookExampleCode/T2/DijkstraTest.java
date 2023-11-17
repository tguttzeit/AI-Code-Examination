package ChatGPT.Dijkstra.BookExampleCode.T2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class DijkstraTest {
    private Dijkstra dijkstraGraph1;
    private Dijkstra dijkstraGraph2;
    private Dijkstra dijkstraGraph3;

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
        dijkstraGraph1 = new Dijkstra(edges1, 5);

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
        dijkstraGraph2 = new Dijkstra(edges2, 5);

        List<Dijkstra.Edge> edges3 = Arrays.asList(
                new Dijkstra.Edge(0, 0, 1),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        dijkstraGraph3 = new Dijkstra(edges3, 5);
    }

    @Test
    public void testShortestPathsGraph1() {
        Map<Integer, Integer> shortestPaths = dijkstraGraph1.findShortestPaths(0);
        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    @Test
    public void testShortestPathsGraph2() {
        Map<Integer, Integer> shortestPaths = dijkstraGraph2.findShortestPaths(0);
        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    @Test
    public void testShortestPathsGraph3() {
        Map<Integer, Integer> shortestPaths = dijkstraGraph3.findShortestPaths(0);
        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(1));
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(2));
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(3));
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(4));
    }
}
