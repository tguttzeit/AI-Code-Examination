from py_testgen_app.src.Copilot.BreadthFirstSearch.AIGenerated.T6.graph import Graph

import unittest

class GraphTest(unittest.TestCase):

    def test_bfs(self):
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
        self.assertEqual(self.graph.bfs(0), [0, 1, 2, 3, 4, 5])
        self.assertEqual(self.graph.bfs(1), [1, 0, 3, 2, 4, 5])
        self.assertEqual(self.graph.bfs(2), [2, 0, 3, 4, 5, 1])
        self.assertEqual(self.graph.bfs(3), [3, 1, 2, 4, 5, 0])
        self.assertEqual(self.graph.bfs(4), [4, 3, 5, 1, 2, 0])
        self.assertEqual(self.graph.bfs(5), [5, 3, 4, 1, 2, 0])
        self.assertEqual(self.graph.bfs(6), [6, 3, 4, 1, 2, 0])
        self.assertEqual(self.graph.bfs(7), [7, 3, 4, 1, 2, 0])
        self.assertEqual(self.graph.bfs(8), [8, 3, 4, 1, 2, 0])
        self.assertEqual(self.graph.bfs(9), [9, 3, 4, 1, 2, 0])
        self.assertEqual(self.graph.bfs(10), [10, 3, 4, 1, 2, 0])
        self.assertEqual(self.graph.bfs(11), [11, 3, 4, 1, 2, 0])
        self.assertEqual(self.graph.bfs(12), [12, 3
