package ChatGPT.Dijkstra.AIGenerated.T4;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DijkstraTest {

    private Dijkstra dijkstra;

    @Before
    public void setUp() {
        // Define the edges and create the Dijkstra object for each graph
    }

    @Test
    public void testShortestPathsGraph1() {
        // Create Graph 1
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

        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // Verify the shortest paths for Graph 1
        assertEquals(0, shortestPaths.get(0).intValue());
        assertEquals(1, shortestPaths.get(1).intValue());
        assertEquals(4, shortestPaths.get(2).intValue());
        assertEquals(3, shortestPaths.get(3).intValue());
        assertEquals(3, shortestPaths.get(4).intValue());
    }

    @Test
    public void testShortestPathsGraph2() {
        // Create Graph 2
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
        dijkstra = new Dijkstra(edges, 5);

        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // Verify the shortest paths for Graph 2
        assertEquals(0, shortestPaths.get(0).intValue());
        assertEquals(1, shortestPaths.get(1).intValue());
        assertEquals(4, shortestPaths.get(2).intValue());
        assertEquals(3, shortestPaths.get(3).intValue());
        assertEquals(3, shortestPaths.get(4).intValue());
    }

    @Test
    public void testShortestPathsGraph3() {
        // Create Graph 3
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 0, 1),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        dijkstra = new Dijkstra(edges, 5);

        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);

        // Verify the shortest paths for Graph 3
        assertEquals(0, shortestPaths.get(0).intValue());
        assertEquals(Integer.MAX_VALUE, shortestPaths.get(1).intValue());
        assertEquals(Integer.MAX_VALUE, shortestPaths.get(2).intValue());
        assertEquals(Integer.MAX_VALUE, shortestPaths.get(3).intValue());
        assertEquals(Integer.MAX_VALUE, shortestPaths.get(4).intValue());
    }
}
