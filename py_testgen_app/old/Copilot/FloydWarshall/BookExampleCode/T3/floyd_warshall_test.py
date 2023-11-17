from py_testgen_app.src.Copilot.FloydWarshall.BookExampleCode.T3.floyd_warshall import FloydWarshall

import unittest

class FloydWarshallTest(unittest.TestCase):
    def setUp(self):
        self.floydWarshall = FloydWarshall(5)
        self.graph_1 = [
            [0, 10, 100, 5, 100],
            [100, 0, 1, 2, 100],
            [100, 100, 0, 100, 4],
            [100, 3, 9, 0, 2],
            [100, 100, 6, 100, 0],
        ]
        self.graph_2 = [
            [0, 100, 5, 100, 100],
            [100, 0, 100, 5, 100],
            [100, 100, 0, 4, -2],
            [100, 100, 100, 0, 4],
            [100, 100, 100, 100, 0],
        ]

    def test_add_edge(self):
        self.floydWarshall.add_edge(0, 1, 10)
        self.floydWarshall.add_edge(0, 3, 5)
        self.floydWarshall.add_edge(1, 3, 2)
        self.floydWarshall.add_edge(1, 2, 1)
        self.floydWarshall.add_edge(2, 4, 4)
        self.floydWarshall.add_edge(3, 1, 3)
        self.floydWarshall.add_edge(3, 2, 9)
        self.floydWarshall.add_edge(3, 4, 2)
        self.floydWarshall.add_edge(4, 2, 6)

        self.assertEqual(self.floydWarshall.graph, self.graph_1)

        self.floydWarshall = FloydWarshall(5)
        self.floydWarshall.add_edge(0, 2, 5)
        self.floydWarshall.add_edge(1, 3, 5)
        self.floydWarshall.add_edge(2, 3, 4)
        self.floydWarshall.add_edge(3, 2, 4)
        self.floydWarshall.add_edge(4, 3, 4)
        self.floydWarshall.add_edge(2, 4, -2)

        self.assertEqual(self.floydWarshall.graph, self.graph_