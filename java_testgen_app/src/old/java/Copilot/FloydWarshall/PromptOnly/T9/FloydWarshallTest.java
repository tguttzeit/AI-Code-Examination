package Copilot.FloydWarshall.PromptOnly.T9;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class FloydWarshallTest {
    private FloydWarshall floydWarshall;
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
        assertEquals(8, floydWarshall.getDist(0, 4));
        assertEquals(5, floydWarshall.getDist(0, 3));
        assertEquals(5, floydWarshall.getDist(1, 2));
        assertEquals(7, floydWarshall.getDist(0, 2));
        assertEquals(3, floydWarshall.getDist(1, 3));
        assertEquals(9, floydWarshall.getDist(3, 2));
        assertEquals(2, floydWarshall.getDist(3, 4));
        assertEquals(6, floydWarshall.getDist(4, 2));
        assertEquals(10, floydWarshall.getDist(0, 1));
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
        assertEquals(5, floydWarshall.getDist(0, 2));
        assertEquals(9, floydWarshall.getDist(1, 3));
        assertEquals(4, floydWarshall.getDist(2,

}