from py_testgen_app.src.ChatGPT.Dijkstra.AIGenerated.T7.dijkstra import Dijkstra

import unittest

class TestDijkstra(unittest.TestCase):

    def setUp(self):
        # Initialize the Dijkstra object for each test case
        self.dijkstra = Dijkstra(5)  # Assuming 5 vertices for these tests

    def test_shortest_path_graph1(self):
        # Graph 1:
        self.dijkstra.add_edge(0, 1, 1)
        self.dijkstra.add_edge(0, 2, 4)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(3, 1, 1)
        self.dijkstra.add_edge(4, 3, 3)

        shortest_paths = self.dijkstra.find_shortest_paths(0)
        
        # Test cases for expected shortest distances
        self.assertEqual(shortest_paths[1], 1)
        self.assertEqual(shortest_paths[2], 4)
        self.assertEqual(shortest_paths[3], 3)
        self.assertEqual(shortest_paths[4], 3)

    def test_shortest_path_graph2(self):
        # Graph 2:
        self.dijkstra.add_edge(0, 0, 1)
        self.dijkstra.add_edge(1, 2, 3)
        self.dijkstra.add_edge(1, 3, 2)
        self.dijkstra.add_edge(1, 4, 2)
        self.dijkstra.add_edge(3, 2, 5)
        self.dijkstra.add_edge(4, 3, 3)

        shortest_paths = self.dijkstra.find_shortest_paths(0)
        
        # Test cases for expected shortest distances
        self.assertEqual(shortest_paths[0], 0)
        self.assertEqual(shortest_paths[1], float('inf'))
        self.assertEqual(shortest_paths[2], float('inf'))
        self.assertEqual(shortest_paths[3], float('inf'))
        self.assertEqual(shortest_paths[4], float('inf'))

    def test_shortest_path_no_edges(self):
        # Test a case where there are no edges in the graph
        shortest_paths = self.dijkstra.find_shortest_paths(0)
        
        # Test case for the source vertex with no edges
        self.assertEqual(shortest_paths[0], 0)
