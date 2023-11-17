from py_testgen_app.src.Copilot.BreadthFirstSearch.PromptOnly.T9.graph import Graph

import unittest

class GraphTest(unittest.TestCase):
    # Implement a test case called test_bfs_0.
    # The test case calls the method bfs() with the parameter 0 and compares the result with the expected result [0, 1, 2, 3, 4, 5].
    def test_bfs_0(self):
        # Arrange
        self.graph = Graph(6)
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
        expected = [0, 1, 2, 3, 4, 5]
        # Act
        actual = self.graph.bfs(0)
        # Assert
        self.assertEqual(expected, actual)

    # Implement a test case called test_bfs_1.
    # The test case calls the method bfs() with the parameter 1 and compares the result with the expected result [1, 0, 3, 2, 4, 5].
    def test_bfs_1(self):
        # Arrange
        self.graph = Graph(6)
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
        expected = [1, 0, 3, 2, 4, 5]
        # Act
        actual = self.graph.bfs(1)
        # Assert
