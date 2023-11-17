from py_testgen_app.src.Copilot.BreadthFirstSearch.AIGenerated.T8.graph import Graph

import unittest


class GraphTest(unittest.TestCase):

    def setUp(self):
        self.graph = Graph(5)
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

    def test_bfs_1(self):
        self.assertEqual(self.graph.bfs(0), [0, 1, 2, 3, 4, 5])

    def test_bfs_2(self):
        self.assertEqual(self.graph.bfs(1), [1, 0, 3, 2, 4, 5])

    def test_bfs_3(self):
        self.assertEqual(self.graph.bfs(2), [2, 0, 3, 1, 4, 5])

    def test_bfs_4(self):
        self.assertEqual(self.graph.bfs(3), [3, 1, 2, 4, 5, 0])

    def test_bfs_5(self):
        self.assertEqual(self.graph.bfs(4), [4, 3, 5, 0, 1, 2])

    def test_bfs_6(self):
        self.assertEqual(self.graph.bfs(5), [5, 3, 4, 0, 1, 2])

    def test_bfs_7(self):
        self.assertEqual(self.graph.bfs(6), [6, 3, 4, 5, 0, 1, 2])

    def test_bfs_8(self):
        self.assertEqual(self.graph.bfs(7), [7, 3, 4, 5, 0, 1, 2])

    def test_bfs_9(self):
        self.assertEqual(self.graph.bfs(8), [8, 3, 4, 5, 0, 1, 2])

    def test_bfs_10(self):
        x=0
