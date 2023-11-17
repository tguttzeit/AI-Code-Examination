package Copilot.FloydWarshall.PromptOnly.T6;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class FloydWarshallTest {
    @Test
    public void test1() {
        FloydWarshall floydWarshall = new FloydWarshall(5);
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
        assertEquals(Arrays.asList(0, 1, 2, 4), floydWarshall.path(0, 4));
        assertEquals(Arrays.asList(0, 1, 3, 4), floydWarshall.path(0, 4));
        assertEquals(Arrays.asList(0, 3, 4), floydWarshall.path(0, 4));
        assertEquals(Arrays.asList(0, 1, 2), floydWarshall.path(0, 2));
        assertEquals(Arrays.asList(0, 3, 4), floydWarshall.path(0, 4));
        assertEquals(Arrays.asList(0, 1, 3), floydWarshall.path(0, 3));
        assertEquals(Arrays.asList(0, 1), floydWarshall.path(0, 1));
        assertEquals(Arrays.asList(0), floydWarshall.path(0, 0));
        assertEquals(Arrays.asList(1, 3, 4), floydWarshall.path(1, 4));
        assertEquals(Arrays.asList(1, 2), floydWarshall.path(1, 2));
        assertEquals(Arrays.asList(1, 3), floydWarshall.path(1, 3));
        assertEquals(Arrays.asList(1), floydWarshall.path(1, 1));
        assertEquals(Arrays.asList(2, 4), floydWarshall.path(2, 4));
        assertEquals(Arrays.asList(2), floydWarshall.path(2, 2));
    }
}