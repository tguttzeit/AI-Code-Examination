package Copilot.FloydWarshall.AIGenerated.T10;

import org.junit.Test;
import static org.junit.Assert.*;

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
        assertEquals(0, floydWarshall.dist[0][0]);
        assertEquals(10, floydWarshall.dist[0][1]);
        assertEquals(9, floydWarshall.dist[0][2]);
        assertEquals(5, floydWarshall.dist[0][3]);
        assertEquals(7, floydWarshall.dist[0][4]);
        assertEquals(12, floydWarshall.dist[1][0]);
        assertEquals(0, floydWarshall.dist[1][1]);
        assertEquals(1, floydWarshall.dist[1][2]);
        assertEquals(3, floydWarshall.dist[1][3]);
        assertEquals(5, floydWarshall.dist[1][4]);
        assertEquals(13, floydWarshall.dist[2][0]);
        assertEquals(11, floydWarshall.dist[2][1]);
        assertEquals(0, floydWarshall.dist[2][2]);
        assertEquals(10, floydWarshall.dist[2][3]);
        assertEquals(4, floydWarshall.dist[2][4]);
        assertEquals(5, floydWarshall.dist[3][0]);
        assertEquals(3, floydWarshall.dist[3][1]);
        assertEquals(2, floydWarshall.dist[3][2]);
        assertEquals(0, floydWarshall.dist[3][3]);
        assertEquals(2, floydWarshall.dist[3][4]);
        assertEquals(11, floydWarshall.dist[4][0]);
        assertEquals(9, floydWarshall.dist[4][1]);
    }
}