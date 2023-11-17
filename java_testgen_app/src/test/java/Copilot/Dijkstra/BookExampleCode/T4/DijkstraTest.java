package Copilot.Dijkstra.BookExampleCode.T4;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DijkstraTest {

    @Test
    public void testOnlyPositiveEdgeCosts() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3));
        Dijkstra dijkstra = new Dijkstra(edges, 5);
        assertTrue(dijkstra.onlyPositiveEdgeCosts());
    }

    @Test
    public void testFindShortestPaths() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3));
        Dijkstra dijkstra = new Dijkstra(edges, 5);
        Map<Integer, Integer> map = dijkstra.findShortestPaths(0);
        Map<Integer, Integer> expectedMap = new HashMap<>();
        expectedMap.put(1, 1);
        expectedMap.put(2, 4);
        expectedMap.put(3, 3);
        expectedMap.put(4, 3);
        assertEquals(expectedMap, map);
    }

    @Test
    public void testFindShortestPaths2() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 0, 0));
    }

}