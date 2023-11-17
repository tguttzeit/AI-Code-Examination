package Copilot.BellmanFord.PromptOnly.T7;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BellmanFordTest {
    List<BellmanFord.Edge> edges = Arrays.asList(
            new BellmanFord.Edge(0, 1, -1),
            new BellmanFord.Edge(0, 2, 4),
            new BellmanFord.Edge(1, 2, 3),
            new BellmanFord.Edge(1, 3, 2),
            new BellmanFord.Edge(1, 4, 2),
            new BellmanFord.Edge(3, 2, 5),
            new BellmanFord.Edge(3, 1, 1),
            new BellmanFord.Edge(4, 3, -3));

    @Test
    public void testBellmanFord() {
        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, 0, 5);
        assertEquals(0, result.get(0).intValue());
        assertEquals(-1, result.get(1).intValue());
        assertEquals(2, result.get(2).intValue());
        assertEquals(-2, result.get(3).intValue());
        assertEquals(1, result.get(4).intValue());
    }

    @Test
    public void testBellmanFord1() {
        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, 0, 5);
        assertEquals(0, result.get(0).intValue());
        assertEquals(-1, result.get(1).intValue());
        assertEquals(2, result.get(2).intValue());
        assertEquals(-2, result.get(3).intValue());
        assertEquals(1, result.get(4).intValue());
    }

    @Test
    public void testBellmanFord2() {
        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, 0, 5);
        assertEquals(0, result.get(0).intValue());
        assertEquals(-1, result.get(1).intValue());
        assertEquals(2, result.get(2).intValue());
        assertEquals(-2, result.get(3).intValue());
        assertEquals(1, result.get(4).intValue());
    }

}