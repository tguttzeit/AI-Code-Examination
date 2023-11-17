from py_testgen_app.src.Copilot.FloydWarshall.BookExampleCode.T1.floyd_warshall import FloydWarshall

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

    def test1(self):
        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.distance[0][1], 8)
        self.assertEqual(self.floydWarshall.distance[0][2], 9)
        self.assertEqual(self.floydWarshall.distance[0][3], 5)
        self.assertEqual(self.floydWarshall.distance[0][4], 7)
        self.assertEqual(self.floydWarshall.distance[1][0], 12)
        self.assertEqual(self.floydWarshall.distance[1][2], 1)
        self.assertEqual(self.floydWarshall.distance[1][3], 3)
        self.assertEqual(self.floydWarshall.distance[1][4], 5)
        self.assertEqual(self.floydWarshall.distance[2][0], 11)
        self.assertEqual(self.floydWarshall.distance[2][1], 10)
        self.assertEqual(self.floydWarshall.distance[2][3], 8)
        self.assertEqual(self.floydWarshall.distance[2][4], 4)
        self.assertEqual(self.floydWarshall.distance[3][0], 5)
        self.assertEqual(self.floydWarshall.distance[3][1], 3)
        self.assertEqual(self.floydWarshall.distance[3][2], 9)
        self.assertEqual(self.floydWarshall.distance[3][4], 2)
        self.assertEqual(self.floydWarshall.distance[4][0], 9)
        self.assertEqual(self.floydWarshall.distance[4][1], 7)