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
    }
}