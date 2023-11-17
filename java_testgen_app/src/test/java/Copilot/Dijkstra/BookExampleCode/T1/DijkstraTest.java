package Copilot.Dijkstra.BookExampleCode.T1;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DijkstraTest {

    @Test
    public void testFindShortestPaths() {
        Dijkstra dijkstra = new Dijkstra(null, 5);
        Map<Integer, Integer> map = dijkstra.findShortestPaths(0);
        assertEquals(3, map.size());
        assertEquals(1, (int) map.get(1));
        assertEquals(4, (int) map.get(2));
        assertEquals(3, (int) map.get(3));
    }

    @Test
    public void testFindShortestPaths2() {
        Dijkstra dijkstra = new Dijkstra(null, 5);
        Map<Integer, Integer> map = dijkstra.findShortestPaths(0);
        assertEquals(4, map.size());
        assertEquals(1, (int) map.get(1));
        assertEquals(4, (int) map.get(2));
        assertEquals(3, (int) map.get(3));
        assertEquals(5, (int) map.get(4));
    }

    @Test
    public void testFindShortestPaths3() {
        Dijkstra dijkstra = new Dijkstra(null, 5);
        Map<Integer, Integer> map = dijkstra.findShortestPaths(0);
        assertEquals(3, map.size());
        assertEquals(1, (int) map.get(1));
        assertEquals(4, (int) map.get(2));
        assertEquals(3, (int) map.get(3));
    }

}
