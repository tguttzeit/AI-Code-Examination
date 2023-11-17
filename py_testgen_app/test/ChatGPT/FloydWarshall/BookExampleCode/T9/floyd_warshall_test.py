from py_testgen_app.src.ChatGPT.FloydWarshall.BookExampleCode.T9.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):

    def setUp(self):
        # Initialize the FloydWarshall instance for each test case
        self.floydWarshall = FloydWarshall(5)  # Assuming there are 5 nodes

        # Build Graph 1
        self.floydWarshall.add_edge(0, 1, 10)
        self.floydWarshall.add_edge(0, 3, 5)
        self.floydWarshall.add_edge(1, 3, 2)
        self.floydWarshall.add_edge(1, 2, 1)
        self.floydWarshall.add_edge(2, 4, 4)
        self.floydWarshall.add_edge(3, 1, 3)
        self.floydWarshall.add_edge(3, 2, 9)
        self.floydWarshall.add_edge(3, 4, 2)
        self.floydWarshall.add_edge(4, 2, 6)

        # Build Graph 2
        self.floydWarshall2 = FloydWarshall(5)  # Assuming there are 5 nodes
        self.floydWarshall2.add_edge(0, 2, 5)
        self.floydWarshall2.add_edge(1, 3, 5)
        self.floydWarshall2.add_edge(2, 3, 4)
        self.floydWarshall2.add_edge(3, 2, 4)
        self.floydWarshall2.add_edge(4, 3, 4)
        self.floydWarshall2.add_edge(2, 4, -2)

    def test_shortest_path_graph1(self):
        # Test shortest path in Graph 1
        shortest_path = self.floydWarshall.path(0, 4)
        self.assertEqual(shortest_path, [0, 3, 4])

    def test_shortest_path_graph2(self):
        # Test shortest path in Graph 2
        shortest_path = self.floydWarshall2.path(0, 3)
        self.assertEqual(shortest_path, [0, 2, 3])

    def test_distance_matrix_graph1(self):
        # Test the distance matrix in Graph 1
        self.floydWarshall.run()
        expected_distance_matrix = [
            [0, 8, 7, 5, 7],
            [12, 0, 9, 2, 4],
            [10, 8, 0, 10, 12],
            [5, 3, 2, 0, 2],
            [13, 11, 6, 8, 0]
        ]
        self.assertEqual(self.floydWarshall.distance, expected_distance_matrix)

    def test_distance_matrix_graph2(self):
        # Test the distance matrix in Graph 2
        self.floydWarshall2.run()
        expected_distance_matrix = [
            [0, float('inf'), 5, 9, 7],
            [float('inf'), 0, float('inf'), 5, float('inf')],
            [float('inf'), float('inf'), 0, 4, 2],
            [float('inf'), float('inf'), 4, 0, 4],
            [float('inf'), float('inf'), float('inf'), float('inf'), 0]
        ]
        self.assertEqual(self.floydWarshall2.distance, expected_distance_matrix)
