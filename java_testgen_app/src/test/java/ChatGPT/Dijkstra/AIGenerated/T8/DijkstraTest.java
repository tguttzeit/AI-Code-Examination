package ChatGPT.Dijkstra.AIGenerated.T8;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class DijkstraTest {
    private List<Dijkstra.Edge> edges1, edges2, edges3;

    @Before
    public void setUp() {
        // Graph 1
        edges1 = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );

        // Graph 2
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

        // Graph 3
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
    public void testShortestPathsGraph1() {
        Dijkstra dijkstra = new Dijkstra(edges1, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    @Test
    public void testShortestPathsGraph2() {
        Dijkstra dijkstra = new Dijkstra(edges2, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    @Test
    public void testShortestPathsGraph3() {
        Dijkstra dijkstra = new Dijkstra(edges3, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(1));
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(2));
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(3));
        assertEquals(Integer.MAX_VALUE, (int) shortestPaths.get(4));
    }
}
