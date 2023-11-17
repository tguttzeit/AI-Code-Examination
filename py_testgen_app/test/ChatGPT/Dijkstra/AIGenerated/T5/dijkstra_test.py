from py_testgen_app.src.ChatGPT.Dijkstra.AIGenerated.T5.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def setUp(self):
        self.dijkstra = Dijkstra(5)  # Initialize a Dijkstra instance for a 5-vertex graph

    def test_shortest_path_graph1(self):
        # Build graph 1
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        # Find shortest paths from vertex 0
        result = self.dijkstra.find_shortest_paths(0)

        # Verify the expected shortest paths
        expected_result = {1: 1, 2: 4, 3: 3, 4: 3}
        self.assertEqual(result, expected_result)

    def test_shortest_path_graph2(self):
        # Build graph 2
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)

        # Find shortest paths from vertex 0
        result = self.dijkstra.find_shortest_paths(0)

        # Verify the expected shortest paths
        expected_result = {1: 0, 2: float('inf'), 3: float('inf'), 4: float('inf')}
        self.assertEqual(result, expected_result)

    def test_shortest_path_empty_graph(self):
        # Test with an empty graph
        result = self.dijkstra.find_shortest_paths(0)

        # Verify that there are no paths (empty graph)
        expected_result = {}
        self.assertEqual(result, expected_result)
