package ChatGPT.FloydWarshall.PromptOnly.T3;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FloydWarshallTest {

    private FloydWarshall floydWarshall1;
    private FloydWarshall floydWarshall2;

    @Before
    public void setUp() {
        // Initialize Graph 1
        floydWarshall1 = new FloydWarshall(5);
        floydWarshall1.addEdge(0, 1, 10);
        floydWarshall1.addEdge(0, 3, 5);
        floydWarshall1.addEdge(1, 3, 2);
        floydWarshall1.addEdge(1, 2, 1);
        floydWarshall1.addEdge(2, 4, 4);
        floydWarshall1.addEdge(3, 1, 3);
        floydWarshall1.addEdge(3, 2, 9);
        floydWarshall1.addEdge(3, 4, 2);
        floydWarshall1.addEdge(4, 2, 6);

        // Initialize Graph 2
        floydWarshall2 = new FloydWarshall(5);
        floydWarshall2.addEdge(0, 2, 5);
        floydWarshall2.addEdge(1, 3, 5);
        floydWarshall2.addEdge(2, 3, 4);
        floydWarshall2.addEdge(3, 2, 4);
        floydWarshall2.addEdge(4, 3, 4);
        floydWarshall2.addEdge(2, 4, -2);
    }

    @Test
    public void testPathExistsGraph1() {
        List<Integer> path = floydWarshall1.path(0, 4);
        assertNotNull(path);
        assertEquals(3, path.size());
        assertEquals(Integer.valueOf(0), path.get(0));
        assertEquals(Integer.valueOf(3), path.get(1));
        assertEquals(Integer.valueOf(4), path.get(2));
    }

    @Test
    public void testPathExistsGraph2() {
        List<Integer> path = floydWarshall2.path(0, 3);
        assertNotNull(path);
        assertEquals(2, path.size());
        assertEquals(Integer.valueOf(0), path.get(0));
        assertEquals(Integer.valueOf(2), path.get(1));
    }

    @Test
    public void testNoPathGraph1() {
        List<Integer> path = floydWarshall1.path(4, 0);
        assertNull(path);
    }

    @Test
    public void testNoPathGraph2() {
        List<Integer> path = floydWarshall2.path(1, 4);
        assertNull(path);
    }
}
