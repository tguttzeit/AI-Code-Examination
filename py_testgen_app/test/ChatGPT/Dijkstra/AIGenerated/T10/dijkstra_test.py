from py_testgen_app.src.ChatGPT.Dijkstra.AIGenerated.T10.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def setUp(self):
        self.dijkstra = Dijkstra(5)  # Assuming 5 vertices for both graphs

    def test_shortest_path_graph1(self):
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        shortest_paths = self.dijkstra.find_shortest_paths(0)
        
        # Verify the shortest paths for Graph 1
        self.assertEqual(shortest_paths, {1: 1, 2: 4, 3: 3, 4: 3})

    def test_shortest_path_graph2(self):
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)

        shortest_paths = self.dijkstra.find_shortest_paths(0)
        
        # Verify the shortest paths for Graph 2
        self.assertEqual(shortest_paths, {0: 0, 1: 1, 2: 4, 3: 3, 4: 3})

    def test_shortest_path_no_edges(self):
        shortest_paths = self.dijkstra.find_shortest_paths(0)
        
        # Verify that for a graph with no edges, the only shortest path is to itself with weight 0
        self.assertEqual(shortest_paths, {0: 0})
