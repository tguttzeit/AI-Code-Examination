from py_testgen_app.src.ChatGPT.FloydWarshall.AIGenerated.T5.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):
    def setUp(self):
        # Initialize the FloydWarshall instance for each test case
        self.floydWarshall = FloydWarshall(5)  # Assuming there are 5 nodes in the graph

    def test_graph_1(self):
        # Build graph 1
        self.floydWarshall.add_edge(0, 1, 10)
        self.floydWarshall.add_edge(0, 3, 5)
        self.floydWarshall.add_edge(1, 3, 2)
        self.floydWarshall.add_edge(1, 2, 1)
        self.floydWarshall.add_edge(2, 4, 4)
        self.floydWarshall.add_edge(3, 1, 3)
        self.floydWarshall.add_edge(3, 2, 9)
        self.floydWarshall.add_edge(3, 4, 2)
        self.floydWarshall.add_edge(4, 2, 6)

        # Run the algorithm
        self.floydWarshall.run()

        # Test shortest paths
        self.assertEqual(self.floydWarshall.path(0, 4), [0, 3, 4])
        self.assertEqual(self.floydWarshall.path(1, 4), [1, 3, 4])
        self.assertEqual(self.floydWarshall.path(2, 0), [2, 4, 3, 0])

    def test_graph_2(self):
        # Build graph 2
        self.floydWarshall.add_edge(0, 2, 5)
        self.floydWarshall.add_edge(1, 3, 5)
        self.floydWarshall.add_edge(2, 3, 4)
        self.floydWarshall.add_edge(3, 2, 4)
        self.floydWarshall.add_edge(4, 3, 4)
        self.floydWarshall.add_edge(2, 4, -2)

        # Run the algorithm
        self.floydWarshall.run()

        # Test shortest paths
        self.assertEqual(self.floydWarshall.path(0, 4), [0, 2, 4])
        self.assertEqual(self.floydWarshall.path(1, 3), [1, 3])
        self.assertEqual(self.floydWarshall.path(2, 1), [2, 4, 3, 1])

    def test_empty_graph(self):
        # Test an empty graph
        self.floydWarshall.run()

        # Verify that all paths are empty
        for i in range(5):
            for j in range(5):
                self.assertEqual(self.floydWarshall.path(i, j), [])
