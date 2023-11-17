from py_testgen_app.src.Copilot.FloydWarshall.BookExampleCode.T7.floyd_warshall import FloydWarshall

import unittest


class TestFloydWarshallTest(unittest.TestCase):

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
        self.assertEqual(self.floydWarshall.path(0, 4), [0, 3, 4])

    def test_path2(self):
        self.assertEqual(self.floydWarshall.path(1, 4), [1, 3, 4])

    def test_path3(self):
        self.assertEqual(self.floydWarshall.path(2, 4), [2, 4])
