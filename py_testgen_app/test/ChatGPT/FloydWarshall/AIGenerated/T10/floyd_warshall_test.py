from py_testgen_app.src.ChatGPT.FloydWarshall.AIGenerated.T10.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):
    def setUp(self):
        # Create an instance of FloydWarshall for each test case
        self.floydWarshall1 = FloydWarshall(5)
        self.floydWarshall2 = FloydWarshall(5)

        # Graph 1
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
        self.floydWarshall2.add_edge(0, 2, 5)
        self.floydWarshall2.add_edge(1, 3, 5)
        self.floydWarshall2.add_edge(2, 3, 4)
        self.floydWarshall2.add_edge(3, 2, 4)
        self.floydWarshall2.add_edge(4, 3, 4)
        self.floydWarshall2.add_edge(2, 4, -2)

    def test_shortest_path_graph1_0_to_4(self):
        shortest_path = self.floydWarshall1.path(0, 4)
        self.assertEqual(shortest_path, [0, 3, 4])

    def test_shortest_path_graph2_1_to_4(self):
        shortest_path = self.floydWarshall2.path(1, 4)
        self.assertEqual(shortest_path, [1, 3, 2, 4])

    def test_shortest_path_graph1_2_to_0(self):
        shortest_path = self.floydWarshall1.path(2, 0)
        self.assertEqual(shortest_path, [2, 4, 3, 0])
