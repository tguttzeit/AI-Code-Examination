package Copilot.Dijkstra.BookExampleCode.T2;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DijkstraTest {
    List<Dijkstra.Edge> edges = Arrays.asList(
            new Dijkstra.Edge(0, 1, 1),
            new Dijkstra.Edge(0, 2, 4),
            new Dijkstra.Edge(1, 2, 3),
            new Dijkstra.Edge(1, 3, 2),
            new Dijkstra.Edge(1, 4, 2),
            new Dijkstra.Edge(3, 2, 5),
            new Dijkstra.Edge(4, 3, 3));

    @Test
    public void testOnlyPositiveEdgeCosts() {
        Dijkstra dijkstra = new Dijkstra(edges, 5);
        assertEquals(true, dijkstra.onlyPositiveEdgeCosts());
    }

    @Test
    public void testFindShortestPaths() {
        Dijkstra dijkstra = new Dijkstra(edges, 5);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 4);
        map.put(3, 3);
        map.put(4, 3);
        assertEquals(map, dijkstra.findShortestPaths(0));
    }

    @Test
    public void testFindShortestPaths1() {
        Dijkstra dijkstra = new Dijkstra(edges, 5);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 4);
        map.put(3, 3);
        map.put(4, 3);
        assertEquals(map, dijkstra.findShortestPaths(0));
    }

    @Test
    public void testFindShortestPaths2() {
        Dijkstra dijkstra = new Dijkstra(edges, 5);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 4);
        map.put(3, 3);
        map.put(4, 3);
        assertEquals(map, dijkstra.findShortestPaths(0));
    }
}