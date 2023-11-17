package Copilot.BellmanFord.AIGenerated.T10;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BellmanFordTest {
    @Test
    public void test1() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 0, 1),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2),
                new BellmanFord.Edge(1, 4, 2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(4, 3, 3));
        Map<Integer, Integer> map = BellmanFord.bellmanFord(edges, 0, 5);
        assertEquals(0, (int) map.get(0));
        assertEquals(7, (int) map.get(2));
        assertEquals(5, (int) map.get(3));
        assertEquals(5, (int) map.get(4));
    }

    @Test
    public void test2() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 4, -2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(3, 1, 1),
                new BellmanFord.Edge(4, 3, -3));
        Map<Integer, Integer> map = BellmanFord.bellmanFord(edges, 0, 5);
        assertEquals(-1, (int) map.get(1));
        assertEquals(2, (int) map.get(2));
        assertEquals(0, (int) map.get(3));
        assertEquals(-2, (int) map.get(4));
    }

    @Test
    public void test3() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 0));
    }
}