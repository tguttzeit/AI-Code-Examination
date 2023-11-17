from py_testgen_app.src.Copilot.BreadthFirstSearch.PromptOnly.T3.graph import Graph

import unittest

class GraphTest(unittest.TestCase):
    def setUp(self):
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

    # Test case 1: Test the bfs() method with vertex 0.
    # The expected output is [0, 1, 2, 3, 4, 5].
    def test_bfs_1(self):
        self.assertEqual(self.graph.bfs(0), [0, 1, 2, 3, 4, 5])

    # Test case 2: Test the bfs() method with vertex 3.
    # The expected output is [3, 1, 2, 4, 5, 0].
    def test_bfs_2(self):
        self.assertEqual(self.graph.bfs(3), [3, 1, 2, 4, 5, 0])

    # Test case 3: Test the bfs() method with vertex 5.
    # The expected output is [5, 3, 1, 2, 4, 0].
    def test_bfs_3(self):
        self.assertEqual(self.graph.bfs(5), [5, 3, 1, 2, 4, 0])
