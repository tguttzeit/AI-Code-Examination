package Copilot.FloydWarshall.BookExampleCode.T2;

import org.junit.Test;
import static org.junit.Assert.*;
public class FloydWarshallTest {
    @Test
    public void test1() {
        FloydWarshall fw = new FloydWarshall(5);
        fw.addEdge(0, 1, 10);
        fw.addEdge(0, 3, 5);
        fw.addEdge(1, 3, 2);
        fw.addEdge(1, 2, 1);
        fw.addEdge(2, 4, 4);
        fw.addEdge(3, 1, 3);
        fw.addEdge(3, 2, 9);
        fw.addEdge(3, 4, 2);
        fw.addEdge(4, 2, 6);
        fw.run();
        assertEquals(10, fw.adj[0][1]);
        assertEquals(5, fw.adj[0][3]);
        assertEquals(7, fw.adj[0][2]);
        assertEquals(5, fw.adj[1][3]);
        assertEquals(2, fw.adj[1][2]);
        assertEquals(4, fw.adj[2][4]);
        assertEquals(3, fw.adj[3][1]);
        assertEquals(2, fw.adj[3][2]);
        assertEquals(4, fw.adj[3][4]);
        assertEquals(6, fw.adj[4][2]);
    }

    @Test
    public void test2() {
        FloydWarshall fw = new FloydWarshall(5);
        fw.addEdge(0, 2, 5);
        fw.addEdge(1, 3, 5);
        fw.addEdge(2, 3, 4);
        fw.addEdge(3, 2, 4);
        fw.addEdge(4, 3, 4);
        fw.addEdge(2, 4, -2);
        fw.run();
        assertEquals(Integer.MAX_VALUE, fw.adj[0][0]);
        assertEquals(Integer.MAX_VALUE, fw.adj[0][1]);
        assertEquals(5, fw.adj[0][2]);
        assertEquals(Integer.MAX_VALUE, fw.adj[0][3]);
        assertEquals(Integer.MAX_VALUE, fw.adj[0][4]);
        assertEquals(Integer.MAX_VALUE, fw.adj[1][0]);
        assertEquals(Integer.MAX_VALUE, fw.adj[1][1]);
        assertEquals(Integer.MAX_VALUE, fw.adj[1][2]);
        assertEquals(5, fw.adj[1][3]);
        assertEquals(Integer.MAX_VALUE, fw.adj[1][4]);
        assertEquals(Integer.MAX_VALUE, fw.adj[2][0]);

    }
}