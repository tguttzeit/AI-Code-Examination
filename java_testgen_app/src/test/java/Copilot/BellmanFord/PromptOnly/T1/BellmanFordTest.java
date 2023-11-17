package Copilot.BellmanFord.PromptOnly.T1;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BellmanFordTest {
    @Test
    public void testBellmanFord1() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 0, 1),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2),
                new BellmanFord.Edge(1, 4, 2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(4, 3, 3));
        int source = 0;
        int n = 5;
        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, source, n);
        assertEquals(result.get(0), Integer.valueOf(0));
        assertEquals(result.get(1), Integer.valueOf(1));
        assertEquals(result.get(2), Integer.valueOf(4));
        assertEquals(result.get(3), Integer.valueOf(3));
        assertEquals(result.get(4), Integer.valueOf(3));
    }

    @Test
    public void testBellmanFord2() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 4, -2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(3, 1, 1),
                new BellmanFord.Edge(4, 3, -3));
        int source = 0;
        int n = 5;
        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, source, n);
        assertEquals(result.get(0), Integer.valueOf(0));
        assertEquals(result.get(1), Integer.valueOf(-1));
        assertEquals(result.get(2), Integer.valueOf(2));
        assertEquals(result.get(3), Integer.valueOf(-2));
        assertEquals(result.get(4), Integer.valueOf(1));
    }

    @Test
    public void testBellmanFord3() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, 1));
    }
}