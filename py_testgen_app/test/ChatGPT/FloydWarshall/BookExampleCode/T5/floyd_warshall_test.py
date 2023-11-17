from py_testgen_app.src.ChatGPT.FloydWarshall.BookExampleCode.T5.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):

    def setUp(self):
        self.floydWarshall = FloydWarshall(5)  # Assuming 5 nodes in the graph

    def test_graph1(self):
        self.floydWarshall.add_edge(0, 1, 10)
        self.floydWarshall.add_edge(0, 3, 5)
        self.floydWarshall.add_edge(1, 3, 2)
        self.floydWarshall.add_edge(1, 2, 1)
        self.floydWarshall.add_edge(2, 4, 4)
        self.floydWarshall.add_edge(3, 1, 3)
        self.floydWarshall.add_edge(3, 2, 9)
        self.floydWarshall.add_edge(3, 4, 2)
        self.floydWarshall.add_edge(4, 2, 6)

        # Expected shortest paths
        expected_shortest_paths = [
            [0, 3, 5, 5, 7],
            [12, 0, 2, 2, 4],
            [11, 9, 0, 8, 4],
            [3, 3, 5, 0, 2],
            [13, 11, 4, 2, 0]
        ]

        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.distance, expected_shortest_paths)

    def test_graph2(self):
        self.floydWarshall.add_edge(0, 2, 5)
        self.floydWarshall.add_edge(1, 3, 5)
        self.floydWarshall.add_edge(2, 3, 4)
        self.floydWarshall.add_edge(3, 2, 4)
        self.floydWarshall.add_edge(4, 3, 4)
        self.floydWarshall.add_edge(2, 4, -2)

        # Expected shortest paths
        expected_shortest_paths = [
            [0, 7, 5, 9, 5],
            [12, 0, 8, 5, 11],
            [9, 16, 0, 4, 2],
            [12, 5, 4, 0, 4],
            [11, 18, -2, 2, 0]
        ]

        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.distance, expected_shortest_paths)

    def test_empty_graph(self):
        # Test an empty graph (no edges)
        self.floydWarshall.run()
        self.assertEqual(self.floydWarshall.distance, [[0, float('inf'), float('inf'), float('inf'), float('inf')],
                                                       [float('inf'), 0, float('inf'), float('inf'), float('inf')],
                                                       [float('inf'), float('inf'), 0, float('inf'), float('inf')],
                                                       [float('inf'), float('inf'), float('inf'), 0, float('inf')],
                                                       [float('inf'), float('inf'), float('inf'), float('inf'), 0]])

