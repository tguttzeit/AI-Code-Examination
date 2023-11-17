package Copilot.BellmanFord.AIGenerated.T2;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.HashMap;
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
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 3);
        map.put(3, 2);
        map.put(4, 2);
        assertEquals(map, BellmanFord.bellmanFord(edges, 0, 5));
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
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, -1);
        map.put(2, 2);
        map.put(3, -2);
        map.put(4, -4);
        assertEquals(map, BellmanFord.bellmanFord(edges, 0, 5));
    }

    @Test
    public void test3() {
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 0, 0));
    }
}