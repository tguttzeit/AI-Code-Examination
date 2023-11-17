package Copilot.FloydWarshall.BookExampleCode.T8;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

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
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(0, (int) path.get(0));
        assertEquals(3, (int) path.get(1));
        assertEquals(4, (int) path.get(2));
    }

    @Test
    public void test2() {
        FloydWarshall floydWarshall = new FloydWarshall(5);
        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);
        floydWarshall.addEdge(2, 3, 4);
        floydWarshall.addEdge(3, 2, 4);
        floydWarshall.addEdge(4, 3, 4);
        floydWarshall.addEdge(2, 4, -2);
        floydWarshall.run();
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals(0, (int) path.get(0));
        assertEquals(2, (int) path.get(1));
        assertEquals(4, (int) path.get(2));
    }

    @Test
    public void test3() {
        FloydWarshall floydWarshall = new FloydWarshall(5);
        floydWarshall.addEdge(0, 2, 5);
        floydWarshall.addEdge(1, 3, 5);
        floydWarshall.addEdge(2, 3, 4);
        floydWarshall.addEdge(3, 2, 4);
        floyd

}