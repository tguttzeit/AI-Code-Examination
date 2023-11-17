from py_testgen_app.src.Copilot.BreadthFirstSearch.PromptOnly.T6.graph import Graph

import unittest


class GraphTest(unittest.TestCase):
    # Implement a test method called test_bfs_0() that tests the bfs() method of the Graph class.
    def test_bfs_0(self):
        # Create a Graph object with 6 vertices.
        self.graph = Graph(6)
        # Build a graph with the following edges:
        self.graph.add_edge(0, 1)
        self.graph.add_edge(1, 0)
        self.graph.add_edge(0, 2)
        self.graph.add_edge(2, 0)
        self.graph.add_edge(1, 3)
        self.graph.add_edge(3, 1)
        self.graph.add_edge(2, 3)
        self.graph.add_edge(3, 2)
        self.graph.add_edge(3, 4)
        self.graph.add_edge(4, 3)
        self.graph.add_edge(3, 5)
        self.graph.add_edge(5, 3)
        # Call the bfs() method with vertex 0 as parameter.
        # Assert that the returned list is equal to [0, 1, 2, 3, 4, 5].
        self.assertEqual(self.graph.bfs(0), [0, 1, 2, 3, 4, 5])

    # Implement a test method called test_bfs_1() that tests the bfs() method of the Graph class.
    def test_bfs_1(self):
        # Create a Graph object with 6 vertices.
        self.graph = Graph(6)
        # Build a graph with the following edges:
        self.graph.add_edge(0, 1)
        self.graph.add_edge(1, 0)
        self.graph.add_edge(0, 2)
        self.graph.add_edge(2, 0)
        self.graph.add_edge(1, 3)
        self.graph.add_edge(3, 1)
        self.graph.add_edge(2, 3)
        self.graph.add_edge(3, 2)
        self.graph.add_edge(3, 4)
        self.graph.add_edge(4, 3)
        self.graph.add_edge(3, 5)
        self.graph.add_edge(5, 3)
        # Call the bfs() method with vertex 1 as parameter.
        # Assert that the returned list is equal to [1, 0, 3, 2, 4,
