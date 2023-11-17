package ChatGPT.BreadthFirstSearch.BookExampleCode.T10;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GraphTest {

    @Test
    public void testBFSWithSingleNode() {
        Graph breadthFirstSearch = new Graph(1);
        int[] parent = breadthFirstSearch.bfs(0);

        // In a graph with a single node, there should be no parent.
        int[] expectedParent = { -1 };
        assertArrayEquals(expectedParent, parent);
    }

    @Test
    public void testBFSWithDisconnectedGraph() {
        Graph breadthFirstSearch = new Graph(5);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(2, 3);
        int[] parent = breadthFirstSearch.bfs(0);

        // In a disconnected graph, BFS should not reach the disconnected part.
        int[] expectedParent = { -1, 0, -1, -1, -1 };
        assertArrayEquals(expectedParent, parent);
    }

    @Test
    public void testBFSWithConnectedGraph() {
        Graph breadthFirstSearch = new Graph(6);
        breadthFirstSearch.addEdge(0, 1);
        breadthFirstSearch.addEdge(0, 2);
        breadthFirstSearch.addEdge(1, 3);
        breadthFirstSearch.addEdge(2, 3);
        breadthFirstSearch.addEdge(3, 4);
        breadthFirstSearch.addEdge(3, 5);

        int[] parent = breadthFirstSearch.bfs(0);

        // BFS from node 0 should produce the correct parent array.
        int[] expectedParent = { -1, 0, 0, 1, 3, 3 };
        assertArrayEquals(expectedParent, parent);
    }
}
