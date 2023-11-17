package ChatGPT.Dijkstra.BookExampleCode.T4;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class DijkstraTest {
    private Dijkstra dijkstra;

    @Before
    public void setUp() {
        // Initialize the Dijkstra instance with the given edges and graph size
        List<Dijkstra.Edge> edges;
        int n;

        // Graph 1
        edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        n = 5;
        dijkstra = new Dijkstra(edges, n);
    }

    @Test
    public void testShortestPathGraph1() {
        // Test the shortest paths for Graph 1
        Map<Integer, Integer> result = dijkstra.findShortestPaths(0);

        // Expected shortest distances from source 0
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 1);
        expected.put(2, 4);
        expected.put(3, 3);
        expected.put(4, 3);

        assertEquals(expected, result);
    }

    @Test
    public void testShortestPathGraph2() {
        // Test the shortest paths for Graph 2
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
        int n = 5;
        dijkstra = new Dijkstra(edges, n);

        // Test the shortest paths for Graph 2
        Map<Integer, Integer> result = dijkstra.findShortestPaths(0);

        // Expected shortest distances from source 0
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 1);
        expected.put(2, 4);
        expected.put(3, 3);
        expected.put(4, 3);

        assertEquals(expected, result);
    }

    @Test
    public void testShortestPathGraph3() {
        // Test the shortest paths for Graph 3
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 0, 1),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        int n = 5;
        dijkstra = new Dijkstra(edges, n);

        // Test the shortest paths for Graph 3
        Map<Integer, Integer> result = dijkstra.findShortestPaths(0);

        // Expected result: Graph 3 has negative edge weight (0, 0, 1),
        // so there should be no valid shortest paths from source 0.
        assertNull(result);
    }
}
