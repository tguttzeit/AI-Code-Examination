package Copilot.Dijkstra.AIGenerated.T3;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class DijkstraTest {
    @Test
    public void testDijkstra1() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 1, 1),
                new Dijkstra.Edge(0, 2, 4),
                new Dijkstra.Edge(1, 2, 3),
                new Dijkstra.Edge(1, 3, 2),
                new Dijkstra.Edge(1, 4, 2),
                new Dijkstra.Edge(3, 2, 5),
                new Dijkstra.Edge(4, 3, 3)
        );
        int n = 5;
        Dijkstra dijkstra = new Dijkstra(edges, n);
        Map<Integer, Integer> map = dijkstra.findShortestPaths(0);
        assertEquals(0, map.get(0));
        assertEquals(1, map.get(1));
        assertEquals(4, map.get(2));
        assertEquals(3, map.get(3));
        assertEquals(3, map.get(4));
    }

    @Test
    public void testDijkstra2() {
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
        Dijkstra dijkstra = new Dijkstra(edges, n);
        Map<Integer, Integer> map = dijkstra.findShortestPaths(0);
        assertEquals(0, map.get(0));
        assertEquals(1, map.get(1));
        assertEquals(4, map.get(2));
        assertEquals(3, map.get(3));
        assertEquals(3, map.get(4));
    }

    @Test
    public void testDijkstra3() {
        List<Dijkstra.Edge> edges = Arrays.asList(
                new Dijkstra.Edge(0, 0,



    }