package Copilot.FloydWarshall.PromptOnly.T8;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class FloydWarshallTest {
    FloydWarshall floydWarshall;
    @Before
    public void setUp() throws Exception {
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
    }
    @Test
    public void testPath1() {
        List<Integer> path = floydWarshall.path(0, 4);
        assertEquals("[0, 3, 4]", path.toString());
    }
    @Test
    public void testPath2() {
        List<Integer> path = floydWarshall.path(1, 4);
        assertEquals("[1, 3, 4]", path.toString());
    }
    @Test
    public void testPath3() {
        List<Integer> path = floydWarshall.path(2, 4);
        assertEquals("[2, 4]", path.toString());
    }
    @Test
    public void testPath4() {
        List<Integer> path = floydWarshall.path(3, 4);
        assertEquals("[3, 4]", path.toString());
    }
    @Test
    public void testPath5() {
        List<Integer> path = floydWarshall.path(4, 4);
        assertEquals("[4]", path.toString());
    }
    @Test
    public void testPath6() {
        List<Integer> path = floydWarshall.path(0, 0);
        assertEquals("[0]", path.toString());
    }
    @Test
    public void testPath7() {
        List<Integer> path = floydWarshall.path(1, 1);
        assertEquals("[1]", path.toString());
    }
    @Test
    public void testPath8() {
        List<Integer> path = floydWarshall.path(2, 2);
        assertEquals("[2]", path.toString());

}