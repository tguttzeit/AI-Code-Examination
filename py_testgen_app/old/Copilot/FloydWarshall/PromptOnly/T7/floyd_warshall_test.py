from py_testgen_app.src.Copilot.FloydWarshall.PromptOnly.T7.floyd_warshall import FloydWarshall

import unittest

class FloydWarshallTest(unittest.TestCase):
    def test_graph_1(self):
        self.floydWarshall = FloydWarshall(5)
        self.floydWarshall.add_edge(0, 1, 10)
        self.floydWarshall.add_edge(0, 3, 5)
        self.floydWarshall.add_edge(1, 3, 2)
        self.floydWarshall.add_edge(1, 2, 1)
        self.floydWarshall.add_edge(2, 4, 4)
        self.floydWarshall.add_edge(3, 1, 3)
        self.floydWarshall.add_edge(3, 2, 9)
        self.floydWarshall.add_edge(3, 4, 2)
        self.floydWarshall.add_edge(4, 2, 6)
        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.path(0, 1), [0, 1])
        self.assertEqual(self.floydWarshall.path(0, 2), [0, 1, 2])
        self.assertEqual(self.floydWarshall.path(0, 3), [0, 1, 3])
        self.assertEqual(self.floydWarshall.path(0, 4), [0, 1, 3, 4])
        self.assertEqual(self.floydWarshall.path(1, 0), [1, 3, 4, 2, 0])
        self.assertEqual(self.floydWarshall.path(1, 2), [1, 2])
        self.assertEqual(self.floydWarshall.path(1, 3), [1, 3])
        self.assertEqual(self.floydWarshall.path(1, 4), [1, 3, 4])
        self.assertEqual(self.floydWarshall.path(2, 0), [2, 0])
        self.assertEqual(self.floydWarshall.path(2, 1), [2, 0, 1])
        self.assertEqual(self.floydWarshall.path(2, 3), [2, 0, 1, 3])
        self.assertEqual(self.floydWarshall.path(2, 4), [2, 0, 1, 3, 4])
        self.assertEqual(self.floydWarshall.path(3, 0), [3, 4, 2