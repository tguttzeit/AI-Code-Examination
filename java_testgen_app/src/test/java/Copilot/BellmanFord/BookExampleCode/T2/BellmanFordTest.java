package Copilot.BellmanFord.BookExampleCode.T2;

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
        Map<Integer, Integer> pathMap = BellmanFord.bellmanFord(edges, 0, 5);
        assertEquals(1, (int) pathMap.get(0));
        assertEquals(3, (int) pathMap.get(2));
        assertEquals(2, (int) pathMap.get(3));
        assertEquals(2, (int) pathMap.get(4));
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
        Map<Integer, Integer> pathMap = BellmanFord.bellmanFord(edges, 0, 5);
        assertEquals(-1, (int) pathMap.get(1));
        assertEquals(2, (int) pathMap.get(2));
        assertEquals(-2, (int) pathMap.get(3));
        assertEquals(1, (int) pathMap.get(4));
    }

    @Test
    public void testBellmanFord3() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2));
    }
}