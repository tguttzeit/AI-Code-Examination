from py_testgen_app.src.ChatGPT.Dijkstra.BookExampleCode.T3.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def setUp(self):
        # Create an instance of the Dijkstra class for each test case
        self.dijkstra = Dijkstra(5)  # Assuming 5 vertices for the test graphs

    def test_graph1_shortest_paths(self):
        # Build the graph for Graph 1
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

        # Assert the expected shortest paths
        expected_paths = {1: 1, 2: 4, 3: 3, 4: 3}
        self.assertEqual(shortest_paths, expected_paths)

    def test_graph2_shortest_paths(self):
        # Build the graph for Graph 2
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)

        # Test shortest paths from vertex 0
        shortest_paths = self.dijkstra.find_shortest_paths(0)

        # Assert the expected shortest paths
        expected_paths = {0: 0, 1: 6, 2: 9, 3: 8, 4: 8}
        self.assertEqual(shortest_paths, expected_paths)

    def test_empty_graph_shortest_paths(self):
        # Test an empty graph
        shortest_paths = self.dijkstra.find_shortest_paths(0)

        # Assert that the result is an empty dictionary
        self.assertEqual(shortest_paths, {})
