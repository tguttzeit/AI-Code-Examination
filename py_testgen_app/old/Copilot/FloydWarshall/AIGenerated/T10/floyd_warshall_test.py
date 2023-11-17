from py_testgen_app.src.Copilot.FloydWarshall.AIGenerated.T10.floyd_warshall import FloydWarshall

import unittest

class FloydWarshallTest(unittest.TestCase):
    def setUp(self):
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

    def test_path(self):
        self.assertEqual([0, 3, 4], self.floydWarshall.path(0, 4))
        self.assertEqual([0, 3, 1, 2, 4], self.floydWarshall.path(0, 4))
        self.assertEqual([0, 3, 1, 2], self.floydWarshall.path(0, 3))

    def test_run(self):
        self.floydWarshall.run()
        self.assertEqual(0, self.floydWarshall.matrix[0][0])
        self.assertEqual(8, self.floydWarshall.matrix[0][1])
        self.assertEqual(9, self.floydWarshall.matrix[0][2])
        self.assertEqual(5, self.floydWarshall.matrix[0][3])
        self.assertEqual(7, self.floydWarshall.matrix[0][4])
        self.assertEqual(10, self.floydWarshall.matrix[1][0])
        self.assertEqual(0, self.floydWarshall.matrix[1][1])
        self.assertEqual(1, self.floydWarshall.matrix[1][2])
        self.assertEqual(3, self.floydWarshall.matrix[1][3])
        self.assertEqual(5, self.floydWarshall.matrix[1][4])
        self.assertEqual(11, self.floydWarshall.matrix[2][0])
        self.assertEqual(9, self.floydWarshall.matrix[2][1])
        self.assertEqual(0, self.floydWarshall.matrix[2][2])
        self.assertEqual(8,