from py_testgen_app.src.Copilot.BreadthFirstSearch.AIGenerated.T3.graph import Graph

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

    def test_bfs(self):
        self.assertEqual([0, 1, 2, 3, 4, 5], self.graph.bfs(0))
        self.assertEqual([1, 0, 3, 2, 4, 5], self.graph.bfs(1))
        self.assertEqual([2, 0, 3, 4, 5, 1], self.graph.bfs(2))
        self.assertEqual([3, 1, 2, 4, 5, 0], self.graph.bfs(3))
        self.assertEqual([4, 3, 5, 2, 1, 0], self.graph.bfs(4))
        self.assertEqual([5, 3, 4, 2, 1, 0], self.graph.bfs(5))
        self.assertRaises(ValueError, self.graph.bfs, 6)
        self.assertRaises(ValueError, self.graph.bfs, -1)
