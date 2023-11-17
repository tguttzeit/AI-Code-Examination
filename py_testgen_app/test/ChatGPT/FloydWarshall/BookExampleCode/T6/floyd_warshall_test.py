from py_testgen_app.src.ChatGPT.FloydWarshall.BookExampleCode.T6.floyd_warshall import FloydWarshall

import unittest

class TestFloydWarshall(unittest.TestCase):

    def setUp(self):
        # Initialize the FloydWarshall instance for testing
        self.floydWarshall = FloydWarshall(5)

    def test_graph_1_shortest_path(self):
        self.floydWarshall.add_edge(0, 1, 10)
        self.floydWarshall.add_edge(0, 3, 5)
        self.floydWarshall.add_edge(1, 3, 2)
        self.floydWarshall.add_edge(1, 2, 1)
        self.floydWarshall.add_edge(2, 4, 4)
        self.floydWarshall.add_edge(3, 1, 3)
        self.floydWarshall.add_edge(3, 2, 9)
        self.floydWarshall.add_edge(3, 4, 2)
        self.floydWarshall.add_edge(4, 2, 6)

        self.floydWarshall.run()

        # Test shortest path from node 0 to node 4
        shortest_path = self.floydWarshall.path(0, 4)
        self.assertEqual(shortest_path, [0, 3, 4])

    def test_graph_2_shortest_path(self):
        self.floydWarshall.add_edge(0, 2, 5)
        self.floydWarshall.add_edge(1, 3, 5)
        self.floydWarshall.add_edge(2, 3, 4)
        self.floydWarshall.add_edge(3, 2, 4)
        self.floydWarshall.add_edge(4, 3, 4)
        self.floydWarshall.add_edge(2, 4, -2)

        self.floydWarshall.run()

        # Test shortest path from node 0 to node 3
        shortest_path = self.floydWarshall.path(0, 3)
        self.assertEqual(shortest_path, [0, 2, 3])

    def test_nonexistent_path(self):
        self.floydWarshall.add_edge(0, 1, 10)
        self.floydWarshall.add_edge(1, 2, 5)

        self.floydWarshall.run()

        # Test a path that does not exist
        shortest_path = self.floydWarshall.path(0, 4)
        self.assertEqual(shortest_path, [])
