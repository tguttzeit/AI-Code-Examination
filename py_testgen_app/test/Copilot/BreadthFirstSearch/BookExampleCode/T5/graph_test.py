from py_testgen_app.src.Copilot.BreadthFirstSearch.BookExampleCode.T5.graph import Graph

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

    def test_bfs_0(self):
        expected = [0, 1, 2, 3, 4, 5]
        actual = self.graph.bfs(0)
        self.assertEqual(expected, actual)

    def test_bfs_1(self):
        expected = [1, 0, 3, 2, 4, 5]
        actual = self.graph.bfs(1)
        self.assertEqual(expected, actual)

    def test_bfs_2(self):
        expected = [2, 0, 3, 1, 4, 5]
        actual = self.graph.bfs(2)
        self.assertEqual(expected, actual)

    def test_bfs_3(self):
        expected = [3, 1, 2, 4, 5]
        actual = self.graph.bfs(3)
        self.assertEqual(expected, actual)

    def test_bfs_4(self):
        expected = [4, 3, 5]
        actual = self.graph.bfs(4)
        self.assertEqual(expected, actual)

    def test_bfs_5(self):
        expected = [5, 3, 4]
        actual = self.graph.bfs(5)
        self.assertEqual(expected, actual)
