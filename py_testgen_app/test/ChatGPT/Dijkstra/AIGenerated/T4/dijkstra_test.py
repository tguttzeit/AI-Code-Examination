from py_testgen_app.src.ChatGPT.Dijkstra.AIGenerated.T4.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):
    def setUp(self):
        # Initialize a Dijkstra object for each test case
        self.dijkstra = Dijkstra(5)  # Assumes 5 vertices for both graphs

    def test_shortest_paths_graph1(self):
        # Build Graph 1
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        # Calculate shortest paths from vertex 0
        shortest_paths = self.dijkstra.find_shortest_paths(0)

        # Expected shortest paths
        expected_paths = {1: 1, 2: 4, 3: 3, 4: 3}
        
        self.assertEqual(shortest_paths, expected_paths)

    def test_shortest_paths_graph2(self):
        # Build Graph 2
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)

        # Calculate shortest paths from vertex 0
        shortest_paths = self.dijkstra.find_shortest_paths(0)

        # Expected shortest paths
        expected_paths = {0: 0, 2: float('inf'), 3: float('inf'), 4: float('inf')}
        
        self.assertEqual(shortest_paths, expected_paths)

    def test_shortest_paths_invalid_vertex(self):
        # Build a simple graph
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(1, 2, 2)

        # Try to calculate shortest paths from an invalid vertex
        with self.assertRaises(IndexError):
            self.dijkstra.find_shortest_paths(3)  # Vertex 3 does not exist
