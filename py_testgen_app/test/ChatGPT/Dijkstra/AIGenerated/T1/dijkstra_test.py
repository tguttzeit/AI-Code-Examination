from py_testgen_app.src.ChatGPT.Dijkstra.AIGenerated.T1.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):
    def setUp(self):
        # Create a Dijkstra object for each test case
        self.dijkstra = Dijkstra(5)  # Assuming 5 vertices in the graph

    def test_shortest_path_graph1_case1(self):
        # Graph 1
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
        
        # Verify the shortest paths
        expected_paths = {1: 1, 2: 4, 3: 3, 4: float('inf')}
        self.assertEqual(shortest_paths, expected_paths)

    def test_shortest_path_graph2_case1(self):
        # Graph 2
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)
        
        # Test shortest paths from vertex 0
        shortest_paths = self.dijkstra.find_shortest_paths(0)
        
        # Verify the shortest paths
        expected_paths = {0: 0, 1: float('inf'), 2: float('inf'), 3: float('inf'), 4: float('inf')}
        self.assertEqual(shortest_paths, expected_paths)

    def test_shortest_path_graph2_case2(self):
        # Graph 2
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)
        
        # Test shortest paths from vertex 1
        shortest_paths = self.dijkstra.find_shortest_paths(1)
        
        # Verify the shortest paths
        expected_paths = {0: float('inf'), 1: 0, 2: 3, 3: 2, 4: 2}
        self.assertEqual(shortest_paths, expected_paths)
