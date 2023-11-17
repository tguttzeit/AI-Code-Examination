package Copilot.FloydWarshall.PromptOnly.T10;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FloydWarshallTest {
    FloydWarshall floydWarshall;
    @Before
    public void setUp() {
        floydWarshall = new FloydWarshall(5);
    }
    @Test
    public void test1() {
        floydWarshall.addEdge(0, 1, 10);
        floydWarshall.addEdge(0, 3, 5);
        floydWarshall.addEdge(1, 3, 2);
        floydWarshall.addEdge(1, 2, 1);
        floydWarshall.addEdge(2, 4, 4);
        floydWarshall.addEdge(3, 1, 3);
        floydWarshall.addEdge(3, 2, 9);
        floydWarshall.addEdge(3, 4, 2);
        floydWarshall.addEdge(4, 2, 6);
        floydWarshall.run();
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(path, Arrays.asList(0, 3, 4));
    }
    @Test
    public void test2() {
        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);
        floydWarshall.addEdge(2, 3, 4);
        floydWarshall.addEdge(3, 2, 4);
        floydWarshall.addEdge(4, 3, 4);
        floydWarshall.addEdge(2, 4, -2);
        floydWarshall.run();
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(path, Arrays.asList(0, 2, 4));
    }
    @Test
    public void test3() {
        floydWarshall.addEdge(0, 1, 1);
        floydWarshall.addEdge(1, 2, 1);
        floydWarshall.addEdge(2, 3, 1);
        floydWarshall.addEdge(3, 4, 1);
        floydWarshall.addEdge(4, 0, 1);
        floydWarshall.run();
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(path, Arrays.asList(0, 1, 2, 3, 4));
    }
}