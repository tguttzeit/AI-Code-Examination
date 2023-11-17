package Copilot.FloydWarshall.AIGenerated.T3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class FloydWarshallTest {
    @Test
    public void testPath1() {
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
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(new ArrayList<>(Arrays.asList(0, 3, 4)), path);
    }

    @Test
    public void testPath2() {
        FloydWarshall floydWarshall = new FloydWarshall(5);
        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);
        floydWarshall.addEdge(2, 3, 4);
        floydWarshall.addEdge(3, 2, 4);
        floydWarshall.addEdge(4, 3, 4);
        floydWarshall.addEdge(2, 4, -2);
        floydWarshall.run();
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(new ArrayList<>(Arrays.asList(0, 2, 4)), path);
    }

    @Test
    public void testPath3() {
        FloydWarshall floydWarshall = new FloydWarshall(5);
        floydWarshall.addEdge(0, 1, 10);
        floydWarshall.addEdge(0, 3, 5);
        floydWarshall.addEdge(1, 3, 2);
        floydWarshall.addEdge(1, 2, 1);
        floydWarshall.addEdge(2, 4, 4);
        floydWarshall.addEdge(3, 1, 3);
        floydWarshall.addEdge(3, 2, 0);
    }
}