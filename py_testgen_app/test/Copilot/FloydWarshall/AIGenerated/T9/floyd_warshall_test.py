from py_testgen_app.src.Copilot.FloydWarshall.AIGenerated.T9.floyd_warshall import FloydWarshall

import unittest

class FloydWarshallTest(unittest.TestCase):
    def setUp(self):
        self.floydWarshall = FloydWarshall(5)

    def test_graph1(self):
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

        self.assertEqual(self.floydWarshall.matrix[0][0], 0)
        self.assertEqual(self.floydWarshall.matrix[0][1], 8)
        self.assertEqual(self.floydWarshall.matrix[0][2], 9)
        self.assertEqual(self.floydWarshall.matrix[0][3], 5)
        self.assertEqual(self.floydWarshall.matrix[0][4], 7)
        self.assertEqual(self.floydWarshall.matrix[1][0], 12)
        self.assertEqual(self.floydWarshall.matrix[1][1], 0)
        self.assertEqual(self.floydWarshall.matrix[1][2], 1)
        self.assertEqual(self.floydWarshall.matrix[1][3], 3)
        self.assertEqual(self.floydWarshall.matrix[1][4], 5)
        self.assertEqual(self.floydWarshall.matrix[2][0], 11)
        self.assertEqual(self.floydWarshall.matrix[2][1], 9)
        self.assertEqual(self.floydWarshall.matrix[2][2], 0)
        self.assertEqual(self.floydWarshall.matrix[2][3], 10)
        self.assertEqual(self.floydWarshall.matrix[2][4], 4)
        self.assertEqual(self.floydWarshall.matrix[3][0], 5)
        self.assertEqual(self.floydWarshall.matrix[3][1], 3)
        self.assertEqual(self.floydWarshall.matrix[3][2], 4)