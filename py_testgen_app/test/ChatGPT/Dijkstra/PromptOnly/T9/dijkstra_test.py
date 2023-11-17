from py_testgen_app.src.ChatGPT.Dijkstra.PromptOnly.T9.dijkstra import Dijkstra

import unittest

class DijkstraTest(unittest.TestCase):
    def setUp(self):
        # Initialize the Dijkstra object for testing
        self.dijkstra = Dijkstra(5)  # Assuming 5 vertices for both graphs

    def test_graph_1_shortest_paths(self):
        # Build Graph 1
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        # Test shortest paths from vertex 0
        shortest_paths = self.dijkstra.find_shortest_paths(0)
        expected_paths = {1: [0, 1], 2: [0, 1, 2], 3: [0, 1, 3], 4: [0, 1, 4]}
        self.assertEqual(shortest_paths, expected_paths)

    def test_graph_2_shortest_paths(self):
        # Build Graph 2
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)

        # Test shortest paths from vertex 0
        shortest_paths = self.dijkstra.find_shortest_paths(0)
        expected_paths = {0: [0], 1: [0, 1], 2: [0, 1, 2], 3: [0, 1, 3], 4: [0, 1, 4]}
        self.assertEqual(shortest_paths, expected_paths)

    def test_no_path(self):
        # Test a graph with no path from source to destination
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(1, 2, 2)
        self.dijkstra.add_edge(2, 3, 3)

        # Test shortest paths from vertex 0 to vertex 3 (no path)
        shortest_paths = self.dijkstra.find_shortest_paths(0)
        expected_paths = {1: [0, 1]}
        self.assertEqual(shortest_paths, expected_paths)
