package ChatGPT.Dijkstra.BookExampleCode.T7;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DijkstraTest {

    private Dijkstra dijkstraGraph1;
    private Dijkstra dijkstraGraph2;
    private Dijkstra dijkstraGraph3;

    @Before
    public void setUp() {
        // Graph 1
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

        // Graph 2
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

        // Graph 3
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
        assertNotNull(shortestPaths);

        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    @Test
    public void testShortestPathsGraph2() {
        Map<Integer, Integer> shortestPaths = dijkstraGraph2.findShortestPaths(0);
        assertNotNull(shortestPaths);

        assertEquals(0, (int) shortestPaths.get(0));
        assertEquals(1, (int) shortestPaths.get(1));
        assertEquals(4, (int) shortestPaths.get(2));
        assertEquals(3, (int) shortestPaths.get(3));
        assertEquals(3, (int) shortestPaths.get(4));
    }

    @Test
    public void testShortestPathsGraph3() {
        // Graph 3 has negative weight edges, so there should be no shortest paths
        Map<Integer, Integer> shortestPaths = dijkstraGraph3.findShortestPaths(0);
        assertNull(shortestPaths);
    }
}
