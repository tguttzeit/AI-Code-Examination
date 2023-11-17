from py_testgen_app.src.ChatGPT.FloydWarshall.AIGenerated.T6.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):
    def setUp(self):
        # Create an instance of the FloydWarshall class for each test case
        self.floydWarshall1 = FloydWarshall(5)
        self.floydWarshall2 = FloydWarshall(5)

        # Graph 1 edges and weights
        self.floydWarshall1.add_edge(0, 1, 10)
        self.floydWarshall1.add_edge(0, 3, 5)
        self.floydWarshall1.add_edge(1, 3, 2)
        self.floydWarshall1.add_edge(1, 2, 1)
        self.floydWarshall1.add_edge(2, 4, 4)
        self.floydWarshall1.add_edge(3, 1, 3)
        self.floydWarshall1.add_edge(3, 2, 9)
        self.floydWarshall1.add_edge(3, 4, 2)
        self.floydWarshall1.add_edge(4, 2, 6)

        # Graph 2 edges and weights
        self.floydWarshall2.add_edge(0, 2, 5)
        self.floydWarshall2.add_edge(1, 3, 5)
        self.floydWarshall2.add_edge(2, 3, 4)
        self.floydWarshall2.add_edge(3, 2, 4)
        self.floydWarshall2.add_edge(4, 3, 4)
        self.floydWarshall2.add_edge(2, 4, -2)

    def test_graph1_shortest_path(self):
        self.floydWarshall1.run()
        self.assertEqual(self.floydWarshall1.path(0, 4), [0, 3, 4])

    def test_graph2_shortest_path(self):
        self.floydWarshall2.run()
        self.assertEqual(self.floydWarshall2.path(0, 3), [0, 2, 3])

    def test_graph2_negative_cycle(self):
        self.floydWarshall2.run()
        # There is a negative cycle in graph 2, so the shortest path should return an empty list
        self.assertEqual(self.floydWarshall2.path(2, 0), [])
