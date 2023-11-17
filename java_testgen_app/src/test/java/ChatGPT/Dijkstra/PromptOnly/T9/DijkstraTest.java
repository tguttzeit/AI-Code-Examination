package ChatGPT.Dijkstra.PromptOnly.T9;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class DijkstraTest {
    private List<Dijkstra.Edge> edgesGraph1;
    private List<Dijkstra.Edge> edgesGraph2;
    private List<Dijkstra.Edge> edgesGraph3;

    @Before
    public void setUp() {
        // Graph 1
        edgesGraph1 = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );

        // Graph 2
        edgesGraph2 = Arrays.asList(
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
        edgesGraph3 = Arrays.asList(
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
        Dijkstra dijkstra = new Dijkstra(edgesGraph1, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);
        Map<Integer, Integer> expectedPaths = new HashMap<>();
        expectedPaths.put(1, 1);
        expectedPaths.put(2, 4);
        expectedPaths.put(3, 3);
        expectedPaths.put(4, 3);

        assertEquals(expectedPaths, shortestPaths);
    }

    @Test
    public void testGraph2ShortestPaths() {
        Dijkstra dijkstra = new Dijkstra(edgesGraph2, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);
        Map<Integer, Integer> expectedPaths = new HashMap<>();
        expectedPaths.put(1, 1);
        expectedPaths.put(2, 4);
        expectedPaths.put(3, 3);
        expectedPaths.put(4, 3);

        assertEquals(expectedPaths, shortestPaths);
    }

    @Test
    public void testGraph3ShortestPaths() {
        Dijkstra dijkstra = new Dijkstra(edgesGraph3, 5);
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(0);
        Map<Integer, Integer> expectedPaths = new HashMap<>();
        expectedPaths.put(2, 3);
        expectedPaths.put(3, 2);
        expectedPaths.put(4, 2);

        assertEquals(expectedPaths, shortestPaths);
    }
}

