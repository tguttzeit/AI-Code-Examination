from py_testgen_app.src.ChatGPT.FloydWarshall.BookExampleCode.T3.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):

    def setUp(self):
        # Create an instance of the FloydWarshall class for each test case
        self.floydWarshall = FloydWarshall(5)  # Assuming 5 nodes

    def test_graph_1(self):
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

        # Run the algorithm
        self.floydWarshall.run()

        # Test case 1: Check the shortest path from node 0 to node 4
        shortest_path = self.floydWarshall.path(0, 4)
        self.assertEqual(shortest_path, [0, 3, 4])

    def test_graph_2(self):
        # Build Graph 2
        self.floydWarshall.add_edge(0, 2, 5)
        self.floydWarshall.add_edge(1, 3, 5)
        self.floydWarshall.add_edge(2, 3, 4)
        self.floydWarshall.add_edge(3, 2, 4)
        self.floydWarshall.add_edge(4, 3, 4)
        self.floydWarshall.add_edge(2, 4, -2)

        # Run the algorithm
        self.floydWarshall.run()

        # Test case 2: Check the shortest path from node 1 to node 2
        shortest_path = self.floydWarshall.path(1, 2)
        self.assertEqual(shortest_path, [1, 3, 2])

    def test_no_path(self):
        # Test case 3: Check when there is no path between nodes 0 and 4
        shortest_path = self.floydWarshall.path(0, 4)
        self.assertEqual(shortest_path, [])
