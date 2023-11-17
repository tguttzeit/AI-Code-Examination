from py_testgen_app.src.ChatGPT.FloydWarshall.BookExampleCode.T7.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):

    def setUp(self):
        # Create an instance of the FloydWarshall class for testing
        self.floydWarshall = FloydWarshall(5)  # 5 nodes for both graphs

        # Graph 1:
        self.floydWarshall.add_edge(0, 1, 10)
        self.floydWarshall.add_edge(0, 3, 5)
        self.floydWarshall.add_edge(1, 3, 2)
        self.floydWarshall.add_edge(1, 2, 1)
        self.floydWarshall.add_edge(2, 4, 4)
        self.floydWarshall.add_edge(3, 1, 3)
        self.floydWarshall.add_edge(3, 2, 9)
        self.floydWarshall.add_edge(3, 4, 2)
        self.floydWarshall.add_edge(4, 2, 6)

        # Graph 2:
        self.floydWarshall.add_edge(0, 2, 5)
        self.floydWarshall.add_edge(1, 3, 5)
        self.floydWarshall.add_edge(2, 3, 4)
        self.floydWarshall.add_edge(3, 2, 4)
        self.floydWarshall.add_edge(4, 3, 4)
        self.floydWarshall.add_edge(2, 4, -2)

    def test_shortest_path_graph1(self):
        # Test shortest path in Graph 1
        shortest_path = self.floydWarshall.path(0, 4)
        self.assertEqual(shortest_path, [0, 3, 4])

    def test_shortest_path_graph2(self):
        # Test shortest path in Graph 2
        shortest_path = self.floydWarshall.path(0, 3)
        self.assertEqual(shortest_path, [0, 2, 3])

    def test_shortest_path_nonexistent(self):
        # Test shortest path for nodes with no path in Graph 1
        shortest_path = self.floydWarshall.path(4, 0)
        self.assertEqual(shortest_path, [])
