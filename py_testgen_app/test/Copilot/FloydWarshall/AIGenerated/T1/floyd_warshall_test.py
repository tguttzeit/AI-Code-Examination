from py_testgen_app.src.Copilot.FloydWarshall.AIGenerated.T1.floyd_warshall import FloydWarshall

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
        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.path(0, 4), [0, 3, 4])
        self.assertEqual(self.floydWarshall.path(0, 2), [0, 3, 1, 2])
        self.assertEqual(self.floydWarshall.path(2, 0), [2, 4, 3, 1, 0])

    def test_path_non_existing(self):
        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.path(0, 0), [0])
        self.assertEqual(self.floydWarshall.path(0, 5), [])
        self.assertEqual(self.floydWarshall.path(5, 0), [])
        self.assertEqual(self.floydWarshall.path(5, 5), [5])

    def test_path_negative(self):
        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.path(4, 2), [4, 2])
        self.floydWarshall.add_edge(4, 2, -2)
        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.path(4, 2), [4, 3, 2])
