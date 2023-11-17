package Copilot.BreadthFirstSearch.BookExampleCode.T2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GraphTest {

    Graph graph;
    @Before
    public void setUp() {
        this.graph = new Graph(6);
        this.graph.addEdge(0, 1);
        this.graph.addEdge(0, 2);
        this.graph.addEdge(1, 3);
        this.graph.addEdge(2, 3);
        this.graph.addEdge(3, 4);
        this.graph.addEdge(3, 5);
    }

    @Test
    public void testBFS() {
        int[] expected = {-1, 0, 0, 1, 3, 3};
        int[] actual = this.graph.bfs(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBFS2() {
        int[] expected = {-1, 3, 3, 1, 3, 3};
        int[] actual = this.graph.bfs(3);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testBFS3() {
        int[] expected = {-1, -1, -1, -1, -1, -1};
        int[] actual = this.graph.bfs(5);
        assertArrayEquals(expected, actual);
    }



}