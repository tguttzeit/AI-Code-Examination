package Copilot.BreadthFirstSearch.AIGenerated.T9;

import org.junit.Test;

import org.junit.Assert;

public class GraphTest {
    @Test
    public void testBFS() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);

        int[] expected = new int[] { -1, 0, 0, 1, 3, 3 };
        int[] actual = breadthFirstSearch.bfs(0);
        Assert.assertArrayEquals(expected, actual);
    }
}
