from py_testgen_app.src.ChatGPT.FloydWarshall.AIGenerated.T9.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):
    def setUp(self):
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
        
    def test_shortest_path_graph1(self):
        shortest_path = self.floydWarshall1.path(0, 4)
        self.assertEqual(shortest_path, [0, 3, 4])

    def test_shortest_path_graph2(self):
        shortest_path = self.floydWarshall2.path(0, 3)
        self.assertEqual(shortest_path, [0, 2, 3])

    def test_shortest_path_graph2_negative_weight(self):
        shortest_path = self.floydWarshall2.path(4, 0)
        self.assertEqual(shortest_path, [])
