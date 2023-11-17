package Copilot.BellmanFord.PromptOnly.T4;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BellmanFordTest {
    @Test
    public void test1(){
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 0, 1),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 3, 2),
                new BellmanFord.Edge(1, 4, 2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(4, 3, 3)
        );
        int source = 0;
        int n = 5;
        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, source, n);
        Map<Integer, Integer> expected = new HashMap<Integer, Integer>();
        expected.put(1, 1);
        expected.put(2, 4);
        expected.put(3, 3);
        expected.put(4, 3);
        assertEquals(expected, result);
    }
    @Test
    public void test2(){
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2, 4),
                new BellmanFord.Edge(1, 2, 3),
                new BellmanFord.Edge(1, 4, -2),
                new BellmanFord.Edge(3, 2, 5),
                new BellmanFord.Edge(3, 1, 1),
                new BellmanFord.Edge(4, 3, -3)
        );
        int source = 0;
        int n = 5;
        Map<Integer, Integer> result = BellmanFord.bellmanFord(edges, source, n);
        Map<Integer, Integer> expected = new HashMap<Integer, Integer>();
        expected.put(1, -1);
        expected.put(2, 2);
        expected.put(3, 4);
        expected.put(4, 0);
        assertEquals(expected, result);
    }
    @Test
    public void test3(){
        List<BellmanFord.Edge> edges = Arrays.asList(
                new BellmanFord.Edge(0, 1, -1),
                new BellmanFord.Edge(0, 2,
}