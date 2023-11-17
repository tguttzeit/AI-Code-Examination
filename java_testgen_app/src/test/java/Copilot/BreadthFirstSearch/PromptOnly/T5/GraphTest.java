package Copilot.BreadthFirstSearch.PromptOnly.T5;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class GraphTest {
    @Test
    public void testConstructor() {
        Graph graph = new Graph(6);
        int[] expected = {-1, -1, -1, -1, -1, -1};
        int[] actual = graph.bfs(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddEdge() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        int[] expected = {-1, 0, 0, 1, -1, -1};
        int[] actual = graph.bfs(0);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddEdge2() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        int[] expected = {-1, 0, 0, 1, -1, -1};
        int[] actual = graph.bfs(1);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddEdge3() {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        int[] expected = {-1, 0, 0, 1, -1, -1};
        int[] actual = graph.bfs(2);
        assertArrayEquals(expected, actual);
    }


}