from py_testgen_app.src.ChatGPT.FloydWarshall.PromptOnly.T4.floyd_warshall import FloydWarshall

import unittest

class FloydWarshallTest(unittest.TestCase):
    def setUp(self):
        # Create an instance of FloydWarshall for testing
        self.floydWarshall = FloydWarshall(5)  # 5 nodes in the graph

    def test_graph1_shortest_paths(self):
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

        # Run Floyd-Warshall algorithm
        self.floydWarshall

        # Test shortest paths
        self.assertEqual(self.floydWarshall.path(0, 1), [0, 3, 1])
        self.assertEqual(self.floydWarshall.path(0, 2), [0, 3, 1, 2])
        self.assertEqual(self.floydWarshall.path(0, 3), [0, 3])
        self.assertEqual(self.floydWarshall.path(0, 4), [0, 3, 4])

    def test_graph2_shortest_paths(self):
        # Build graph 2
        self.floydWarshall.add_edge(0, 2, 5)
        self.floydWarshall.add_edge(1, 3, 5)
        self.floydWarshall.add_edge(2, 3, 4)
        self.floydWarshall.add_edge(3, 2, 4)
        self.floydWarshall.add_edge(4, 3, 4)
        self.floydWarshall.add_edge(2, 4, -2)

        # Run Floyd-Warshall algorithm
        self.floydWarshall

        # Test shortest paths
        self.assertEqual(self.floydWarshall.path(0, 1), [])
        self.assertEqual(self.floydWarshall.path(0, 2), [0, 2])
        self.assertEqual(self.floydWarshall.path(0, 3), [0, 2, 3])
        self.assertEqual(self.floydWarshall.path(0, 4), [0, 2, 4])

    def test_same_node(self):
        # Test when source and destination are the same node
        self.assertEqual(self.floydWarshall.path(0, 0), [])
