package Copilot.FloydWarshall.PromptOnly.T7;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FloydWarshallTest {
    private static FloydWarshall floydWarshall;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        floydWarshall = new FloydWarshall(5);
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
    }

    @Test
    public void test1() {
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals("[0, 3, 4]", path.toString());
    }

    @Test
    public void test2() {
        List<Integer> path = floydWarshall.path(0, 0);
        assertEquals("[]", path.toString());
    }

    @Test
    public void test3() {
        List<Integer> path = floydWarshall.path(2, 1);
        assertEquals("[2, 4, 3, 1]", path.toString());
    }
}