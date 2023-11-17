from py_testgen_app.src.ChatGPT.FloydWarshall.AIGenerated.T8.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):
    def setUp(self):
        # Graph 1
        self.floydWarshall1 = FloydWarshall(5)
        self.floydWarshall1.add_edge(0, 1, 10)
        self.floydWarshall1.add_edge(0, 3, 5)
        self.floydWarshall1.add_edge(1, 3, 2)
        self.floydWarshall1.add_edge(1, 2, 1)
        self.floydWarshall1.add_edge(2, 4, 4)
        self.floydWarshall1.add_edge(3, 1, 3)
        self.floydWarshall1.add_edge(3, 2, 9)
        self.floydWarshall1.add_edge(3, 4, 2)
        self.floydWarshall1.add_edge(4, 2, 6)

        # Graph 2
        self.floydWarshall2 = FloydWarshall(5)
        self.floydWarshall2.add_edge(0, 2, 5)
        self.floydWarshall2.add_edge(1, 3, 5)
        self.floydWarshall2.add_edge(2, 3, 4)
        self.floydWarshall2.add_edge(3, 2, 4)
        self.floydWarshall2.add_edge(4, 3, 4)
        self.floydWarshall2.add_edge(2, 4, -2)

    def test_shortest_path_graph1(self):
        self.floydWarshall1.run()
        self.assertEqual(self.floydWarshall1.matrix[0][4], 7)
        self.assertEqual(self.floydWarshall1.path(0, 4), [0, 3, 4])

    def test_shortest_path_graph2(self):
        self.floydWarshall2.run()
        self.assertEqual(self.floydWarshall2.matrix[0][4], 3)
        self.assertEqual(self.floydWarshall2.path(0, 4), [0, 2, 4])

    def test_nonexistent_path(self):
        self.floydWarshall1.run()
        self.assertEqual(self.floydWarshall1.matrix[1][0], float("inf"))
        self.assertEqual(self.floydWarshall1.path(1, 0), [])
