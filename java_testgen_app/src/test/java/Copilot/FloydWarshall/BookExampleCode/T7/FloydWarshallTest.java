package Copilot.FloydWarshall.BookExampleCode.T7;

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
        assertEquals(0, floydWarshall.adj[0][0]);
        assertEquals(8, floydWarshall.adj[0][1]);
        assertEquals(9, floydWarshall.adj[0][2]);
        assertEquals(5, floydWarshall.adj[0][3]);
        assertEquals(7, floydWarshall.adj[0][4]);
        assertEquals(10, floydWarshall.adj[1][0]);
        assertEquals(0, floydWarshall.adj[1][1]);
        assertEquals(1, floydWarshall.adj[1][2]);
        assertEquals(3, floydWarshall.adj[1][3]);
        assertEquals(5, floydWarshall.adj[1][4]);
        assertEquals(9, floydWarshall.adj[2][0]);
        assertEquals(7, floydWarshall.adj[2][1]);
        assertEquals(0, floydWarshall.adj[2][2]);
        assertEquals(5, floydWarshall.adj[2][3]);
        assertEquals(4, floydWarshall.adj[2][4]);
        assertEquals(5, floydWarshall.adj[3][0]);
        assertEquals(3, floydWarshall.adj[3][1]);
        assertEquals(4, floydWarshall.adj[3][2]);
        assertEquals(0, floydWarshall.adj[3][3]);
        assertEquals(2, floydWarshall.adj[3][4]);
        assertEquals(7, floydWarshall.adj[4][0]);
        assertEquals(5, floydWarshall.adj[4][1]);
    }
}