from py_testgen_app.src.Copilot.FloydWarshall.BookExampleCode.T8.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshallTest(unittest.TestCase):
    def setUp(self):
        self.floydWarshall = FloydWarshall(5)

        # Graph 1
        self.floydWarshall.add_edge(0, 1, 10)
        self.floydWarshall.add_edge(0, 3, 5)
        self.floydWarshall.add_edge(1, 3, 2)
        self.floydWarshall.add_edge(1, 2, 1)
        self.floydWarshall.add_edge(2, 4, 4)
        self.floydWarshall.add_edge(3, 1, 3)
        self.floydWarshall.add_edge(3, 2, 9)
        self.floydWarshall.add_edge(3, 4, 2)
        self.floydWarshall.add_edge(4, 2, 6)

        # Graph 2
        self.floydWarshall.add_edge(0, 2, 5)
        self.floydWarshall.add_edge(1, 3, 5)
        self.floydWarshall.add_edge(2, 3, 4)
        self.floydWarshall.add_edge(3, 2, 4)
        self.floydWarshall.add_edge(4, 3, 4)
        self.floydWarshall.add_edge(2, 4, -2)

    # Test 1
    def test_path_1(self):
        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.path(0, 4), [0, 3, 4])

    # Test 2
    def test_path_2(self):
        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.path(0, 2), [0, 3, 1, 2])

    # Test 3
    def test_path_3(self):
        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.path(3, 0), [3, 1, 2, 4, 0])

