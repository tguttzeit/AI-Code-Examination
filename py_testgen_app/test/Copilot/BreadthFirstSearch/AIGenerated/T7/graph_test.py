from py_testgen_app.src.Copilot.BreadthFirstSearch.AIGenerated.T7.graph import Graph

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
        self.assertEqual(self.graph.bfs(0), [0, 1, 2, 3, 4, 5])

    def test_bfs2(self):
        self.assertEqual(self.graph.bfs(1), [1, 0, 3, 2, 4, 5])

    def test_bfs3(self):
        self.assertEqual(self.graph.bfs(2), [2, 0, 3, 1, 4, 5])
