from py_testgen_app.src.ChatGPT.FloydWarshall.BookExampleCode.T10.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):

    def setUp(self):
        # Initialize FloydWarshall object and build Graph 1
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

    def test_shortest_path_graph1(self):
        # Test shortest path from node 0 to node 4 in Graph 1
        shortest_path = self.floydWarshall.path(0, 4)
        expected_path = [0, 3, 4]
        self.assertEqual(shortest_path, expected_path)

    def test_shortest_path_graph2(self):
        # Initialize a new FloydWarshall object and build Graph 2
        floydWarshall2 = FloydWarshall(5)
        floydWarshall2.add_edge(0, 2, 5)
        floydWarshall2.add_edge(1, 3, 5)
        floydWarshall2.add_edge(2, 3, 4)
        floydWarshall2.add_edge(3, 2, 4)
        floydWarshall2.add_edge(4, 3, 4)
        floydWarshall2.add_edge(2, 4, -2)

        # Test shortest path from node 0 to node 3 in Graph 2
        shortest_path = floydWarshall2.path(0, 3)
        expected_path = [0, 2, 3]
        self.assertEqual(shortest_path, expected_path)

    def test_shortest_path_no_path(self):
        # Test a case where there is no path from node 2 to node 0 in Graph 1
        shortest_path = self.floydWarshall.path(2, 0)
        expected_path = []
        self.assertEqual(shortest_path, expected_path)
