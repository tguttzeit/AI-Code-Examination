package Copilot.BellmanFord.PromptOnly.T8;

import org.junit.Test;
import static org.junit.Assert.*;

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
        Map<Integer, Integer> map = BellmanFord.bellmanFord(edges, 0, 5);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(2, 8);
        expected.put(3, 6);
        expected.put(4, 6);
        assertEquals(expected, map);
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
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, -1);
        expected.put(2, 2);
        expected.put(4, -2);
        assertEquals(expected, map);
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