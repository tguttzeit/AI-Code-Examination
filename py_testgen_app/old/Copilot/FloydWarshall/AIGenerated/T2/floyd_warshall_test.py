from py_testgen_app.src.Copilot.FloydWarshall.AIGenerated.T2.floyd_warshall import FloydWarshall

import unittest

class FloydWarshallTest(unittest.TestCase):
    def setUp(self):
        self.floydWarshall = FloydWarshall(5)

    def test_case1(self):
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
        self.assertEqual(self.floydWarshall.matrix, [[0, 8, 9, 5, 7], [10, 0, 1, 3, 5], [11, 1, 0, 4, 6], [5, 3, 4, 0, 2], [11, 9, 6, 2, 0]])
        self.assertEqual(self.floydWarshall.path(0, 4), [0, 3, 4])

    def test_case2(self):
        self.floydWarshall.add_edge(0, 2, 5)
        self.floydWarshall.add_edge(1, 3, 5)
        self.floydWarshall.add_edge(2, 3, 4)
        self.floydWarshall.add_edge(3, 2, 4)
        self.floydWarshall.add_edge(4, 3, 4)
        self.floydWarshall.add_edge(2, 4, -2)
        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.matrix, [[0, float("inf"), 5, float("inf"), float("inf")], [float("inf"), 0, float("inf"), 5, float("inf")], [float("inf"), float("inf"), 0, 4, 2], [float("inf"), float("inf"), 4, 0, 4], [float
