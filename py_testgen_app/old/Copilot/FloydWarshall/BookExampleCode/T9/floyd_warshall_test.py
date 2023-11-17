from py_testgen_app.src.Copilot.FloydWarshall.BookExampleCode.T9.floyd_warshall import FloydWarshall

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

        self.floydWarshall2 = FloydWarshall(5)

        self.floydWarshall2.add_edge(0, 2, 5)
        self.floydWarshall2.add_edge(1, 3, 5)
        self.floydWarshall2.add_edge(2, 3, 4)
        self.floydWarshall2.add_edge(3, 2, 4)
        self.floydWarshall2.add_edge(4, 3, 4)
        self.floydWarshall2.add_edge(2, 4, -2)

        self.floydWarshall3 = FloydWarshall(5)

        self.floydWarshall3.add_edge(0, 1, 10)
        self.floydWarshall3.add_edge(0, 3, 5)
        self.floydWarshall3.add_edge(1, 3, 2)
        self.floydWarshall3.add_edge(1, 2, 1)
        self.floydWarshall3.add_edge(2, 4, 4)
        self.floydWarshall3.add_edge(3, 1, 3)
        self.floydWarshall3.add_edge(3, 2, 9)
        self.floydWarshall3.add_edge(3, 4, 2)
        self.floydWarshall3.add_edge(4, 2, 6)

    def test_floyd_warshall(self):
        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.distance, [[0,